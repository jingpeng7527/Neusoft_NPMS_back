package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.ChanceTypeProduct;
import com.neusoft.npms.service.IChanceTypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */

@CrossOrigin
@RestController
@RequestMapping("/npms/chance-type-product")
public class ChanceTypeProductController {
    @Autowired
    IChanceTypeProductService iChanceTypeProductService;

    @Cacheable(cacheNames = "chanceTypeProduct")
    @GetMapping("/get_chance_type_product")
    public RespBean getChanceTypeProduct(){
        System.out.println("/get_chance_type_product");
        List<ChanceTypeProduct> result = iChanceTypeProductService.list();
        return RespBean.ok(200,"获取ChanceTypeProduct",result);
    }

    @Cacheable(cacheNames = "getProductByChanceTypeNum")
    @GetMapping("/get_product_by_chance_type_num")
    public RespBean getProductByChanceTypeNum(String chance_type_num){
        System.out.println("/get_product_by_chance_type_num");
        if (chance_type_num == null || chance_type_num.equals(""))
            return RespBean.error(400,"参数为空");
        List<ChanceTypeProduct> result = iChanceTypeProductService.
                list(Wrappers.<ChanceTypeProduct>lambdaQuery().eq(ChanceTypeProduct::getChanceTypeNum,chance_type_num));
        return RespBean.ok(200,"通过chanceTpyeNum获取product",result);
    }

    @Cacheable(cacheNames = "getChanceTypeByProductNum")
    @GetMapping("/get_chance_type_by_product_num")
    public RespBean getChanceTypeByProductNum(String product_num){
        System.out.println("/get_chance_type_by_product_num");
        if (product_num == null || product_num.equals(""))
            return RespBean.error(400,"参数为空");
        List<ChanceTypeProduct> result = iChanceTypeProductService.
                list(Wrappers.<ChanceTypeProduct>lambdaQuery().eq(ChanceTypeProduct::getProductNum,product_num));
        return RespBean.ok(200,"通过productNum获取chanceType",result);
    }

}

