package com.neusoft.npms.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ChanceQueryCondition implements Serializable {
/*    {
        "chanceNum":"20214325",
            "name":"一个商机",
            "deptId":"1",
            "userId":"3",#客户经理id
        "presignDateBegin":"2020-1-29",
            "presignDateEnd":"2021-1-29",
            "chanceStageId":"1",
            "chanceTypeNum":"1",
            "productNum":"SAP",
            "chanceStatusId":"1",
    }*/
    private String loginUserId;
    private String chanceNum;
    private String name;
    private String deptId;
    private String userId;
    private LocalDate presignDateBegin;
    private LocalDate presignDateEnd;
    private String chanceStageId;
    private String productNum;
    private String chanceTypeNum;
    private String chanceStatusId;

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getPresignDateBegin() {
        return presignDateBegin;
    }

    public void setPresignDateBegin(LocalDate presignDateBegin) {
        this.presignDateBegin = presignDateBegin;
    }

    public LocalDate getPresignDateEnd() {
        return presignDateEnd;
    }

    public void setPresignDateEnd(LocalDate presignDateEnd) {
        this.presignDateEnd = presignDateEnd;
    }

    public String getChanceStageId() {
        return chanceStageId;
    }

    public void setChanceStageId(String chanceStageId) {
        this.chanceStageId = chanceStageId;
    }

    public String getChanceTypeNum() {
        return chanceTypeNum;
    }

    public void setChanceTypeNum(String chanceTypeNum) {
        this.chanceTypeNum = chanceTypeNum;
    }

    public String getChanceStatusId() {
        return chanceStatusId;
    }

    public void setChanceStatusId(String chanceStatusId) {
        this.chanceStatusId = chanceStatusId;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "ChanceQueryCondition{" +
                "loginUserId='" + loginUserId + '\'' +
                ", chanceNum='" + chanceNum + '\'' +
                ", name='" + name + '\'' +
                ", deptId='" + deptId + '\'' +
                ", userId='" + userId + '\'' +
                ", presignDateBegin=" + presignDateBegin +
                ", presignDateEnd=" + presignDateEnd +
                ", chanceStageId='" + chanceStageId + '\'' +
                ", productNum='" + productNum + '\'' +
                ", chanceTypeNum='" + chanceTypeNum + '\'' +
                ", chanceStatusId='" + chanceStatusId + '\'' +
                '}';
    }
}
