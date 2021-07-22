package com.macro.cloud.service;

import cn.hutool.core.collection.CollUtil;
import com.macro.cloud.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
//        resourceRolesMap.put("/api/**", CollUtil.toList("1","2","3","4","5"));
//        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("1"));
//        resourceRolesMap.put("/api/user/testPost",CollUtil.toList("1"));
        //login
        resourceRolesMap.put("/api/user/login",CollUtil.toList("1","2","3","4","5"));

        //client
        resourceRolesMap.put("/client/client/create_client",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/frozen_client",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/modify_client",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/query_client",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/query_client_detail",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/init_account_group",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/init_client",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/init_client_relate_type",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/init_company_type",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/init_tax_type",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/init_user",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/create_client_relate",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/delete_client_relate",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/query_client_transfer_log",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/transfer_client",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/query_client_relate",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/create_client_contact",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/client/modify_client_contact",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/client/client/query_client_contact",CollUtil.toList("1","2","3","4","5"));

        //chance_trace_log
        resourceRolesMap.put("/chance_trace_log/chance/chance_trace_log/init_business_type",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance_trace_log/chance/chance_trace_log/create",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance_trace_log/chance/chance_trace_log/delete",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance_trace_log//chance/chance_trace_log/query",CollUtil.toList("1","2","3","4","5"));

        //chance
        resourceRolesMap.put("/chance/npms/chance-approve-log/get_chance_approve_log_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance/get_chance_basic_info_by_client_id",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance/get_chance_basic_info_in_draft_and_real_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance/get_departments",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance/modify_chance_basic_info",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance/query_chance_basic_info",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-draft/approve_chance_draft_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-draft/get_TOApprove_chance_basic_info_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-draft/get_TOApprove_chance_list_by_user_id",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-draft/get_TOApprove_sub_chance_list_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-draft/save_chance_in_draft",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-draft/submit",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-source/get_chance_source_service",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-stage/get_chance_stage",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-status/getChanceStatus",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-type-product/get_chance_type_by_product_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-type-product/get_chance_type_product",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-type-product/get_id_by_chance_type_and_product_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/chance-type-product/get_product_by_chance_type_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/competition/get_competition_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/competition/save_or_update_competition",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/policymaker/delete_policymakers",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/policymaker/get_policymaker_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/policymaker/insert_or_update_policymaker",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/product-dept/get_dept_by_product",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/sub-chance/get_sub_chance_in_draft_and_real_by_chance_num",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/sub-chance-draft/save_sub_chance_draft",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/chance/npms/user/get_user_by_dept_id",CollUtil.toList("1","2","3","4","5"));

        //sales_log
        resourceRolesMap.put("/sales/npms/sales_log/delete_sales_log",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/sales/npms/sales_log/insert_or_update",CollUtil.toList("1","2","3","4","5"));
        resourceRolesMap.put("/sales/npms/sales_log/query_sales_log",CollUtil.toList("1","2","3","4","5"));

        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
