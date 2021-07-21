package com.neusoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
public class SalesLogProviderServer12000 {
    public static void main(String[] args) {
        SpringApplication.run(SalesLogProviderServer12000.class,args);
    }
}
