package com.javaer.nacosprovider1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DeptController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String name;
    @GetMapping(value = "/dept/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "<h2>我是服务提供方，我来提醒您2，服务访问成功！</h2>服务名："+ name +"<br /> 端口号： " + serverPort + "<br /> 传入的参数：" + id;
    }
}
