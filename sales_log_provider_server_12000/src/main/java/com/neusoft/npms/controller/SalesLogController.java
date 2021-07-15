package com.neusoft.npms.controller;

import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.SalesLog;
import com.neusoft.npms.service.ISalesLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
@RequestMapping("/npms/sales_log")
public class SalesLogController {

    @Autowired
    ISalesLogService iSalesLogService;

    @GetMapping("/query_sales_log")
    public RespBean querySalesLog(String user_id, @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate start_time, @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end_time,String week){

        System.out.println("user_id:"+user_id+"start:"+start_time+"end:"+end_time);

        if (user_id == null || start_time == null || end_time == null)
            return RespBean.error(400,"参数中有null");
        List<SalesLog> salesLogList = iSalesLogService.getByIdAndTime(user_id,start_time,end_time,week);
        return RespBean.ok(200,"get sales log list",salesLogList);
    }

    @GetMapping("/delete_sales_log")
    public RespBean deleteSalesLog(String id){
        boolean result = iSalesLogService.removeById(id);
        if (result) return RespBean.ok(200,"delete successfully");
        else return RespBean.error(400,"Invalid id");
    }

    @PostMapping("/insert_or_update")
    public RespBean insertOrUpdate(@RequestBody SalesLog salesLog){
        System.out.println(salesLog);
        boolean result = iSalesLogService.saveOrUpdate(salesLog);
        if (result) return RespBean.ok(200, "save or update successfully");
        else return RespBean.error(400, "Invalid data");
    }
}

