package com.neusoft.npms.service.impl;

import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.entity.ChanceTypeProduct;
import com.neusoft.npms.mapper.ChanceTypeProductMapper;
import com.neusoft.npms.service.IChanceTypeProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@Service
public class ChanceTypeProductServiceImpl extends ServiceImpl<ChanceTypeProductMapper, ChanceTypeProduct> implements IChanceTypeProductService {

    @Autowired
    ChanceTypeProductMapper mapper;

    public List<ChanceTypeProduct> getItemsByChanceAndProduct(ChanceQueryCondition ChanceQueryCondition){
        List<ChanceTypeProduct> result = mapper.getItemsByChanceAndProduct(ChanceQueryCondition);
        return result;
    }
}
