package com.example.client_management_provider_16000.service;

import com.example.client_management_provider_16000.dto.SaveClientRelate;
import com.example.client_management_provider_16000.entity.ClientRelate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abigail
 * @since 2021-07-14
 */
public interface IClientRelateService extends IService<ClientRelate> {
    SaveClientRelate getSaveRelate(ClientRelate clientRelate);
}
