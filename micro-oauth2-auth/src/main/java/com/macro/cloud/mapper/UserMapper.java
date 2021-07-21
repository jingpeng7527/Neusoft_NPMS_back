package com.macro.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.macro.cloud.domain.User;
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
