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
public class ClientRelateType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String clientRelateNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientRelateNum() {
        return clientRelateNum;
    }

    public void setClientRelateNum(String clientRelateNum) {
        this.clientRelateNum = clientRelateNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientRelateType{" +
        "id=" + id +
        ", clientRelateNum=" + clientRelateNum +
        ", name=" + name +
        "}";
    }
}
