package com.neusoft.npms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.entity.SubChance;
import com.neusoft.npms.entity.SubChanceDraft;
import com.neusoft.npms.mapper.SubChanceDraftMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.npms.mapper.SubChanceMapper;
import com.neusoft.npms.service.ISubChanceDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@Service
public class SubChanceDraftServiceImpl extends ServiceImpl<SubChanceDraftMapper, SubChanceDraft> implements ISubChanceDraftService {

    @Autowired
    SubChanceDraftMapper subChanceDraftMapper;

    @Autowired
    SubChanceMapper subChanceMapper;

    public String generateSubChanceNum(String chanceNum){
        List<SubChanceDraft> subChanceDraftList= subChanceDraftMapper.selectList(Wrappers.<SubChanceDraft>lambdaQuery().
                eq(SubChanceDraft::getChanceNum,chanceNum)
                .orderByDesc(SubChanceDraft::getSubChanceNum).last("limit 0,1"));

        List<SubChance> subChanceList = subChanceMapper.selectList(Wrappers.<SubChance>lambdaQuery().
                eq(SubChance::getSubChanceNum,chanceNum)
                .orderByDesc(SubChance::getSubChanceNum).last("limit 0,1"));

        // 两个list都空
        if ((subChanceDraftList == null || subChanceDraftList.size() == 0)&&(subChanceList == null || subChanceList.size() == 0))
            return chanceNum+"01";

        // 两个list都不空
        if ((subChanceDraftList != null && subChanceDraftList.size() != 0)&&(subChanceList != null && subChanceList.size() != 0)) {
            return String.valueOf(Integer.max(Integer.parseInt(subChanceDraftList.get(0).getSubChanceNum()),Integer.parseInt(subChanceList.get(0).getSubChanceNum()))+1);
        }

        // draft 为空
        if ((subChanceDraftList == null || subChanceDraftList.size() == 0)){
            return String.valueOf(Integer.parseInt(subChanceList.get(0).getSubChanceNum())+1);
        } else { // 本体为空
            System.out.println("subChanceDraftList"+subChanceDraftList.get(0));
            return String.valueOf(Integer.parseInt(subChanceDraftList.get(0).getSubChanceNum())+1);
        }
    }
}
