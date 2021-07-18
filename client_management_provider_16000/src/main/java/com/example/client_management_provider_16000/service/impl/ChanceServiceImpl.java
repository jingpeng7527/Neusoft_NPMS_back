package com.example.client_management_provider_16000.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.entity.Chance;
import com.example.client_management_provider_16000.mapper.ChanceMapper;
import com.example.client_management_provider_16000.service.IChanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
@Service
public class ChanceServiceImpl extends ServiceImpl<ChanceMapper, Chance> implements IChanceService {

    @Autowired
    ChanceMapper chanceMapper;

    @Override
    public Integer updateChanceUserByClientId(Integer client_id, Integer user_id) {
        UpdateWrapper<Chance> updateWrapper = Wrappers.update();
        updateWrapper.eq("client_id",client_id);

        Chance chance = new Chance();
        chance.setUserId(user_id);
        return chanceMapper.update(chance,updateWrapper);
    }
}
