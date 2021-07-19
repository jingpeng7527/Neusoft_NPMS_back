package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.ChanceApproveLog;
import com.neusoft.npms.service.IChanceApproveLogService;
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
@RequestMapping("/npms/chance-approve-log")
public class ChanceApproveLogController {

    @Autowired
    IChanceApproveLogService iChanceApproveLogService;

    @GetMapping("/get_chance_approve_log_by_chance_num")
    public RespBean getChanceApproveLogByChanceNum(String chance_num){
        System.out.println("/get_chance_approve_log_by_chance_num");
        System.out.println("chance_num: "+chance_num);
        System.out.println();

        if (chance_num == null || chance_num.equals(""))
            return RespBean.error(400,"非法参数");

        List<ChanceApproveLog> result = iChanceApproveLogService.list(Wrappers.<ChanceApproveLog>lambdaQuery().eq(ChanceApproveLog::getChanceNum,chance_num));
        return RespBean.ok(200,"通过chanceNum 获取 chance approve log", result);
    }

}

