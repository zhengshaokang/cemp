package com.zhlx.cemp.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FreeMarkerConfig {

	 @Autowired
     private freemarker.template.Configuration configuration;

     @Value("${system.domain}")
     private String domain;

     @Value("${system.imgpath}")
     private String imgpath;



     @PostConstruct
     public void setConfigure() throws Exception {

        configuration.setSharedVariable("DOMAIN", domain);
        configuration.setSharedVariable("IMGPATH", imgpath);

     }
}
