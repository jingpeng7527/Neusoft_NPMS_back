package com.example;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.chance_trace_log_management_19000.entity.ChanceTraceLog;
import com.example.chance_trace_log_management_19000.service.IChanceTraceLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HHTest {
    @Autowired
    IChanceTraceLogService iChanceTraceLogService;

    @Test
    void test1(){
        ChanceTraceLog chanceTraceLog = iChanceTraceLogService.getOne(Wrappers.<ChanceTraceLog>lambdaQuery().eq(ChanceTraceLog::getChanceNum,"20210001"));
        System.out.println(chanceTraceLog);
    }
}
