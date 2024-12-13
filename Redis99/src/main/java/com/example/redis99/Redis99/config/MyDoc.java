package com.example.redis99.Redis99.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.sql.DataSourceDefinition;

/**
 * 测试自定义配置文件，和yml文件的联动
 *
 * 核心为
 * <dependency>
 * 			<groupId>org.springframework.boot</groupId>
 * 			<artifactId>spring-boot-configuration-processor</artifactId>
 * 			<optional>true</optional>
 * 		</dependency>
 *
 */
@ConfigurationProperties(prefix = "mydoc")
@Configuration
@Data
public class MyDoc {
    private String qqname;
    private String qqpwd;
}
