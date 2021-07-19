package com.neusoft.npms.service;

import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.entity.ChanceTypeProduct;
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
public interface IChanceTypeProductService extends IService<ChanceTypeProduct> {
    List<ChanceTypeProduct> getItemsByChanceAndProduct(ChanceQueryCondition ChanceQueryCondition);
}
