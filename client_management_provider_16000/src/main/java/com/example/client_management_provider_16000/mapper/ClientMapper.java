package com.example.client_management_provider_16000.mapper;

import com.example.client_management_provider_16000.dto.QueryClient;
import com.example.client_management_provider_16000.dto.QueryClientPara;
import com.example.client_management_provider_16000.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abigail
 * @since 2021-07-13
 */
@Repository("ClientMapper")
public interface ClientMapper extends BaseMapper<Client> {
    List<QueryClient> queryClient(QueryClientPara queryClientPara);
//    List<>
}
