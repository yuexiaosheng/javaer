package com.example.redis99.Redis99.config.controller;

import com.example.redis99.Redis99.config.MyDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisDo {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MyDoc myDoc;

    @RequestMapping("/get")
    public String getRedisV(){
        System.out.println(redisTemplate.opsForValue().get("foo"));
        return "abc";
    }
    @RequestMapping("/mydoc")
    public String mydoc(){
        System.out.println(myDoc.getQqname());
        System.out.println(myDoc.getQqpwd());
        return "abc";
    }
}
