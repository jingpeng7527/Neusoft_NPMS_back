package com.example.client_management_provider_16000.mapper;

import com.example.client_management_provider_16000.dto.TransferLogPara;
import com.example.client_management_provider_16000.dto.TransferLogWithChance;
import com.example.client_management_provider_16000.entity.ClientTransferLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
@Repository("ClientTransferLogMapper")
public interface ClientTransferLogMapper extends BaseMapper<ClientTransferLog> {
    public List<TransferLogWithChance> getTransferLog(TransferLogPara transferLogPara);
}
