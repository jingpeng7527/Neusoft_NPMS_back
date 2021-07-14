package com.example.client_management_provider_16000.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.QueryClient;
import com.example.client_management_provider_16000.dto.QueryClientPara;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.entity.Client;
import com.example.client_management_provider_16000.entity.ClientContact;
import com.example.client_management_provider_16000.service.impl.ClientContactServiceImpl;
import com.example.client_management_provider_16000.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;


    @GetMapping("query_client")
    public RespBean queryClient
//            (@RequestBody QueryClientPara queryClientPara){
           ( @RequestParam(value = "clientName",required = false) String client_name,
                                @RequestParam(value = "clientNum",required = false) String client_num,
                                @RequestParam(value = "companyTypeId",required = false) Integer company_type_id,
                                @RequestParam(value = "deptId",required = false) Integer dept_id,
                                @RequestParam(value = "userId",required = false) Integer user_id2) {
        RespBean respBean = null;
        QueryClientPara queryClientPara = new QueryClientPara(client_num,client_name,company_type_id,dept_id,user_id2);
        System.out.println(queryClientPara);
        List<QueryClient> clientQueryList = clientService.queryClient(queryClientPara);
//        List<QueryClient> clientQueryList = clientService.queryClient(client_name,client_num,company_type_id,dept_id,user_id2);
        if (clientQueryList!=null && clientQueryList.size()>0) {
            respBean = RespBean.ok(2001, "find successfully ",clientQueryList);
        } else {
            respBean = RespBean.ok(1001, "find failure" );
        }
        return respBean;
    }

    @PostMapping("create_client")
    public RespBean createClient(@RequestBody Client client){
        System.out.println(client);
        boolean sig = clientService.saveOrUpdate(client);
        RespBean respBean = null;
        if (sig) {
            respBean = RespBean.ok(200, "add successfully ",client);
        } else {
            respBean = RespBean.ok(400, "add failure" );
        }
        return respBean;
    }

//    @PostMapping("modify_client")
//    public RespBean modifyClient(@RequestBody Client client){
//        boolean sig = clientService.updateById(client);
//        RespBean respBean = null;
//        if (sig) {
//            respBean = RespBean.ok(200, "update successfully ",client);
//        } else {
//            respBean = RespBean.ok(400, "update failure" );
//        }
//        return respBean;
//    }

    @GetMapping("query_client_detail")
        public RespBean queryClientDetail(Integer clientId){
//        QueryWrapper<Client> q = Wrappers.query();
//        q.eq("client_num",clientNum);
//        Client client = clientService.getOne(q);
        Client client = clientService.getById(clientId);
        RespBean respBean = null;
        if (client!=null) {
            respBean = RespBean.ok(200, "update successfully ",client);
        } else {
            respBean = RespBean.ok(400, "update failure" );
        }
        return respBean;
    }

}