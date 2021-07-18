package com.example.client_management_provider_16000.mapper;

import com.example.client_management_provider_16000.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abigail
 * @since 2021-07-16
 */
@Repository("UserMapper")
public interface UserMapper extends BaseMapper<User> {

}
