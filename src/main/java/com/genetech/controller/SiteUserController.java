package com.genetech.controller;

import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.bean.User;
import com.genetech.bean.dto.SiteUserDto;
import com.genetech.bean.dto.UserDto;
import com.genetech.constant.ReturnCode;
import com.genetech.exception.CustomException;
import com.genetech.exception.UnauthorizedException;
import com.genetech.service.SiteUserService;
import com.genetech.service.UserService;
import com.genetech.utils.JWTUtil;
import com.genetech.utils.RedisUtils;
import com.google.code.kaptcha.Constants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/10.
 */

@RestController
@RequestMapping("/siteUser")
public class SiteUserController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SiteUserController.class);
    @Autowired
    private SiteUserService siteUserService;
    //是否通过PI审核 0：未通过 1：审核中 2：通过 3：未通过
    private final static Integer PI_VERIFING = 1;//审核中
    private final static Integer PI_NOT_PASS = 0;//未通过
    private final static Integer PI_PASS = 2;//通过
    private final static Integer PI_NOT_APPLY = 3;//未申请

 /*   @Value("${spring.exclusion.usernames}")
    private String exclusions;*/

    @ApiOperation(value="前端用户登录",notes="前端用户登录")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/login")
    public ResponseBean login(SiteUserDto siteUserDto, HttpServletResponse response, HttpServletRequest request){

        //用户名
        String userName = siteUserDto.getUserName();
        if (StringUtils.isEmpty(userName)){
            return new ResponseBean(false, 500, "用户名不能为空！",null);
        }
        //密码
        String password = siteUserDto.getPassword();
        if (StringUtils.isEmpty(password)){
            return new ResponseBean(false, 500, "密码不能为空！",null);
        }

        SiteUser siteUser1 = siteUserService.getSiteUserByUserName(userName);
        if (siteUser1 == null){
            return new ResponseBean(false, 500, "用户名错误！",null);
        }

        String password1 = siteUser1.getPassword();
        String md5Pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password1.equals(md5Pwd)){
            return new ResponseBean(false, 500, "密码错误！",null);
        }

        //校验验证码
        System.out.println("检查验证码"+request.getSession().getId());
        //从session中拿出存放的验证码跟前端传递过来的进行比较
        String rightCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //String rightCode = RedisUtils.getJedis().get(Constants.KAPTCHA_SESSION_KEY);
        System.out.println(siteUserDto);
        if (!rightCode.equals(siteUserDto.getVerifyCode())) {
            return new ResponseBean(false, 500, "验证码错误！",null);
        }

        //生成token
        String token = JWTUtil.sign(siteUser1.getUserName(),md5Pwd);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        //最新的登录时间
        siteUser1.setLastLoginTime(new Date());
        siteUserService.updateSiteUser(siteUser1,null);

        //存储用户信息
        setUserInfo(request,siteUser1);

        return new ResponseBean(true, 200, "登录成功！",siteUser1);
    }

    @ApiOperation(value="前端用户注册",notes="前端用户注册")
    @ApiImplicitParam(name = "siteUser", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/register")
    public ResponseBean register(SiteUserDto siteUserDto, HttpServletResponse response, HttpServletRequest request){
        //用户名
        String userName = siteUserDto.getUserName();
        if (StringUtils.isEmpty(userName)){
            return new ResponseBean(false, 500, "用户名不能为空！",null);
        }
        //密码
        String password = siteUserDto.getPassword();
        if (StringUtils.isEmpty(password)){
            return new ResponseBean(false, 500, "密码不能为空！",null);
        }

        //确认密码
        String confirmPassword = siteUserDto.getConfirmPassword();
        if (StringUtils.isEmpty(confirmPassword) || !password.equals(confirmPassword)){
            return new ResponseBean(false, 500, "两次输入不一致！",null);
        }

        //机构
        String institute = siteUserDto.getInstitute();
        if (StringUtils.isEmpty(institute)){
            return new ResponseBean(false, 500, "机构不能为空！",null);
        }

        //用户名不能重复
        SiteUser checkResult = siteUserService.getSiteUserByUserName(siteUserDto.getUserName());
        if (checkResult != null){
            return new ResponseBean(false, 500, "用户名已被使用！",null);
        }

        //实验室负责人
      /*  String piLeader = siteUserDto.getLab_leader();
        if (StringUtils.isEmpty(piLeader)){
            return new ResponseBean(false, 500, "pi负责人不能为空！",null);
        }*/
        String md5Pwd = DigestUtils.md5DigestAsHex(siteUserDto.getPassword().getBytes());
        siteUserDto.setPassword(md5Pwd);

        siteUserDto.setCreatedTime(new Date());
        siteUserService.registerSiteUser(siteUserDto);
        return new ResponseBean(false, 200, "注册成功！",null);
    }



    //PI认证
    @PostMapping("/piSubmit")
    public ResponseBean PICertificate(HttpServletRequest httpServletRequest,SiteUserDto siteUserDto){

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(httpServletRequest);

            if (siteUser == null){
                return new ResponseBean(false, ReturnCode.EMPTY_USER,"用户未登录",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false, 500,"获取用户信息发生错误！",null,e.getMessage());
        }

        if(StringUtils.isEmpty(siteUserDto.getReal_name())){
            return new ResponseBean(false, 500,"真实姓名不能为空！",null);
        }

        if(StringUtils.isEmpty(siteUserDto.getPi_name())){
            return new ResponseBean(false, 500,"请填写PI姓名！",null);
        }
        if(StringUtils.isEmpty(siteUserDto.getTelephone())){
            return new ResponseBean(false, 500,"电话不能为空！",null);
        }

        if(StringUtils.isEmpty(siteUserDto.getEmail())){
            return new ResponseBean(false, 500,"邮箱不能为空！",null);
        }

        if(StringUtils.isEmpty(siteUserDto.getInstitute())){
            return new ResponseBean(false, 500,"机构地址不能为空！",null);
        }

        /*if(StringUtils.isEmpty(siteUserDto.getPi_phone())){
            return new ResponseBean(false, 500,"PI电话不能为空！",null);
        }*/
        if(StringUtils.isEmpty(siteUserDto.getPi_email())){
            return new ResponseBean(false, 500,"PI邮箱不能为空！",null);
        }
        siteUserService.piCertificate(siteUser.getId(),siteUserDto);
        return  new ResponseBean(true, 200, "success！",null);
    }

    //判断是否认证成功
    @GetMapping("/isPassed")
    public ResponseBean isPICertificateSuccess(HttpServletRequest httpServletRequest) {

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(httpServletRequest);

            SiteUser verifyUser = siteUserService.getSiteUserById(siteUser.getId());
            //是否通过PI审核 0：未通过 1：审核中 2：通过 3：未验证
            if (PI_VERIFING.equals(verifyUser.getIsActive())){
                return  new ResponseBean(true, 201, "PI资质审核中！",PI_VERIFING);
            }
            if (PI_NOT_PASS.equals(verifyUser.getIsActive())){
                return  new ResponseBean(true, 202, "PI资质审核未通过！",PI_NOT_PASS);
            }
            if (PI_PASS.equals(verifyUser.getIsActive())){
                return  new ResponseBean(true, 200, "PI资质审核通过！",PI_PASS);
            }
            if(PI_NOT_APPLY.equals(verifyUser.getIsActive())){
                return  new ResponseBean(true, 203, "PI资质还未申请！",PI_NOT_APPLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (siteUser == null){
                return  new ResponseBean(false, 500, "用户未登录！",null);
            }
        }

        return  new ResponseBean(false, 500, "获取用户PI资质信息失败！",null);
    }

    //获取登录的账号信息
    @GetMapping("/info")
    public ResponseBean getSiteUserInfo(HttpServletRequest httpServletRequest){

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(httpServletRequest);
            SiteUser userInfo = siteUserService.getSiteUserById(siteUser.getId());
            return new ResponseBean(true, 200, "success！",userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            if (siteUser == null){
                return new ResponseBean(false, 301, "用户未登录！",null);
            }
        }

        return new ResponseBean(false, 500, "查询失败！",null);
    }

    @PostMapping("/update")
    public ResponseBean updateSiteUser(HttpServletRequest httpServletRequest,SiteUserDto siteUserDto){

        //用户名
        String userName = siteUserDto.getUserName();
        if (StringUtils.isEmpty(userName)){
            return new ResponseBean(false, 500, "用户名不能为空！",null);
        }
        //密码
        String password = siteUserDto.getPassword();
        if (StringUtils.isEmpty(password)){
            return new ResponseBean(false, 500, "密码不能为空！",null);
        }

        //确认密码
        String confirmPassword = siteUserDto.getConfirmPassword();
        if (StringUtils.isEmpty(confirmPassword) || !password.equals(confirmPassword)){
            return new ResponseBean(false, 500, "两次密码输入不一致！",null);
        }

        //机构
        String institute = siteUserDto.getInstitute();
        if (StringUtils.isEmpty(institute)){
            return new ResponseBean(false, 500, "机构不能为空！",null);
        }

        //别忘了密码要加密的！
        String md5Pwd = DigestUtils.md5DigestAsHex(siteUserDto.getPassword().getBytes());
        siteUserDto.setPassword(md5Pwd);

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(httpServletRequest);
            siteUserService.updateSiteUser(siteUser,siteUserDto);
            return new ResponseBean(true, 200, "success！",null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseBean(false, 500, "更新失败！",null);
    }

    //用户是否存在，邮箱是否正确
    @PostMapping("/isUserNameAndEmailExist")
    public ResponseBean isUserNameAndEmailExist(SiteUserDto siteUserDto){
        SiteUser siteUser = siteUserService.getSiteUserByUserName(siteUserDto.getUserName());
        if (siteUser == null){
            return new ResponseBean(false,500, "用户不存在!",null);
        }
        if(!siteUserDto.getEmail().equals(siteUser.getEmail())){
            return new ResponseBean(false,500, "邮箱不正确!",null);
        }


        return  new ResponseBean(true,200, "查询成功!",null);
    }

    @PostMapping("/reset")
    public ResponseBean resetPassword(SiteUserDto siteUserDto){
        try{
        siteUserService.resetPassword(siteUserDto);
        }catch (Exception e){
            return new ResponseBean(false,500, "服务器错误!",null);
        }
        return  new ResponseBean(true,200, "密码重置成功!",null);
    }

}
