package com.example.client_management_provider_16000.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.*;
import com.example.client_management_provider_16000.entity.*;

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
 * 前端控制器
 * </p>
 *
 * @author abigail
 * @since 2021-07-13
 */
@CrossOrigin
@RestController
@EnableDiscoveryClient
@RequestMapping("/client")
@Api(tags = "client")
public class ClientController {
    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    ChanceDraftServiceImpl chanceDraftService;

    @Autowired
    ChanceServiceImpl chanceService;

    //客户
    @GetMapping("query_client")
    public RespBean queryClient
//            (@RequestBody QueryClientPara queryClientPara){
    (@RequestParam(value = "name", required = false) String client_name,
     @RequestParam(value = "clientNum", required = false) String client_num,
     @RequestParam(value = "companyTypeId", required = false) Integer company_type_id,
     @RequestParam(value = "deptId", required = false) Integer dept_id,
     @RequestParam(value = "userId", required = false) Integer user_id2) {
        RespBean respBean = null;
        QueryClientPara queryClientPara = new QueryClientPara(client_num, client_name, company_type_id, dept_id, user_id2);
        System.out.println(queryClientPara);
        List<QueryClient> clientQueryList = clientService.queryClient(queryClientPara);
        if (clientQueryList != null && clientQueryList.size() > 0) {
            respBean = RespBean.ok(200, "find successfully ", clientQueryList);
        } else {
            respBean = RespBean.ok(400, "find failure",new ArrayList<>());
        }
        return respBean;
    }

    @PostMapping("create_client")
    public RespBean createClient(@RequestBody Client client) {

//        Integer num++////
//        delete->list client_relate////
        //登录
        //relate详情////

//        if (client.getId() == null) {
        RespBean respBean = null;
        Client client1 = clientService.getOne(Wrappers.<Client>lambdaQuery().eq(Client::getName,client.getName()));
//        System.out.println("client1"+client1);
        Client client2 = clientService.getOne(Wrappers.<Client>lambdaQuery().eq(Client::getTaxpayerCode,client.getTaxpayerCode()));
//        System.out.println("client2"+client2);
            if (client1!=null){
                respBean = RespBean.ok(401,"客户姓名重复");
            }else if (client2!=null){
                respBean = RespBean.ok(402,"纳税人编号重复");
            }else {
                client.setCreateTime(LocalDateTime.now());

                List<Client> clientList = clientService.list();
                String clientNum = clientList.get(clientList.size() - 1).getClientNum();
                int num = Integer.parseInt(clientNum) + 1;

                client.setClientNum(Integer.toString(num));
//        }

                boolean sig = clientService.saveOrUpdate(client);

                if (sig) {
                    respBean = RespBean.ok(200, "add successfully ", client);
                } else {
                    respBean = RespBean.ok(400, "add failure");
                }
            }
        return respBean;
    }

    @PostMapping("modify_client")
    public RespBean modifyClient(@RequestBody Client client) {
        RespBean respBean = null;
        Client client1 = clientService.getOne(Wrappers.<Client>lambdaQuery().eq(Client::getName,client.getName()));
//        System.out.println("client111"+client1);
        Client client2 = clientService.getOne(Wrappers.<Client>lambdaQuery().eq(Client::getTaxpayerCode,client.getTaxpayerCode()));
//        System.out.println("client222"+client2);
        if (client1!=null&&client1.getId()!=client.getId()){
            respBean = RespBean.ok(401,"客户姓名重复");
        }else if (client2!=null&&client2.getId()!=client.getId()){
            respBean = RespBean.ok(402,"纳税人编号重复");
        }else {
            boolean sig = clientService.updateById(client);

            Integer flag1 = clientService.updateClientInChance(client);

            Integer flag2 = clientService.updateClientInChanceDraft(client);
            if (!sig) {
                respBean = RespBean.ok(400, "update client failure");
//        } else if (flag1==0) {
//            respBean = RespBean.ok(401, "update clientInChance failure or no chance for this client ");
//        } else if (flag2==0) {
//            respBean = RespBean.ok(402, "update clientInChanceDraft failure or no chanceDraft for this client");
            } else {
                respBean = RespBean.ok(200, "update successfully ", clientService.getById(client.getId()));
            }
        }
        return respBean;
    }

    @PostMapping("frozen_client")
    public RespBean frozenClient(@RequestBody Client client) {
        boolean sig = clientService.updateById(client);
        RespBean respBean = null;
        if (!sig) {
            respBean = RespBean.ok(400, "update client failure");
        } else {
            respBean = RespBean.ok(200, "update successfully ", clientService.getById(client.getId()));
        }
        return respBean;
    }

    @GetMapping("query_client_detail")
    public RespBean queryClientDetail(Integer clientId) {
//        QueryWrapper<Client> q = Wrappers.query();
//        q.eq("client_num",clientNum);
//        Client client = clientService.getOne(q);
        Client client = clientService.getById(clientId);
        RespBean respBean = null;
        if (client != null) {
            respBean = RespBean.ok(200, "query successfully ", client);
        } else {
            respBean = RespBean.ok(400, "query failure");
        }
        return respBean;
    }
}