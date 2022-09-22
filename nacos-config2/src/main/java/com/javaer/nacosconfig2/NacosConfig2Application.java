package com.javaer.nacosconfig2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig2Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig2Application.class, args);
    }

}
