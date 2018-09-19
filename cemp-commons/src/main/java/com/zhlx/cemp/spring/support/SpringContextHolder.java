package com.zhlx.cemp.spring.support;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    
	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		logger.debug("注入ApplicationContext到SpringContextHolder:{}", applicationContext);
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	public void destroy() throws Exception {
		clearHolder();
	}

	public static void clearHolder() {
		logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		applicationContext = null;
	}

	private static void assertContextInjected() {
		Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.", new Object[0]);
	}
}
