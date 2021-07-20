package com.neusoft.npms.controller;


import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.ChanceStage;
import com.neusoft.npms.service.IChanceStageService;
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
@RequestMapping("/npms/chance-stage")
public class ChanceStageController {
    @Autowired
    IChanceStageService iChanceStageService;

    @GetMapping("/get_chance_stage")
    public RespBean getChanceStage(){
        System.out.println("/get_chance_stage");
        List<ChanceStage> result = iChanceStageService.list();
        return RespBean.ok(200,"获取chanceStage表",result);
    }
}

