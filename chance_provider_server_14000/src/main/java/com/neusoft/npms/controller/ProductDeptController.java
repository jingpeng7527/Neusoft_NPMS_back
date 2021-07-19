package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.ProductDept;
import com.neusoft.npms.service.IProductDeptService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/npms/product-dept")
public class ProductDeptController {

    @Autowired
    IProductDeptService iProductDeptService;

    @GetMapping("/get_dept_by_product")
    public RespBean getDeptByProduct (String product_num){
        System.out.println("/get_dept_by_product");
        System.out.println("product_num"+ product_num);
        System.out.println();

        if (product_num == null || product_num.equals("")) return RespBean.error(400,"非法参数");

        List<ProductDept> result = iProductDeptService.
                list(Wrappers.<ProductDept>lambdaQuery().eq(ProductDept::getProductNum,product_num));

        return RespBean.ok(200,"通过产品获取部门",result);

    }

}

