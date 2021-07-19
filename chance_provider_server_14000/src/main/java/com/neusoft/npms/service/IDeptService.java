package com.neusoft.npms.service;


import com.neusoft.npms.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public interface IDeptService extends IService<Dept> {
    List<Dept> getDepartment(String UserId, String RoleId);
}
