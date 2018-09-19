package com.zhlx.cemp.spring.support;


import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

/**
 * 作用：获取spring的上下文
 *
 */
public class SpringApplicaitonContext {
    private static ApplicationContext context;
    private static Object lock = new Object();

    public static ApplicationContext getContext() {
        if (context == null) {
            synchronized (lock) {
                if (context == null) {
                    context = ContextLoader.getCurrentWebApplicationContext();
                }
            }
        }
        return context;
    }
}
