package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.dto.ReturnPolicyMaker;
import com.neusoft.npms.entity.Policymaker;
import com.neusoft.npms.service.IEffectLevelService;
import com.neusoft.npms.service.IPolicymakerService;
import com.neusoft.npms.service.IRecognitionLevelService;
import org.apache.velocity.util.ArrayListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@CrossOrigin
@RestController
@RequestMapping("/npms/policymaker")
public class PolicymakerController {

    @Autowired
    IPolicymakerService iPolicymakerService;
    @Autowired
    IEffectLevelService iEffectLevelService;
    @Autowired
    IRecognitionLevelService iRecognitionLevelService;

    @GetMapping("/get_policymaker_by_chance_num")
    public RespBean getPolicymakerByChanceNum(String chance_num){
        System.out.println("/get_policymaker_by_chance_num: chance_num:"+chance_num);
        if (chance_num == null || chance_num.equals(""))
            return RespBean.error(400,"参数为空");
        List<Policymaker> result = iPolicymakerService.
                list(Wrappers.<Policymaker>lambdaQuery().eq(Policymaker::getChanceNum,chance_num));

        List<ReturnPolicyMaker> returnList = new ArrayList<>();
        for (Policymaker policymaker:result) returnList.add(new ReturnPolicyMaker(policymaker,iPolicymakerService,iEffectLevelService,iRecognitionLevelService));


        return RespBean.ok(200,"获取到policymaker列表",returnList);
    }

    @PostMapping("/insert_or_update_policymaker")
    public RespBean insertOrUpdatePolicymaker(@RequestBody List<Policymaker> policymakerList){
        System.out.println("/insert_or_update_policymaker "+ policymakerList);
        // 信息不完整
        for (Policymaker policymaker:policymakerList){
            if (policymaker == null
                    ||policymaker.getChanceNum() == null || policymaker.getChanceNum().equals("")
                    || policymaker.getName() == null || policymaker.getName().equals("")
                    || policymaker.getDept() == null || policymaker.getDept().equals("")
                    || policymaker.getPosition() == null || policymaker.getPosition().equals("")
                    || policymaker.getTel() == null || policymaker.getTel().equals("")
                    || policymaker.getEffectLevelId() == null || policymaker.getEffectLevelId() == 0
                    || policymaker.getRecognitionLevelId() == null || policymaker.getRecognitionLevelId() == 0
                    || policymaker.getPolicymakerTypeId() == null || policymaker.getPolicymakerTypeId() == 0){

                return RespBean.error(400,"信息不完整无法添加");
            }

        }

        for (Policymaker policymaker:policymakerList){
            boolean result = iPolicymakerService.saveOrUpdate(policymaker);
            if (!result) return RespBean.error(400,"发生未知错误 数据库乱了 快改库");
        }
        return RespBean.ok(200,"新增/更新 policymaker 成功");
    }

    @PostMapping("/delete_policymakers")
    public RespBean deletePolicymakers (@RequestBody List<String> idList){
        System.out.println("/delete_policymakers");
        System.out.println("idList"+idList.size());
        if (idList == null || idList.size() == 0){
            return RespBean.error(400,"参数为空");
        }

        for (String id:idList) {
            boolean result = iPolicymakerService.removeById(id);
            if (!result) return RespBean.error(400, "发生未知错误 数据库乱了 快改库");
        }
        return RespBean.ok(200,"删除成功");
    }



}

