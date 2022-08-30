package com.javaer.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtdemoApplication {

    public static void main(String[] args) {
        System.out.println("starting");
        SpringApplication.run(JwtdemoApplication.class, args);
    }

}
