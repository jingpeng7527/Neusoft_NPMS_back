package com.example.login_server_18000.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.login_server_18000.entity.User;
import com.example.login_server_18000.mapper.UserMapper;
import com.example.login_server_18000.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abigail
 * @since 2021-07-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    public User getRole(String userName) {
        QueryWrapper<User> q = Wrappers.query();
        q.eq("username",userName);
        //        System.out.println(id);
        return userMapper.selectOne(q);
    }
}
