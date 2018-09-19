package com.zhlx.cemp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author connor-zheng
 * 
 */
@Configuration
public class WebConfigurerAdapter extends WebMvcConfigurerAdapter {
	
	@Autowired
	private AuthenticationInteceptor authenticationInteceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {  
		registry.addInterceptor(authenticationInteceptor).addPathPatterns("/**");  //对来自/user/** 这个链接来的请求进行拦截
    }  
}
