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
public class ChanceStage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String chanceStageNum;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceStageNum() {
        return chanceStageNum;
    }

    public void setChanceStageNum(String chanceStageNum) {
        this.chanceStageNum = chanceStageNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChanceStage{" +
        "id=" + id +
        ", chanceStageNum=" + chanceStageNum +
        ", name=" + name +
        "}";
    }
}
