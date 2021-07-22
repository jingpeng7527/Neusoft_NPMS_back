package com.example.client_management_provider_16000.controller;


import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.dto.TransferLogPara;
import com.example.client_management_provider_16000.dto.TransferLogWithChance;
import com.example.client_management_provider_16000.entity.ClientTransferLog;
import com.example.client_management_provider_16000.service.impl.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abigail
 * @since 2021-07-18
 */
@CrossOrigin
@RestController
@EnableDiscoveryClient
@RequestMapping("/client")
@Api(tags = "clienttransfer")

public class ClientTransferController {

    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    ChanceServiceImpl chanceService;
    @Autowired
    ClientTransferLogServiceImpl clientTransferLogService;
    @Autowired
    ClientContactServiceImpl clientContactService;

    @Autowired
    ChanceDraftServiceImpl chanceDraftService;

    //客户移交
    @GetMapping("transfer_client")
    public RespBean transferClient(@RequestParam Integer exportDeptId, @RequestParam Integer exportUserId,
                                   @RequestParam Integer importDeptId, @RequestParam Integer importUserId,
                                   @RequestParam Integer clientId, @RequestParam List<String> chanceNums){
        RespBean respBean = null;
        //更新记录表
        List<ClientTransferLog> clientTransferLogs = new ArrayList<>();
        for (String num:chanceNums){
            clientTransferLogs.add(new ClientTransferLog(exportDeptId,exportUserId,importDeptId,importUserId,clientId,num, LocalDateTime.now()));
        }
        boolean flag1 = clientTransferLogService.saveBatch(clientTransferLogs);

        //更新client表里userID，userNum
        Integer flag2 = clientService.updateClientUser(clientId,importDeptId,importUserId);

        //更新chance表里userid
        Integer flag3 = chanceService.updateChanceUserByClientId(clientId,importUserId);

        Integer flag4 = chanceDraftService.updateChanceUserByClientId(clientId,importUserId);

        if (!flag1) {
            respBean = RespBean.ok(400, "add transfer_log failure");
        } else if (flag2<=0) {
            respBean = RespBean.ok(400, "update client failure");
        }else if (flag3<=0) {
            respBean = RespBean.ok(400, "update chanceUser failure");
        }else {
            respBean = RespBean.ok(200, "query successfully");
        }
        return respBean;
    }

    @GetMapping("query_client_transfer_log")
    public RespBean queryClientTransferLog(@RequestParam (required = false)Integer exportDeptId,@RequestParam (required = false)Integer exportUserId,
                                           @RequestParam (required = false)Integer importDeptId,@RequestParam (required = false)Integer importUserId,
                                           @RequestParam (required = false)String clientName,@RequestParam (required = false)String chanceName){
        RespBean respBean;
        TransferLogPara transferLogPara = new TransferLogPara(exportDeptId,exportUserId,importDeptId,importUserId,clientName,chanceName);
        List<TransferLogWithChance> transferLogWithChance = clientTransferLogService.getTransferLog(transferLogPara);

        if (transferLogWithChance==null) {
            respBean = RespBean.ok(400, "query transLog failure");
        }else {
            respBean = RespBean.ok(200, "query successfully",transferLogWithChance);
        }
        return respBean;
    }

}

