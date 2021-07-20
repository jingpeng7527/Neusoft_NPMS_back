package com.example.chance_trace_log_management_19000.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author abigail
 * @since 2021-07-20
 */
public class BusinessType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String bussinessTypeNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBussinessTypeNum() {
        return bussinessTypeNum;
    }

    public void setBussinessTypeNum(String bussinessTypeNum) {
        this.bussinessTypeNum = bussinessTypeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BusinessType{" +
        "id=" + id +
        ", bussinessTypeNum=" + bussinessTypeNum +
        ", name=" + name +
        "}";
    }
}
