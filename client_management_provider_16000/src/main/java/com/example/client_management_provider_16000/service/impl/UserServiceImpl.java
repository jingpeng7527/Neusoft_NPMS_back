package com.example.client_management_provider_16000.service.impl;

import com.example.client_management_provider_16000.entity.User;
import com.example.client_management_provider_16000.mapper.UserMapper;
import com.example.client_management_provider_16000.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
