package com.example.client_management_provider_16000.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.QueryClient;
import com.example.client_management_provider_16000.dto.QueryClientPara;
import com.example.client_management_provider_16000.entity.Client;
import com.example.client_management_provider_16000.mapper.ClientMapper;
import com.example.client_management_provider_16000.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-13
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {

    @Autowired
    ClientMapper clientMapper;


    @Override
    public List<QueryClient> queryClient(QueryClientPara queryClientPara){
        return clientMapper.queryClient(queryClientPara);

    }
}
