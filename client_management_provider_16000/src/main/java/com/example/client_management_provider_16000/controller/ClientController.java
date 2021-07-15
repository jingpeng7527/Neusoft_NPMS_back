package com.example.client_management_provider_16000.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.QueryClient;
import com.example.client_management_provider_16000.dto.QueryClientPara;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.dto.SaveClientRelate;
import com.example.client_management_provider_16000.entity.*;
import com.example.client_management_provider_16000.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2021-07-13
 */

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientContactServiceImpl clientContactService;
    @Autowired
    AccountGroupServiceImpl accountGroupService;
    @Autowired
    TaxTypeServiceImpl taxTypeService;
    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    ClientRelateTypeServiceImpl clientRelateTypeService;
    @Autowired
    CompanyTypeServiceImpl companyTypeService;
    @Autowired
    DeptServiceImpl deptService;
    @Autowired
    ClientRelateServiceImpl clientRelateService;


    //初始化
    @GetMapping("/init_company_type")
    public List<CompanyType> initCompangType(){
        return companyTypeService.list();
    }

//    @RequestParam(value = "userId") Integer userId,@RequestParam(value = "userRole") Integer UserRole
    //1客户经理，34销售总监、事业部总经理，2营销副总，0高级领导（数据库里没有）

    @GetMapping("init_tax_type")
    public List<TaxType> initTaxType(){
        return taxTypeService.list();
    }

    @GetMapping("init_account_group")
    public List<AccountGroup> initAccountType(){
        return accountGroupService.list();
    }

    @GetMapping("init_client_relate_type")
    public List<ClientRelateType> initClientRelateType(){
        return clientRelateTypeService.list();
    }


    //客户
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
        client.setCreateTime(LocalDateTime.now());

        List<Client> clientList = clientService.list();
        String clientNum = clientList.get(clientList.size()-1).getClientNum();
        int num = Integer.parseInt(clientNum)+1;

        System.out.println(num);
        client.setClientNum(Integer.toString(num));
//        Integer num++////
//        delete->list client_relate////
        //登录
        //relate详情////
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


    //客户关联关系
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
    public RespBean deleteClientRelate(List<Integer> clientRelateId){
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
            respBean = RespBean.ok(200, "query successfully ",saveClientRelates);
        } else {
            respBean = RespBean.ok(400, "query failure" );
        }
        return respBean;
    }

}