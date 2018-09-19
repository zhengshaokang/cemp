package com.zhlx.cemp.config;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Component
public class AuthenticationInteceptor implements HandlerInterceptor {
	//@Autowired
	//private JpaUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject) throws IOException {
//		String str = paramHttpServletRequest.getRequestURI().substring(paramHttpServletRequest.getContextPath().length());
//		if (b(str)) {
//			return true;
//		}
//		if (str.equals("/error")) {
//			//paramHttpServletResponse.setStatus(HttpStatus.SC_MOVED_TEMPORARILY);
//			paramHttpServletResponse.setHeader("Location", "/doc.html");
//			return false;
//		}
//		
//		String userName  = paramHttpServletRequest.getParameter("userName");
//		String password = paramHttpServletRequest.getParameter("password");
//		String appKey = paramHttpServletRequest.getParameter("appKey");
//		
//		if (null == userName || null == password || null == appKey) {
//			String data = "登录失败，登录用户名或者登录密码或者appKey密钥不能为空！";
//			//paramHttpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
//			paramHttpServletResponse.setHeader("content-type", "text/html;charset=UTF-8");
//			OutputStream outputStream = paramHttpServletResponse.getOutputStream();
//			outputStream.write(data.getBytes("UTF-8"));
//			return false;
//		}
		
		/*//如果用户名和密码错误不能调用接口
		User u = userService.validateUser(userName,new MD5(password).toMD5());
		if(null == u) {
			String data = "登录失败，登录用户名或者登录密码错误！";
			paramHttpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
			paramHttpServletResponse.setHeader("content-type", "text/html;charset=UTF-8");
			OutputStream outputStream = paramHttpServletResponse.getOutputStream();
			outputStream.write(data.getBytes("UTF-8"));
			return false;
		}
		
		//每个用户对应的token
		if (null == appKey || "".equals(appKey) || !appKey.equals(new MD5("tomtop"+userName).toMD5())) {
			String data = "登录失败，appKey密钥错误！";
			paramHttpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
			paramHttpServletResponse.setHeader("content-type", "text/html;charset=UTF-8");
			OutputStream outputStream = paramHttpServletResponse.getOutputStream();
			outputStream.write(data.getBytes("UTF-8"));
			return false;
		}*/
		//paramHttpServletRequest.setAttribute("user", u);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, Object paramObject,
			ModelAndView paramModelAndView) {
	}
	
	@Override
	public void afterCompletion(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, Object paramObject,
			Exception paramException) {
	}

	private Boolean b(String paramString) {
		ArrayList<String> localArrayList = new ArrayList<String>();
		localArrayList.add("/swagger-resources/configuration/ui");

		return Boolean.valueOf(localArrayList.contains(paramString));
	}

	private Boolean a(Object paramObject) {
		return Boolean.valueOf(paramObject instanceof ResourceHttpRequestHandler);
	}
}
