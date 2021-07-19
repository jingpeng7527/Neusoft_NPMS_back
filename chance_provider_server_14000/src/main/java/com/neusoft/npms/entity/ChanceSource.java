package com.neusoft.npms.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public class ChanceSource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String chanceSourceNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceSourceNum() {
        return chanceSourceNum;
    }

    public void setChanceSourceNum(String chanceSourceNum) {
        this.chanceSourceNum = chanceSourceNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChanceSource{" +
        "id=" + id +
        ", chanceSourceNum=" + chanceSourceNum +
        ", name=" + name +
        "}";
    }
}
