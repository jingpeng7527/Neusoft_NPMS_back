package com.macro.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.cloud.domain.User;
import com.macro.cloud.mapper.UserMapper;
import com.macro.cloud.service.IUserService;
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
public class UserServiceIm extends ServiceImpl<UserMapper, User> implements IUserService {

}
