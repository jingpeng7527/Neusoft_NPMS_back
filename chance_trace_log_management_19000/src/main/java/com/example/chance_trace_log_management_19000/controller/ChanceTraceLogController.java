package com.example.chance_trace_log_management_19000.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.chance_trace_log_management_19000.dto.RespBean;
import com.example.chance_trace_log_management_19000.entity.ChanceTraceLog;
import com.example.chance_trace_log_management_19000.service.impl.ChanceTraceLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.ChangedCharSetException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author abigail
 * @since 2021-07-19
 */
@RestController
@RequestMapping("/chance/chance_trace_log")
public class ChanceTraceLogController {

    @Autowired
    ChanceTraceLogServiceImpl chanceTraceLogService;

    @PostMapping("/create")
    public RespBean createChanceTraceLog(@RequestBody ChanceTraceLog chance_trace_log) {
        RespBean respBean = null;
        System.out.println(chance_trace_log);
        boolean sig = chanceTraceLogService.saveOrUpdate(chance_trace_log);
        if (!sig) {
            respBean = RespBean.ok(400, "create chance_log failure");
        } else {
            respBean = RespBean.ok(200, "create successfully ", chance_trace_log);
        }
        return respBean;
    }

    @GetMapping("/delete")
    public RespBean deleteChanceTraceLog(@RequestParam String chance_num) {
        RespBean respBean = null;
        QueryWrapper<ChanceTraceLog> qw = Wrappers.query();
        qw.eq("chance_num", chance_num);
        boolean sig = chanceTraceLogService.remove(qw);
        if (!sig) {
            respBean = RespBean.ok(400, "create chance_log failure", 2);
        } else {
            respBean = RespBean.ok(200, "create successfully ", 1);
        }
        return respBean;
    }

    @GetMapping("/query")
    public RespBean queryChanceTraceLog(@RequestParam String chance_num) {
        RespBean respBean = null;
//        System.out.println("pppp"+chance_num);
        QueryWrapper<ChanceTraceLog> qw = Wrappers.query();
        qw.eq("chance_num", chance_num);

        ChanceTraceLog chanceTraceLog = chanceTraceLogService.getOne(Wrappers.<ChanceTraceLog>lambdaQuery().eq(ChanceTraceLog::getChanceNum,chance_num));
//        System.out.println(chanceTraceLog);
        if (chanceTraceLog == null) {
            respBean = RespBean.ok(400, "create chance_log failure");
        } else {
            respBean = RespBean.ok(200, "create successfully ", chanceTraceLog);
        }
        return respBean;
    }
}