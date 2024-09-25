package com.example.DemoSwagger2.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.el.MethodInfo;

@RestController
public class HelloController {
    @ApiOperation("这个方式叫Test")
    @RequestMapping(value="/abb",  method= RequestMethod.GET)
    public String Test(){
        return "i am abb";
    }
}

