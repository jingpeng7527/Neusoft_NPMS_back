package com.neusoft.npms.mapper;

import com.neusoft.npms.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */

@Repository
public interface DeptMapper extends BaseMapper<Dept> {
}
