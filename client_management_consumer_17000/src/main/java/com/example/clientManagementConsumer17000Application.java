package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
@MapperScan("com/example/client_management_consumer_17000")
public class clientManagementConsumer17000Application {

    public static void main(String[] args) {
        SpringApplication.run(clientManagementConsumer17000Application.class, args);
    }

}
