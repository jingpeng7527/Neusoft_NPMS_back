package com.example.client_management_provider_16000.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.dto.SaveClientRelate;
import com.example.client_management_provider_16000.entity.ClientRelate;
import com.example.client_management_provider_16000.service.impl.ClientRelateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRelateController {
    @Autowired
    ClientRelateServiceImpl clientRelateService;


    //客户关联关系
    @PostMapping("create_client_relate")
    public RespBean createClientRelate(@RequestBody List<ClientRelate> saveClientContactList){
        boolean sig = clientRelateService.saveOrUpdateBatch(saveClientContactList);
        for (ClientRelate clientRelate:saveClientContactList){
            System.out.println(clientRelate);
        }
        RespBean respBean = null;
        if (sig) {
            respBean = RespBean.ok(200, "add successfully ",saveClientContactList);
        } else {
            respBean = RespBean.ok(400, "add failure" );
        }
        return respBean;
    }

    @PostMapping("delete_client_relate")
    public RespBean deleteClientRelate(@RequestBody List<Integer> clientRelateId){
        boolean sig = clientRelateService.removeByIds(clientRelateId);
        RespBean respBean = null;
        if (sig) {
            respBean = RespBean.ok(200, "delete successfully");
        } else {
            respBean = RespBean.ok(400, "delete failure" );
        }
        return respBean;
    }

    @GetMapping("query_client_relate")
    public RespBean queryClientRelate(Integer clientCurrentId){
        QueryWrapper<ClientRelate> q = Wrappers.query();
        q.eq("client_current_id", clientCurrentId);
        List<ClientRelate> client = clientRelateService.list(q);
        List<SaveClientRelate> saveClientRelates = new ArrayList<>();
//                clientRelateService.getSaveRelate(client);

        for (ClientRelate clientRelate: client
        ) {
            saveClientRelates.add(clientRelateService.getSaveRelate(clientRelate));
        }
//        ClientRelate client = clientRelateService.getById(clientId);

        RespBean respBean = null;
        if (saveClientRelates.size()>0) {
            respBean = RespBean.ok(200, "query successfully ",saveClientRelates);
        } else {
            respBean = RespBean.ok(400, "query failure" );
        }
        return respBean;
    }
}
