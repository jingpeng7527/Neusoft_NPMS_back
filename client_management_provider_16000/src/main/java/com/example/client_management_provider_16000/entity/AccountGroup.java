package com.example.client_management_provider_16000.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author abigail
 * @since 2021-07-15
 */
public class AccountGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String accountTypeNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountTypeNum() {
        return accountTypeNum;
    }

    public void setAccountTypeNum(String accountTypeNum) {
        this.accountTypeNum = accountTypeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountGroup{" +
        "id=" + id +
        ", accountTypeNum=" + accountTypeNum +
        ", name=" + name +
        "}";
    }
}
