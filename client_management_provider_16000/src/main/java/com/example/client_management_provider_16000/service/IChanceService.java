package com.example.client_management_provider_16000.service;

import com.example.client_management_provider_16000.entity.Chance;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
public interface IChanceService extends IService<Chance> {
    Integer updateChanceUserByClientId(Integer client_id,Integer user_id);
}
