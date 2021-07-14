package com.example.client_management_provider_16000.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.entity.Client;
import com.example.client_management_provider_16000.entity.ClientContact;
import com.example.client_management_provider_16000.service.impl.ClientContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abigail
 * @since 2021-07-13
 */
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

//    @PostMapping("modify_client_contact")
//    public RespBean modifyClientContact(@RequestBody ClientContact clientContact){
//        boolean sig = clientContactService.updateById(clientContact);
//        RespBean respBean = null;
//        if (sig) {
//            respBean = RespBean.ok(200, "add successfully ",clientContact);
//        } else {
//            respBean = RespBean.ok(400, "add failure" );
//        }
//        return respBean;
//    }

    @GetMapping("delete_client_contact")
    public RespBean deleteClientContact(Integer client_contact_id){
        boolean sig = clientContactService.removeById(client_contact_id);
        RespBean respBean = null;
        if (sig) {
            respBean = RespBean.ok(200, "delete successfully");
        } else {
            respBean = RespBean.ok(400, "delete failure" );
        }
        return respBean;
    }

    @GetMapping("query_client_contact")
    public RespBean queryClientContact(Integer clientId){
        QueryWrapper<ClientContact> q = Wrappers.query();
//                QueryWrapper<Usersinfo> qw =
        q.eq("client_id", clientId);
        List<ClientContact> client = clientContactService.list(q);
        RespBean respBean = null;
        if (client.size()>0) {
            respBean = RespBean.ok(200, "query successfully ",client);
        } else {
            respBean = RespBean.ok(400, "query failure" );
        }
        return respBean;
    }
}

