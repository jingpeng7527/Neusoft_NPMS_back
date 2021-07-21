package com.macro.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.macro.cloud.mapper")
public class Oauth2ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ApiApplication.class, args);
    }

}
