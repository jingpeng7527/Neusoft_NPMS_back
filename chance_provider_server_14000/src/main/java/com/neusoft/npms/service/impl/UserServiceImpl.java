package com.neusoft.npms.service.impl;

import com.neusoft.npms.entity.User;
import com.neusoft.npms.mapper.UserMapper;
import com.neusoft.npms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-07-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
