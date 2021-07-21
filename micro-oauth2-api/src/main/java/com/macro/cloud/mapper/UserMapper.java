package com.macro.cloud.mapper;

import com.macro.cloud.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abigail
 * @since 2021-07-21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
