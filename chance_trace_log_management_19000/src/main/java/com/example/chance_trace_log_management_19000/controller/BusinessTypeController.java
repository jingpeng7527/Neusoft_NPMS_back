package com.example.chance_trace_log_management_19000.controller;


import com.example.chance_trace_log_management_19000.entity.BusinessType;
import com.example.chance_trace_log_management_19000.service.impl.BusinessTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abigail
 * @since 2021-07-20
 */
@CrossOrigin
@EnableDiscoveryClient
@RestController
@RequestMapping("/chance/chance_trace_log")
public class BusinessTypeController {

    @Autowired
    BusinessTypeServiceImpl businessTypeService;

    @GetMapping("init_business_type")
    public List<BusinessType> getBusinessType(){
        return businessTypeService.list();
    }
}

