package com.genetech.shiro;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;

import com.genetech.filter.LoginFilter;
import com.genetech.filter.PIFilter;
import com.genetech.jwt.JwtFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfiguration {
     //把自定义realm加入到spring容器
	@Bean
	public Myrealm  getMyrealm() {
		Myrealm myrealm = new Myrealm();
		return myrealm;
	}
	
	//安全管理器的配置
	@Bean("securityManager")
	public SecurityManager getSecurityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(getMyrealm());
		//关闭Shiro自带的session
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		securityManager.setSubjectDAO(subjectDAO);
		return securityManager;
	}
	
	//filter工厂,用来设置过滤条件以及跳转条件
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean (SecurityManager securityManager){//spring依赖注入的方式，会用上面实例化的bean注入到这个securityManager参数
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		Map<String, Filter> filterMap = new HashMap<String, Filter>();
		filterMap.put("jwt", new JwtFilter());
		//filterMap.put("loginFilter",new LoginFilter());
		//filterMap.put("piFilter",new PIFilter());
		bean.setSecurityManager(securityManager);
		bean.setFilters(filterMap);
		Map<String,String> map = new HashMap<String,String>();

		//设置过滤的顺序
		//下面这些路径不会进入jwt和后面的过滤器，不用登录也能查看
		map.put("/plasmid/conditions","anon");//质粒筛选条件
		map.put("/plasmid/list","anon");//质粒列表
		map.put("/plasmid/detail","anon");//质粒详情
		map.put("/siteUser/login","anon");//登录
		map.put("/siteUser/register","anon");//注册
		map.put("/kaptcha/getImage","anon");//验证码
		//map.put("/siteUser/isPassed","anon");//PI认证是否通过

		//哪几个要进pi认证
		//map.put("/shoppingCart/list","piFilter");
		map.put("/**", "jwt");//先判断session里面有没有用户信息----主要是重启服务器的时候会有这个问题

		//认证失败跳转url
		bean.setUnauthorizedUrl("/401");
		bean.setFilterChainDefinitionMap(map);
		//bean.setF
		return bean;
		
	}
	
	/** 
	* 下面的代码是添加注解支持
	 */
	
	@Bean 
	@DependsOn("lifecycleBeanPostProcessor") 
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() { 
	DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
	 // 强制使用cglib，防止重复代理和可能引起代理出错的问题 
	defaultAdvisorAutoProxyCreator.setProxyTargetClass(true); 
	return defaultAdvisorAutoProxyCreator;
	 } 

	@Bean
	 public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	 return new LifecycleBeanPostProcessor(); 
	}

	
	
	
	
	//加入注解的使用,不加入注解无效
	@Bean
	public  AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
}
