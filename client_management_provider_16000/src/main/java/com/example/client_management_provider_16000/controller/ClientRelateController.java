package com.example.client_management_provider_16000.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.dto.SaveClientRelate;
import com.example.client_management_provider_16000.entity.ClientContact;
import com.example.client_management_provider_16000.entity.ClientRelate;
import com.example.client_management_provider_16000.service.impl.ClientRelateServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abigail
 * @since 2021-07-14
 */
@RestController
@RequestMapping("/client")
public class ClientRelateController {


    @Autowired
    ClientRelateServiceImpl clientRelateService;


    @PostMapping("create_client_relate")
    public RespBean createClientRelate(@RequestBody List<ClientRelate> saveClientContactList){
//        ClientRelate clientRelate = new ClientRelate();
//        clientRelate.setClientCurrentId(saveClientContact.getClient_current_id());
//        clientRelate.setClientRelateId(saveClientContact.getClient_relate_type_id());
//        clientRelate.setClientRelateTypeId(saveClientContact.getClient_relate_type_id());
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

    @GetMapping("delete_client_relate")
    public RespBean deleteClientContact(Integer clientRelateId){
        boolean sig = clientRelateService.removeById(clientRelateId);
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
//                QueryWrapper<Usersinfo> qw =
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
        if (client!=null) {
            respBean = RespBean.ok(200, "update successfully ",client);
        } else {
            respBean = RespBean.ok(400, "update failure" );
        }
        return respBean;
    }
}

