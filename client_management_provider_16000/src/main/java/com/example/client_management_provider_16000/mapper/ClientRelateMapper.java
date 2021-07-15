package com.example.client_management_provider_16000.mapper;

import com.example.client_management_provider_16000.dto.SaveClientRelate;
import com.example.client_management_provider_16000.entity.ClientRelate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abigail
 * @since 2021-07-14
 */
@Repository("ClientRelateMapper")
public interface ClientRelateMapper extends BaseMapper<ClientRelate> {
    SaveClientRelate getSaveRelate(ClientRelate clientRelate);
}
