package com.javaer.jwtdemo.controller.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/login");

    }

    @Bean
    public IpIntercepter ipIntercepter(){
        return new IpIntercepter();
    }
}
