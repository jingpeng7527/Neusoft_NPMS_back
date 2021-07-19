package com.example.client_management_provider_16000.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.entity.ClientContact;
import com.example.client_management_provider_16000.service.impl.ClientContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientContactController {
    @Autowired
    ClientContactServiceImpl clientContactService;


    @PostMapping("create_client_contact")
    public RespBean createClientContact(@RequestBody ArrayList<ClientContact> clientContact){
        boolean sig = clientContactService.saveOrUpdateBatch(clientContact);
        RespBean respBean = null;
        if (sig) {
            respBean = RespBean.ok(200, "add successfully ",clientContact);
        } else {
            respBean = RespBean.ok(400, "add failure" );
        }
        return respBean;
    }

    @PostMapping("modify_client_contact")
    public RespBean modifyClientContact(@RequestBody List<ClientContact> clientContact){
        boolean sig = clientContactService.updateBatchById(clientContact);
        RespBean respBean = null;
        if (sig) {
            respBean = RespBean.ok(200, "add successfully ",clientContact);
        } else {
            respBean = RespBean.ok(400, "add failure" );
        }
        return respBean;
    }

//    @GetMapping("delete_client_contact")
//    public RespBean deleteClientContact(Integer client_contact_id){
//        boolean sig = clientContactService.removeById(client_contact_id);
//        RespBean respBean = null;
//        if (sig) {
//            respBean = RespBean.ok(200, "delete successfully");
//        } else {
//            respBean = RespBean.ok(400, "delete failure" );
//        }
//        return respBean;
//    }

    //客户联系人
    @GetMapping("query_client_contact")
    public RespBean queryClientContact(Integer clientId){
        QueryWrapper<ClientContact> q = Wrappers.query();
        q.eq("client_id", clientId);
        List<ClientContact> client = clientContactService.list(q);
//        List<ClientContact> clientContacts = clientContactService.list();
        RespBean respBean = null;
        if (client.size()>0) {
            respBean = RespBean.ok(200, "query successfully ",client);
        } else {
            respBean = RespBean.ok(400, "query failure");
        }
        return respBean;
    }

}
