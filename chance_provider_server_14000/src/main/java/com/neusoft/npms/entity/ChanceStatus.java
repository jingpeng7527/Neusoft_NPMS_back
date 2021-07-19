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
public class ChanceStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String chanceStatusNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceStatusNum() {
        return chanceStatusNum;
    }

    public void setChanceStatusNum(String chanceStatusNum) {
        this.chanceStatusNum = chanceStatusNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChanceStatus{" +
        "id=" + id +
        ", chanceStatusNum=" + chanceStatusNum +
        ", name=" + name +
        "}";
    }
}
