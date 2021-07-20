package com.neusoft.npms.controller;


import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.ChanceSource;
import com.neusoft.npms.service.IChanceSourceService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author yky
 * @since 2021-07-13
 */
@CrossOrigin
@RestController
@RequestMapping("/npms/chance-source")
public class ChanceSourceController {
    @Autowired
    IChanceSourceService iChanceSourceService;

    @GetMapping("/get_chance_source_service")
    public RespBean getChanceSourceService(){
        System.out.println("/get_chance_source_service");
        List<ChanceSource> result = iChanceSourceService.list();
        return RespBean.ok(200,"获取chance source表", result);
    }

}

