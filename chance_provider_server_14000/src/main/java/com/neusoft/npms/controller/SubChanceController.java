package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.dto.ReturnSubChance;
import com.neusoft.npms.entity.SubChance;
import com.neusoft.npms.entity.SubChanceDraft;
import com.neusoft.npms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@RequestMapping("/npms/sub-chance")
public class SubChanceController {

    @Autowired
    ISubChanceService iSubChanceService;

    @Autowired
    ISubChanceDraftService iSubChanceDraftService;

    @Autowired
    IChanceTypeProductService iChanceTypeProductService;

    @Autowired
    IDeptService iDeptService;

    @Autowired
    IChanceStatusService iChanceStatusService;


    @GetMapping("/get_sub_chance_in_draft_and_real_by_chance_num")
    public RespBean getSubChanceInDraftAndRealByChanceNum(String chanceNum){
        System.out.println("/get_sub_chance_in_draft_and_real_by_chance_num");
        System.out.println("chanceNum: "+chanceNum);
        System.out.println();
        if (chanceNum == null || chanceNum.equals("")) return RespBean.error(400,"参数为空");

        List<SubChance> subChanceList = iSubChanceService.list(Wrappers.<SubChance>lambdaQuery().eq(SubChance::getChanceNum,chanceNum));
        List<SubChanceDraft> subChanceDraftList = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,chanceNum));

//        if (subChanceDraftList != null && subChanceDraftList.size() != 0)
//            return RespBean.ok(200,"通过chanceNum 在draft和real表中获取sub_chance",subChanceDraftList);
//
//        if (subChanceList != null && subChanceList.size() != 0)
//            return RespBean.ok(200,"通过chanceNum 在draft和real表中获取sub_chance",subChanceList);

        Set<String> subChanceNumSet = new HashSet<>();
        for (SubChanceDraft s:subChanceDraftList)
            subChanceNumSet.add(s.getSubChanceNum()); // SubChanceDraft 中的内容
        for (SubChance s:subChanceList) {
            if (subChanceNumSet.contains(s.getSubChanceNum())) continue; // 重复的只显示 SubChanceDraft 的内容
            else subChanceDraftList.add(new SubChanceDraft(s)); // 不重复的也返回
        }
        if (subChanceDraftList == null || subChanceDraftList.size() == 0) return RespBean.ok(200,"没有找到这个chance_num对应的sub_chance");
        else {
            List<ReturnSubChance> returnList = new ArrayList<>();
            for (SubChanceDraft s:subChanceDraftList)
                returnList.add(new ReturnSubChance(s,iChanceTypeProductService,iDeptService,iChanceStatusService));
            return RespBean.ok(200,"通过chanceNum 在draft和real表中获取sub_chance",returnList);
        }
    }

}

