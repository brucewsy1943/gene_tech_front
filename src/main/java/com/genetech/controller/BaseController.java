package com.genetech.controller;

import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.constant.ReturnCode;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/12/16.
 */
@Controller
public class BaseController {

    //每次都存到各自线程的ThreadLocal里面
    //ThreadLocal<SiteUser> siteUserThreadLocal = new ThreadLocal<>();

    public SiteUser getUserInfo(HttpServletRequest request) throws Exception {


        if(request.getSession().getAttribute( "sessionuser" ) != null)
        {
            return (SiteUser)request.getSession().getAttribute( "sessionuser" );
        }

        throw new Exception("用户未登录！");

    }
    //登录成功把
    public void setUserInfo(HttpServletRequest request,SiteUser siteUser){
        request.getSession().setAttribute("sessionuser",siteUser);
    }

    ResponseBean isUserLogin(HttpServletRequest request){
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
            if (siteUser == null){
                return new ResponseBean(true, ReturnCode.EMPTY_USER,"用户未登录",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(true, ReturnCode.EMPTY_USER,"用户登录错误",null,e.getMessage());
        }
        return null;
    }

}
