package com.example.client_management_provider_16000.service;

import com.example.client_management_provider_16000.entity.ChanceDraft;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abigail
 * @since 2021-07-18
 */
public interface IChanceDraftService extends IService<ChanceDraft> {
    public Integer updateChanceUserByClientId(Integer client_id, Integer user_id);
}
