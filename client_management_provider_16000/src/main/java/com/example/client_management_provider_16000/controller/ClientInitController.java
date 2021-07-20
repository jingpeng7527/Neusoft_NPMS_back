package com.example.client_management_provider_16000.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.QueryClient;
import com.example.client_management_provider_16000.dto.RespBean;
import com.example.client_management_provider_16000.entity.*;
import com.example.client_management_provider_16000.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientInitController {
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
    UserServiceImpl userService;


    //初始化

    @Cacheable(cacheNames = "initUser")
    @GetMapping("init_user")
    public List<User> initUser(){
        return userService.list();
    }

    @Cacheable(cacheNames = "initCompanyType")
    @GetMapping("/init_company_type")
    public List<CompanyType> initCompangType(){
        return companyTypeService.list();
    }

//    @RequestParam(value = "userId") Integer userId,@RequestParam(value = "userRole") Integer UserRole
    //1客户经理，34销售总监、事业部总经理，2营销副总，0高级领导（数据库里没有）

    @Cacheable(cacheNames = "initTaxType")
    @GetMapping("init_tax_type")
    public List<TaxType> initTaxType(){
        return taxTypeService.list();
    }

    @Cacheable(cacheNames = "initAccountGroup")
    @GetMapping("init_account_group")
    public List<AccountGroup> initAccountType(){
        return accountGroupService.list();
    }

    @Cacheable(cacheNames = "initClientRelateType")
    @GetMapping("init_client_relate_type")
    public List<ClientRelateType> initClientRelateType(){
        return clientRelateTypeService.list();
    }

    @GetMapping("init_client")
    public RespBean initClient(@RequestParam(value = "user_id",required = false) Integer user_id, @RequestParam(value = "role_id",required = false) Integer role_id){
        RespBean respBean = null;
        //1客户经理，34销售总监、事业部总经理，2营销副总，0高级领导（数据库里没有）

        List<QueryClient> clientQueryList = new ArrayList<>();//返回列表
        List<Client> clientList = new ArrayList<>();//查询到相关客户列表
        Integer dept = userService.getById(user_id).getDeptId();//查询用户所属部门
        String deptName = deptService.getById(dept).getName();//部门名字


        if (role_id==1||role_id==3){
            QueryWrapper<Client> q = Wrappers.query();
            q.eq("user_id",user_id);
            clientList = clientService.list(q) ;//该用户下客户列表
            String userName = userService.getById(user_id).getUsername();//用户姓名
//            System.out.println(userName);
            for (Client c:clientList){
//                System.out.println(c.getCompanyTypeId());
//                System.out.println(companyTypeService.getById(c.getCompanyTypeId()));
                String company = companyTypeService.getById(c.getCompanyTypeId()).getName();//company名字
                QueryClient queryClient = new QueryClient(c,dept,deptName,user_id,userName,company);
                clientQueryList.add(queryClient);
            }
        }else if(role_id ==4){
            List<User> users = userService.list(Wrappers.<User>lambdaQuery().eq(User::getDeptId,dept));//该部门下所有童虎列表
//                        System.out.println(users);
            for (User u :users){
                QueryWrapper<Client> q = Wrappers.query();
                q.eq("user_id",u.getId());
//                System.out.println(u.getId());
                clientList = clientService.list(q);//该用户下所有客户
                String userName = userService.getById(user_id).getUsername();//用户姓名
                for (Client c:clientList){
//                    System.out.println(c.getId());
//                    System.out.println(dept);
                    String company = companyTypeService.getById(c.getCompanyTypeId()).getName();

                    QueryClient queryClient = new QueryClient(c,dept,deptName,u.getId(),userName,company);
                    clientQueryList.add(queryClient);
                }
            }
        }

        if (clientQueryList.size()>0) {
            respBean = RespBean.ok(200, "find successfully ",clientQueryList);
        } else {
            respBean = RespBean.ok(400, "find failure or you have no right to init client" );
        }
        return respBean;
    }
}
