package com.zhlx.cemp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 作用：用户登录
 * 
 */
@Controller
public class LoginController extends BaseController {

//    @Resource
//    private UserInfoService userInfoService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login() {
        return "login";
    }



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        return "login";
    }


}
