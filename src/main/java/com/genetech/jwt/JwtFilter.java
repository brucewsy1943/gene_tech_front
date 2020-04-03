package com.genetech.jwt;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

public class JwtFilter extends BasicHttpAuthenticationFilter{

	//写个根路径
	private final static String loginUrl = "../user/login.html";

	private final static String AUTHORIZATION = "Authorization";
	/** * 判断用户是否想要登入。
	 * 检测header里面是否包含Authorization字段即可
	 */ 
	@Override 
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) { 
	HttpServletRequest req = (HttpServletRequest) request;
	 String authorization = req.getHeader(AUTHORIZATION);
	return authorization != null; 
	}

	 @Override
	 protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception { 
	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	 	String authorization = httpServletRequest.getHeader(AUTHORIZATION);
		JwtToken token = new JwtToken(authorization);
		 System.out.print(httpServletRequest.getRequestURL());
		// 提交给realm进行登入，如果错误他会抛出异常并被捕获
		getSubject(request, response).login(token); //这个里面最终会去执行realm的相关方法。
		// 如果没有抛出异常则代表登入成功，返回true

		 //假如session中的user信息丢失 则返回false
			 if(httpServletRequest.getSession().getAttribute( "sessionuser" ) == null)
			 {
				 return false;
			 }

		return true;
	}

	 @Override 
	 protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
	  if (isLoginAttempt(request, response)) {
		  try {
			if (!executeLogin(request, response)){
				redirectToLoginHtml(request,response,"请登录 !");
			}
		 } catch (Exception e) {
			  redirectToLoginHtml(request, response,e.getMessage());
		 }
	  } return true;
	 }

	 /** 
	 * 对跨域提供支持
	  */ 
	 @Override 
	 protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception { 
	 HttpServletRequest httpServletRequest = (HttpServletRequest) request; 
	 HttpServletResponse httpServletResponse = (HttpServletResponse) response; 
	 httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin")); 
	 httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE"); 
	 httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers")); // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态 
	 if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) { 
	 httpServletResponse.setStatus(HttpStatus.OK.value()); 
	 return false;
	  } 
	 return super.preHandle(request, response); }

	 /**
	  *  * 将非法请求跳转到 /401 
	  *  */ 
	 private void response401(ServletRequest req, ServletResponse resp) { 
		/* HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
			 httpServletResponse.sendRedirect("/401"); //跳回登录页*/
			 //httpServletResponse.sendRedirect(loginUrl);

			/* HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
			 httpServletResponse.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
			 httpServletResponse.addHeader("CONTEXTPATH", loginUrl);//重定向地址
			 httpServletResponse.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH");*/

	 }

	private void redirectToLoginHtml(ServletRequest req, ServletResponse resp,String message){
			HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
			//httpServletResponse.addHeader("MESSAGE",message);
			httpServletResponse.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
			httpServletResponse.addHeader("CONTEXTPATH", loginUrl);//重定向地址
			httpServletResponse.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH");

	}
}
