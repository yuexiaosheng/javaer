package com.ghj.DemoSwagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Tag(name="OrderController",description = "订单处理")
public class OrderController {
    @PostMapping("getorder")
    @Operation(description = "获取一个订单")
    public String getOrder(){
        return "order123";
    }
}
