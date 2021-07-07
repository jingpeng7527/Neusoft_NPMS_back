package com.neusoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer15000Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer15000Application.class, args);
    }

}
