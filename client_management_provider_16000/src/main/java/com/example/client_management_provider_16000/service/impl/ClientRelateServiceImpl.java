package com.example.client_management_provider_16000.service.impl;

import com.example.client_management_provider_16000.dto.SaveClientRelate;
import com.example.client_management_provider_16000.entity.ClientRelate;
import com.example.client_management_provider_16000.mapper.ClientRelateMapper;
import com.example.client_management_provider_16000.service.IClientRelateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-14
 */
@Service
public class ClientRelateServiceImpl extends ServiceImpl<ClientRelateMapper, ClientRelate> implements IClientRelateService {

    @Autowired
    ClientRelateMapper relateMapper;

    @Override
    public SaveClientRelate getSaveRelate(ClientRelate clientRelate) {
        return relateMapper.getSaveRelate(clientRelate);
    }
}
