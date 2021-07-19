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
public class Policymaker implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String dept;

    private String position;

    private String tel;

    /**
     * 购买决策人 外键
     */
    private Integer policymakerTypeId;

    /**
     * 影响程度 外键
     */
    private Integer effectLevelId;

    /**
     * 认可程度 外键
     */
    private Integer recognitionLevelId;

    /**
     * 外键 机会编号
     */
    private Integer chanceNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getPolicymakerTypeId() {
        return policymakerTypeId;
    }

    public void setPolicymakerTypeId(Integer policymakerTypeId) {
        this.policymakerTypeId = policymakerTypeId;
    }

    public Integer getEffectLevelId() {
        return effectLevelId;
    }

    public void setEffectLevelId(Integer effectLevelId) {
        this.effectLevelId = effectLevelId;
    }

    public Integer getRecognitionLevelId() {
        return recognitionLevelId;
    }

    public void setRecognitionLevelId(Integer recognitionLevelId) {
        this.recognitionLevelId = recognitionLevelId;
    }

    public Integer getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(Integer chanceNum) {
        this.chanceNum = chanceNum;
    }

    @Override
    public String toString() {
        return "Policymaker{" +
        "id=" + id +
        ", name=" + name +
        ", dept=" + dept +
        ", position=" + position +
        ", tel=" + tel +
        ", policymakerTypeId=" + policymakerTypeId +
        ", effectLevelId=" + effectLevelId +
        ", recognitionLevelId=" + recognitionLevelId +
        ", chanceNum=" + chanceNum +
        "}";
    }
}
