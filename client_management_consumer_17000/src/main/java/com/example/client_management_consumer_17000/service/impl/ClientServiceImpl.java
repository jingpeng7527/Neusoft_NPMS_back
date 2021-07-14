package com.example.client_management_consumer_17000.service.impl;

import com.example.client_management_consumer_17000.entity.Client;
import com.example.client_management_consumer_17000.mapper.ClientMapper;
import com.example.client_management_consumer_17000.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {

}
