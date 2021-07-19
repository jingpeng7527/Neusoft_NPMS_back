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
 * @since 2021-07-15
 */
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键
     */
    private String chanceNum;

    /**
     * 必填 竞争对手
     */
    private String competitor;

    /**
     * 竞争位势外键
     */
    private Integer competitivePositionId;

    /**
     * 开放或者关闭
     */
    private boolean state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(String chanceNum) {
        this.chanceNum = chanceNum;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public Integer getCompetitivePositionId() {
        return competitivePositionId;
    }

    public void setCompetitivePositionId(Integer competitivePositionId) {
        this.competitivePositionId = competitivePositionId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Competition{" +
        "id=" + id +
        ", chanceNum=" + chanceNum +
        ", competitor=" + competitor +
        ", competitivePositionId=" + competitivePositionId +
        ", state=" + state +
        "}";
    }
}
