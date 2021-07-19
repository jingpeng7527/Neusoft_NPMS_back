package com.neusoft.npms.mapper;

import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.entity.Chance;
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
public interface ChanceMapper extends BaseMapper<Chance> {
    List<Chance> getChanceByCondition(ChanceQueryCondition chanceQueryCondition);

    List<Chance> getChanceWithChanceTypeAndProductNum(ChanceQueryCondition chanceQueryCondition);
}
