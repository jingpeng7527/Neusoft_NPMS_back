package com.neusoft.npms.service;

import com.neusoft.npms.dto.ApproveChanceDraft;
import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.entity.Chance;
import com.neusoft.npms.entity.ChanceDraft;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public interface IChanceDraftService extends IService<ChanceDraft> {

    List<ChanceDraft> getChanceWithChanceTypeAndProductNum(ChanceQueryCondition chanceQueryCondition);

    List<ChanceDraft> getChanceByCondition(ChanceQueryCondition chanceQueryCondition);

    String generateChanceNum();

    boolean approve(ApproveChanceDraft approveChanceDraft,int role);

    boolean back(ApproveChanceDraft approveChanceDraft,int role);

    boolean close(ApproveChanceDraft approveChanceDraft,int role);
}
