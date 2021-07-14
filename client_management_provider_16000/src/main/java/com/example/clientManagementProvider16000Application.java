package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/client_management_provider_16000")
public class clientManagementProvider16000Application {

    public static void main(String[] args) {
        SpringApplication.run(clientManagementProvider16000Application.class, args);
    }

}