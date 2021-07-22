package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableCaching
@EnableOpenApi
@MapperScan("com/example/client_management_provider_16000")
public class clientManagementProvider16000Application {

    public static void main(String[] args) {
        SpringApplication.run(clientManagementProvider16000Application.class, args);
    }

}