package com.zhlx.cemp.config;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@EnableCaching
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(target.getClass().getName());
            builder.append("@").append(method.getName());
            if (ArrayUtils.isNotEmpty(params)) {
                builder.append("(");
                for (Object param : params) {
                    BeanMap commandMap = BeanMap.create(param);
                    for (Object obj : commandMap.entrySet()) {
                        Map.Entry entry = (Map.Entry) obj;
                        if (entry != null && entry.getValue() != null) {
                            builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                        }
                    }
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append(")");
            }
            return builder.toString();
        };
    }
}
