package com.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableCaching
@SpringBootApplication
@CrossOrigin
@EnableDiscoveryClient
@EnableOpenApi
//@EnableFeignClients
@MapperScan("com.neusoft.npms.mapper")
public class ChanceProviderServer14000 {
    public static void main(String[] args) {
        SpringApplication.run(ChanceProviderServer14000.class,args);
    }
}
