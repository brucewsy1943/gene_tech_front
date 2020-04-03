package com.genetech.filter;

import com.genetech.bean.SiteUser;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020/1/1.
 */
public class LoginFilter extends BasicHttpAuthenticationFilter {

    //写个根路径
    private final static String loginUrl = "/page/template/user/login.html";//可以写配置文件
    //判断用户是否登录

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //session里面有没有东西
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        try {
            if(session.getAttribute( "sessionuser" ) != null)
            {
                return true;
            }
            redirectToLoginHtml(request, response,"用户未登录！");
        }catch (Exception e){
            e.printStackTrace();
            redirectToLoginHtml(request, response,"获取用户信息失败！");
        }

        return false;
    }
    private void redirectToLoginHtml(ServletRequest req, ServletResponse resp,String message){
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        //httpServletResponse.addHeader("MESSAGE",message);
        httpServletResponse.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
        httpServletResponse.addHeader("CONTEXTPATH", loginUrl);//重定向地址
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH");

    }
}
