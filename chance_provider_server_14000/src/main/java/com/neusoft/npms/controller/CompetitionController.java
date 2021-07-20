package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.dto.ReturnCompetition;
import com.neusoft.npms.entity.Competition;
import com.neusoft.npms.service.ICompetitionService;
import com.neusoft.npms.service.ICompetitivePositionService;
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
 * @since 2021-07-15
 */
@CrossOrigin
@RestController
@RequestMapping("/npms/competition")
public class CompetitionController {

    @Autowired
    ICompetitionService iCompetitionService;

    @Autowired
    ICompetitivePositionService iCompetitionPositionService;

    @GetMapping("/get_competition_by_chance_num")
    public RespBean getCompetitionByChanceNum(String chance_num){
        System.out.println("/get_competition_by_chance_num");
        System.out.println("chance_num: "+chance_num);
        System.out.println();
        if (chance_num == null || chance_num.equals(""))
            return RespBean.error(400,"参数为空");

        List<Competition> result = iCompetitionService.list(Wrappers.<Competition>lambdaQuery().
                eq(Competition::getChanceNum, chance_num));

        List<ReturnCompetition> returnList = new ArrayList<>();
        for (Competition c:result ) returnList.add(new ReturnCompetition(c,iCompetitionPositionService));

        return RespBean.ok(200,"根据chanceNum获取竞争情况",returnList);

    }

    @PostMapping("/save_or_update_competition")
    public RespBean save_or_update_competition(@RequestBody List<Competition> list){
        System.out.println("/save_or_update_competition");
        System.out.println("list size = "+list.size());
        System.out.println();

        if (list == null) return RespBean.error(400,"参数错误");

        for (Competition competition:list){
//            if (competition.getState() == null || competition.getState().equals("")) {
//                competition.setState("open");
//            }

            boolean result = iCompetitionService.saveOrUpdate(competition);
            if (!result) return RespBean.error(400,"发生未知错误 数据库乱了 快改库");
        }
        return RespBean.ok(200,"save or update competition 成功");
    }

//    @PostMapping("/close_competition")
//    public RespBean closeCompetition(@RequestBody List<String> idList){
//        System.out.println("/close_competition");
//        System.out.println("idList size = "+idList.size());
//        System.out.println();
//
//        if (idList == null || idList.size() == 0)
//            return RespBean.error(400, "参数为空或list为空");
//
//        for (String id:idList){
//            boolean result = iCompetitionService.
//                    update(Wrappers.<Competition>lambdaUpdate().eq(Competition::getId,id).set(Competition::isState,));
//            if (!result) return RespBean.error(400, "发生未知错误 数据库乱了 快改库");
//        }
//        return RespBean.ok(200,"删除了competition");
//    }
}

