package com.example.login_server_18000.service;

import com.example.login_server_18000.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abigail
 * @since 2021-07-15
 */

public interface IUserService extends IService<User> {
    User getRole(String userName);
}
