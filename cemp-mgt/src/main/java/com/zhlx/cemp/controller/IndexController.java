package com.zhlx.cemp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 作用：首页
     *
     *
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/test") 
    public String test(HttpServletRequest req,Map<String, Object> map) {
    	
    	map.put("name", " 我是来测试 freemarker的哦，不要搞错");
    	
    	return "test";
    }
    @RequestMapping("/testuser") 
    public String test(Map<String, Object> map) {
    	
    	map.put("name", " 我是来测试 freemarker的哦，不要搞错,我是test哦....");
    	
    	return "user/testuser";
    }
}
