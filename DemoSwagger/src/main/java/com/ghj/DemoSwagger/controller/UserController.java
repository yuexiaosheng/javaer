package com.ghj.DemoSwagger.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Tag(name = "UserController", description = "用户接口")
public class UserController {
    @GetMapping(value="reg/{id}")
    @Operation(description = "测试测试")
    public String reg(@PathVariable Integer id){
        System.out.println("我是注册测试");
        return "abc" + String.valueOf(id);
    }
    @GetMapping("isExistsUser")
    @Operation(description = "用户是否存在")
    public Boolean isExistsUser(){
        return true;
    }
}
