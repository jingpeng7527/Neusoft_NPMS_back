package com.neusoft.npms.service;

import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.dto.ReturnChanceBasicInfo;
import com.neusoft.npms.entity.Chance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.npms.entity.Dept;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public interface IChanceService extends IService<Chance> {
    List<Chance> getChanceByCondition(ChanceQueryCondition chanceQueryCondition);

    List<Chance> getChanceWithChanceTypeAndProductNum(ChanceQueryCondition chanceQueryCondition);

    List<ReturnChanceBasicInfo> translate(List<Chance> chanceList);

}
