package com.neusoft.npms.dto;

import com.neusoft.npms.entity.Policymaker;
import com.neusoft.npms.service.IEffectLevelService;
import com.neusoft.npms.service.IPolicymakerService;
import com.neusoft.npms.service.IRecognitionLevelService;

public class ReturnPolicyMaker {

    private Integer id;

    private String name;

    private String dept;

    private String position;

    private String tel;

    /**
     * 购买决策人 外键
     */
    private Integer policymakerTypeId;
    private String policymakerTypeName;

    /**
     * 影响程度 外键
     */
    private Integer effectLevelId;
    private String effectLevelName;

    /**
     * 认可程度 外键
     */
    private Integer recognitionLevelId;
    private String recognitionLevelName;

    /**
     * 外键 机会编号
     */
    private Integer chanceNum;

    public ReturnPolicyMaker(Policymaker policymaker, IPolicymakerService iPolicymakerService,
                             IEffectLevelService iEffectLevelService, IRecognitionLevelService iRecognitionLevelService) {
        this.id = policymaker.getId();
        this.name = policymaker.getName();
        this.dept = policymaker.getDept();
        this.position = policymaker.getPosition();
        this.tel = policymaker.getTel();
        this.policymakerTypeId = policymaker.getPolicymakerTypeId();
        this.policymakerTypeName = iPolicymakerService.getById(policymaker.getPolicymakerTypeId()).getName();
        this.effectLevelId = policymaker.getEffectLevelId();
        this.effectLevelName = iEffectLevelService.getById(policymaker.getEffectLevelId()).getName();
        this.recognitionLevelId = policymaker.getRecognitionLevelId();
        this.recognitionLevelName = iRecognitionLevelService.getById(policymaker.getRecognitionLevelId()).getName();
        this.chanceNum = policymaker.getChanceNum();
    }

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

    public String getPolicymakerTypeName() {
        return policymakerTypeName;
    }

    public void setPolicymakerTypeName(String policymakerTypeName) {
        this.policymakerTypeName = policymakerTypeName;
    }

    public Integer getEffectLevelId() {
        return effectLevelId;
    }

    public void setEffectLevelId(Integer effectLevelId) {
        this.effectLevelId = effectLevelId;
    }

    public String getEffectLevelName() {
        return effectLevelName;
    }

    public void setEffectLevelName(String effectLevelName) {
        this.effectLevelName = effectLevelName;
    }

    public Integer getRecognitionLevelId() {
        return recognitionLevelId;
    }

    public void setRecognitionLevelId(Integer recognitionLevelId) {
        this.recognitionLevelId = recognitionLevelId;
    }

    public String getRecognitionLevelName() {
        return recognitionLevelName;
    }

    public void setRecognitionLevelName(String recognitionLevelName) {
        this.recognitionLevelName = recognitionLevelName;
    }

    public Integer getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(Integer chanceNum) {
        this.chanceNum = chanceNum;
    }

    @Override
    public String toString() {
        return "ReturnPolicyMaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", tel='" + tel + '\'' +
                ", policymakerTypeId=" + policymakerTypeId +
                ", policymakerTypeName='" + policymakerTypeName + '\'' +
                ", effectLevelId=" + effectLevelId +
                ", effectLevelName='" + effectLevelName + '\'' +
                ", recognitionLevelId=" + recognitionLevelId +
                ", recognitionLevelName='" + recognitionLevelName + '\'' +
                ", chanceNum=" + chanceNum +
                '}';
    }
}
