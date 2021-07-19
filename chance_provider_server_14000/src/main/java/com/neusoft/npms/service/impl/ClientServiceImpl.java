package com.neusoft.npms.service.impl;

import com.neusoft.npms.entity.Client;
import com.neusoft.npms.mapper.ClientMapper;
import com.neusoft.npms.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {

}
