package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.SubChance;
import com.neusoft.npms.entity.SubChanceDraft;
import com.neusoft.npms.service.ISubChanceDraftService;
import com.neusoft.npms.service.ISubChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/npms/sub-chance-draft")
public class SubChanceDraftController {

    @Autowired
    ISubChanceDraftService iSubChanceDraftService;

    // 保存子机会（草稿）
    @PostMapping("/save_sub_chance_draft")
    public RespBean saveSubChanceDraft(@RequestBody List<SubChanceDraft> subChanceDraftList){
        System.out.println("/save_sub_chance_draft");
        System.out.println(subChanceDraftList);

        if (subChanceDraftList == null) return RespBean.error(400,"参数为空");
        if (subChanceDraftList.size() == 0) return RespBean.error(400, "真的没有sub_chance要存么！！！");

        for (SubChanceDraft subChance:subChanceDraftList) {
            if (subChance.getChanceNum() == null || subChance.getChanceNum().equals(""))
                return RespBean.error(400,"缺chance_num");
        }

        for (SubChanceDraft subChance:subChanceDraftList) {
            subChance.setSubChanceStatusId(4);
            // 如果没有subChanceNum先生成
            if (subChance.getSubChanceNum() == null || subChance.getSubChanceNum().equals("")){
                subChance.setSubChanceNum(iSubChanceDraftService.generateSubChanceNum(subChance.getChanceNum()));
            }
            iSubChanceDraftService.saveOrUpdate(subChance, Wrappers.<SubChanceDraft>lambdaUpdate()
                    .eq(SubChanceDraft::getSubChanceNum,subChance.getSubChanceNum()));
        }

        List<SubChanceDraft> result = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,subChanceDraftList.get(0).getChanceNum()));
        return RespBean.ok(200,"保存子机会成功",result);
    }
}

