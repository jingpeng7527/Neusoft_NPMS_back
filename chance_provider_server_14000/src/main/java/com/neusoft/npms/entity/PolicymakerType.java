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
public class PolicymakerType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String policymakerNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicymakerNum() {
        return policymakerNum;
    }

    public void setPolicymakerNum(String policymakerNum) {
        this.policymakerNum = policymakerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PolicymakerType{" +
        "id=" + id +
        ", policymakerNum=" + policymakerNum +
        ", name=" + name +
        "}";
    }
}
