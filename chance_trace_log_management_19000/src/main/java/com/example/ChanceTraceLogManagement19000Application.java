package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
@MapperScan("com.example.chance_trace_log_management_19000.mapper")
public class ChanceTraceLogManagement19000Application {

    public static void main(String[] args) {
        SpringApplication.run(ChanceTraceLogManagement19000Application.class, args);
    }

}