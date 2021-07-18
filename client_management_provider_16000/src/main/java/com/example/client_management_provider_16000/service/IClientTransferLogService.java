package com.example.client_management_provider_16000.service;

import com.example.client_management_provider_16000.dto.TransferLogPara;
import com.example.client_management_provider_16000.dto.TransferLogWithChance;
import com.example.client_management_provider_16000.entity.ClientTransferLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
public interface IClientTransferLogService extends IService<ClientTransferLog> {
    public List<TransferLogWithChance> getTransferLog(TransferLogPara transferLogPara);
}
