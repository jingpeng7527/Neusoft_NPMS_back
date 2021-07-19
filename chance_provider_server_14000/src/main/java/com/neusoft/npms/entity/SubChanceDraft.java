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
public class SubChanceDraft implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 子机会编号 （审批通过之后 才会生成编号） + 流水2位 新增时不填，通过后端自动改
     */
    private String subChanceNum;

    /**
     * 外键
     */
    private String chanceNum;

    /**
     * 系统中唯一必填 文本框 客户全称+产品+项目内容
     */
    private String name;

    /**
     * 对应前端的机会类型和产品两个框框 返回id
     */
    private Integer chanceTypeProductId;

    /**
     * 外键
     */
    private Integer deptId;

    /**
     * 必填
     */
    private Double moneyAmount;

    /**
     * （外键）子机会状态，具体种类参考前面的表格
     */
    private Integer subChanceStatusId;

    /**
     * 货币
     */
    private String currency;

    public SubChanceDraft() {
    }

    public SubChanceDraft(SubChance subChance){
        this.chanceNum = subChance.getChanceNum();
        this.chanceTypeProductId = subChance.getChanceTypeProductId();
        this.subChanceNum = subChance.getSubChanceNum();
        this.deptId = subChance.getDeptId();
        this.moneyAmount = subChance.getMoneyAmount();
        this.subChanceStatusId = subChance.getSubChanceStatusId();
        this.name = subChance.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubChanceNum() {
        return subChanceNum;
    }

    public void setSubChanceNum(String subChanceNum) {
        this.subChanceNum = subChanceNum;
    }

    public String getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(String chanceNum) {
        this.chanceNum = chanceNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChanceTypeProductId() {
        return chanceTypeProductId;
    }

    public void setChanceTypeProductId(Integer chanceTypeProductId) {
        this.chanceTypeProductId = chanceTypeProductId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Integer getSubChanceStatusId() {
        return subChanceStatusId;
    }

    public void setSubChanceStatusId(Integer subChanceStatusId) {
        this.subChanceStatusId = subChanceStatusId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SubChanceDraft{" +
                "id=" + id +
                ", subChanceNum='" + subChanceNum + '\'' +
                ", chanceNum='" + chanceNum + '\'' +
                ", name='" + name + '\'' +
                ", chanceTypeProductId=" + chanceTypeProductId +
                ", deptId=" + deptId +
                ", moneyAmount=" + moneyAmount +
                ", subChanceStatusId=" + subChanceStatusId +
                ", currency='" + currency + '\'' +
                '}';
    }
}
