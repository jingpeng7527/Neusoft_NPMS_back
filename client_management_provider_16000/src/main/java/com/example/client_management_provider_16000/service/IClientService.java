package com.example.client_management_provider_16000.service;

import com.example.client_management_provider_16000.dto.QueryClient;
import com.example.client_management_provider_16000.dto.QueryClientPara;
import com.example.client_management_provider_16000.entity.Client;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abigail
 * @since 2021-07-13
 */
public interface IClientService extends IService<Client> {
    List<QueryClient> queryClient(QueryClientPara queryClientPara);
    Integer updateClientUser(Integer client_id, Integer dept_id, Integer user_id);
    Integer updateClientInChanceDraft(Client client);
    Integer updateClientInChance(Client client);
    }
