package com.neusoft.npms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public class ChanceTypeProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String chanceTypeNum;

    private String chanceTypeValue;

    private String productNum;

    private String productDescript;

    private String productId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceTypeNum() {
        return chanceTypeNum;
    }

    public void setChanceTypeNum(String chanceTypeNum) {
        this.chanceTypeNum = chanceTypeNum;
    }

    public String getChanceTypeValue() {
        return chanceTypeValue;
    }

    public void setChanceTypeValue(String chanceTypeValue) {
        this.chanceTypeValue = chanceTypeValue;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductDescript() {
        return productDescript;
    }

    public void setProductDescript(String productDescript) {
        this.productDescript = productDescript;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ChanceTypeProduct{" +
        "id=" + id +
        ", chanceTypeNum=" + chanceTypeNum +
        ", chanceTypeValue=" + chanceTypeValue +
        ", productNum=" + productNum +
        ", productDescript=" + productDescript +
        ", productId=" + productId +
        "}";
    }
}
