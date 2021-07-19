package com.neusoft.npms.mapper;

import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.entity.ChanceTypeProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ChanceTypeProductMapper extends BaseMapper<ChanceTypeProduct> {
    List<ChanceTypeProduct> getItemsByChanceAndProduct(ChanceQueryCondition ChanceQueryCondition);
}
