package com.neusoft.npms.dto;

import com.neusoft.npms.entity.SubChanceDraft;
import com.neusoft.npms.service.IChanceStatusService;
import com.neusoft.npms.service.IChanceTypeProductService;
import com.neusoft.npms.service.IDeptService;

import java.io.Serializable;

public class ReturnSubChance implements Serializable {

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

    private String chanceTypeNum;
    private String chanceTypeValue;
    private String productNum;
    private String deptName;
    private String chanceStatusName;

    public ReturnSubChance() {
    }

    public ReturnSubChance(SubChanceDraft subChanceDraft, IChanceTypeProductService iChanceTypeProductService, IDeptService iDeptService
    , IChanceStatusService iChanceStatusService) {
        this.id = subChanceDraft.getId();
        this.subChanceNum= subChanceDraft.getSubChanceNum();
        this.chanceNum = subChanceDraft.getChanceNum();
        this.name = subChanceDraft.getName();
        this.chanceTypeProductId = subChanceDraft.getChanceTypeProductId();
        this.deptId = subChanceDraft.getDeptId();
        this.moneyAmount = subChanceDraft.getMoneyAmount();
        this.subChanceStatusId = subChanceDraft.getSubChanceStatusId();
        this.currency = subChanceDraft.getCurrency();

        this.chanceTypeNum = iChanceTypeProductService.getById(subChanceDraft.getChanceTypeProductId()).getChanceTypeNum();
        this.chanceTypeValue = iChanceTypeProductService.getById(subChanceDraft.getChanceTypeProductId()).getChanceTypeValue();
        this.productNum = iChanceTypeProductService.getById(subChanceDraft.getChanceTypeProductId()).getProductNum();
        this.deptName = iDeptService.getById(subChanceDraft.getDeptId()).getName();
        this.chanceStatusName = iChanceStatusService.getById(subChanceDraft.getSubChanceStatusId()).getName();
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

    public String getChanceTypeNum() {
        return chanceTypeNum;
    }

    public void setChanceTypeNum(String chanceTypeNum) {
        this.chanceTypeNum = chanceTypeNum;
    }

    public String getChanceTypeValue() {
        return chanceTypeValue;
    }

    public void setChanceTypeValue(String chanceTypeValue) {
        this.chanceTypeValue = chanceTypeValue;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getChanceStatusName() {
        return chanceStatusName;
    }

    public void setChanceStatusName(String chanceStatusName) {
        this.chanceStatusName = chanceStatusName;
    }

    @Override
    public String toString() {
        return "ReturnSubChance{" +
                "id=" + id +
                ", subChanceNum='" + subChanceNum + '\'' +
                ", chanceNum='" + chanceNum + '\'' +
                ", name='" + name + '\'' +
                ", chanceTypeProductId=" + chanceTypeProductId +
                ", deptId=" + deptId +
                ", moneyAmount=" + moneyAmount +
                ", subChanceStatusId=" + subChanceStatusId +
                ", currency='" + currency + '\'' +
                ", chanceTypeNum='" + chanceTypeNum + '\'' +
                ", chanceTypeValue='" + chanceTypeValue + '\'' +
                ", productNum='" + productNum + '\'' +
                ", deptName='" + deptName + '\'' +
                ", chanceStatusName='" + chanceStatusName + '\'' +
                '}';
    }
}
