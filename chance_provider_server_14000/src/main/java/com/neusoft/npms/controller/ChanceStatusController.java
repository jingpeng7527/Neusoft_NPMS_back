package com.neusoft.npms.controller;


import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.ChanceStatus;
import com.neusoft.npms.service.IChanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/npms/chance-status")
public class ChanceStatusController {
    @Autowired
    IChanceStatusService iChanceStatusService;

    @GetMapping("/getChanceStatus")
    public RespBean getChanceStatus(){
        List<ChanceStatus> result = iChanceStatusService.list();
        return RespBean.ok(200,"123",result);
    }

}

