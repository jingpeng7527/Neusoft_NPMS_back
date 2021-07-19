package com.neusoft.npms.service.impl;

import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.dto.ReturnChanceBasicInfo;
import com.neusoft.npms.entity.Chance;
import com.neusoft.npms.mapper.ChanceMapper;
import com.neusoft.npms.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ChanceServiceImpl extends ServiceImpl<ChanceMapper, Chance> implements IChanceService {

    @Autowired
    ChanceMapper chanceMapper;

    @Autowired
    IUserService iUserService;

    @Autowired
    ISubChanceService iSubChanceService;

    @Autowired
    IChanceTypeProductService iChanceTypeProductService;

    @Autowired
    IChanceStageService iChanceStageService;

    @Autowired
    IChanceSourceService iChanceSourceService;

    @Autowired
    IDeptService iDeptService;

    @Autowired
    IChanceStatusService iChanceStatusService;

    public List<Chance> getChanceByCondition(ChanceQueryCondition chanceQueryCondition){
        return chanceMapper.getChanceByCondition(chanceQueryCondition);
    }

    public List<Chance> getChanceWithChanceTypeAndProductNum(ChanceQueryCondition chanceQueryCondition){
        return chanceMapper.getChanceWithChanceTypeAndProductNum(chanceQueryCondition);
    }

    public List<ReturnChanceBasicInfo> translate(List<Chance> chanceList){
        List<ReturnChanceBasicInfo> result = new ArrayList<>();
        for (Chance c:chanceList){
            System.out.println("c 11111111"+c);
            ReturnChanceBasicInfo r = new ReturnChanceBasicInfo(c, iChanceSourceService, iChanceStageService,
                    iDeptService, iUserService, iChanceStatusService);
            result.add(r);
        }
//        System.out.println("ChanceServiceImpl size" + result.size());
        return result;
    }

    //

//    public List<Chance> getChanceWithChanceTypeAndProductNum(ChanceQueryCondition chanceQueryCondition){
//
//        // 获取 chanceTypeProduct
//        List<ChanceTypeProduct> chanceTypeProductList
//                = iChanceTypeProductService.getItemsByChanceAndProduct(chanceQueryCondition);
//
//        // 获得 包含chanceTypeProduct-id
//        List<SubChance> subChanceList = null;
//        for (ChanceTypeProduct a:chanceTypeProductList) {
//            List<SubChance> tmp = iSubChanceService.list(Wrappers.<SubChance>lambdaQuery().eq(SubChance::getChanceTypeProductId,a.getId()));
//            for (SubChance s:tmp) subChanceList.add(s);
//        }
//
//        // 通过subchance 获取chance —— 只满足 type 和 product的chance
//        for(SubChance s:subChanceList) {
//            Set <Chance> chanceSet = new HashSet<>();
//            chanceSet.add(getOne(Wrappers.<Chance>lambdaQuery().eq(Chance::getChanceNum,s.getChanceNum())));
//        }
//
//        // 只满足 query condition的chance
//        List<Chance> chanceList = getChanceByCondition(chanceQueryCondition);
//
//        for (ChanceTypeProduct c:chanceTypeProductList) idList.add(c.getId());
//
//        List<SubChance> subChanceList
//                = iSubChanceService.listByIds(idList);
//
//        return null;
//    }
}
