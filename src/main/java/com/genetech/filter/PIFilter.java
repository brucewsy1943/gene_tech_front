package com.genetech.filter;

import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.controller.BaseController;
import com.genetech.service.SiteUserService;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020/1/2.
 */
public class PIFilter extends BasicHttpAuthenticationFilter{

    //写个根路径
    private final static String loginUrl = "../user/login.html";//可以写配置文件
    //判断用户是否登录

    private final static Integer PI_VERIFING = 1;//审核中
    private final static Integer PI_NOT_PASS = 0;//未通过
    private final static Integer PI_PASS = 2;//通过
    private final static Integer PI_NOT_APPLY = 3;//未申请
    @Autowired
    private SiteUserService siteUserService;

    @Autowired
    private BaseController baseController;
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //PI认证
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        SiteUser siteUser = null;
        try {
            siteUser = baseController.getUserInfo(httpServletRequest);
            SiteUser verifyUser = siteUserService.getSiteUserById(siteUser.getId());
            if (PI_VERIFING.equals(verifyUser.getIsActive())){
                redirect(request,response,"PI资质审核中");
            }
            if (PI_NOT_PASS.equals(verifyUser.getIsActive())){
                redirect(request,response,"PI资质审核未通过!");
            }
            if (PI_PASS.equals(verifyUser.getIsActive())){
                return  true;
            }
            if(PI_NOT_APPLY.equals(verifyUser.getIsActive())){
                redirect(request,response,"PI资质还未申请!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectToLoginHtml(request,response,"用户未登录!");

        }
        return false;
    }
    private void redirect(ServletRequest req, ServletResponse resp,String message){
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletResponse.addHeader("MESSAGE",message);
        httpServletResponse.addHeader("REDIRECT", "NOTPASS");//告诉ajax这是重定向
       // httpServletResponse.addHeader("CONTEXTPATH", loginUrl);//重定向地址
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH,MESSAGE");

    }

    private void redirectToLoginHtml(ServletRequest req, ServletResponse resp,String message){
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletResponse.addHeader("MESSAGE",message);
        httpServletResponse.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
        httpServletResponse.addHeader("CONTEXTPATH", loginUrl);//重定向地址
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH,MESSAGE");

    }
}
