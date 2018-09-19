package com.zhlx.cemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/set")
    public void set() {
        redisTemplate.opsForValue().set("test", "4321");
    }

    @RequestMapping("/show")
    public String show(){
        return redisTemplate.opsForValue().get("test").toString();
    }
}
