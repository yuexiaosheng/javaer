package com.example.redis99.Redis99.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisDo {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/get")
    public String getRedisV(){
        System.out.println(redisTemplate.opsForValue().get("foo"));

        return "abc";

    }
}
