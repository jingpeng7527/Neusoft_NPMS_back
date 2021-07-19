package com.example.client_management_provider_16000.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.client_management_provider_16000.dto.TransferLogPara;
import com.example.client_management_provider_16000.dto.TransferLogWithChance;
import com.example.client_management_provider_16000.entity.ClientTransferLog;
import com.example.client_management_provider_16000.mapper.ClientTransferLogMapper;
import com.example.client_management_provider_16000.service.IClientTransferLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
@Service
public class ClientTransferLogServiceImpl extends ServiceImpl<ClientTransferLogMapper, ClientTransferLog> implements IClientTransferLogService {

    @Autowired
    ClientTransferLogMapper clientTransferLogMapper;

    @Override
    public List<TransferLogWithChance> getTransferLog(TransferLogPara transferLogPara) {
        return clientTransferLogMapper.getTransferLog(transferLogPara);
    }
}
