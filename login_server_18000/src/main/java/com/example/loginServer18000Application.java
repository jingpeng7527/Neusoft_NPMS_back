package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.login_server_18000.mapper")
public class loginServer18000Application {

    public static void main(String[] args) {
        SpringApplication.run(loginServer18000Application.class, args);
    }

}