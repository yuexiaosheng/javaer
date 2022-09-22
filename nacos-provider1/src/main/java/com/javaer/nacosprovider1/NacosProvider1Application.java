package com.javaer.nacosprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //开启服务发现功能
public class NacosProvider1Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider1Application.class, args);
    }
}
