package com.javaer.controll;


import com.javaer.microservicecloudapi.entity.Dept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务提供者的控制层
 * author:c语言中文网 c.biancheng.net
 */
@RestController
@Slf4j
public class DeptController {


    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") int id) {
        return String.valueOf(id) + " i am 8002 server";
    }
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public String list() {
        return "list all i am 8002";
    }
}