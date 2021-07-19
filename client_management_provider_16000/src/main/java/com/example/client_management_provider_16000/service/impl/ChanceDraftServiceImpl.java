package com.example.client_management_provider_16000.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.entity.Chance;
import com.example.client_management_provider_16000.entity.ChanceDraft;
import com.example.client_management_provider_16000.mapper.ChanceDraftMapper;
import com.example.client_management_provider_16000.service.IChanceDraftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-18
 */
@Service
public class ChanceDraftServiceImpl extends ServiceImpl<ChanceDraftMapper, ChanceDraft> implements IChanceDraftService {

    @Autowired
    ChanceDraftMapper chanceDraftMapper;

    @Override
    public Integer updateChanceUserByClientId(Integer client_id, Integer user_id) {
        QueryWrapper<ChanceDraft> queryWrapper = Wrappers.query();
        queryWrapper.eq("client_id",client_id).eq("chance_status_id",4);
        chanceDraftMapper.delete(queryWrapper);

        UpdateWrapper<ChanceDraft> updateWrapper = Wrappers.update();
        updateWrapper.eq("client_id",client_id);

        ChanceDraft chance = new ChanceDraft();
        chance.setUserId(user_id);
        return chanceDraftMapper.update(chance,updateWrapper);
    }
}
