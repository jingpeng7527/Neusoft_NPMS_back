package com.example.client_management_provider_16000.dto;

import com.example.client_management_provider_16000.entity.Client;

public class QueryClient {

    private Integer clientId;
    private String clientNum;
//
//    /**
//     * 必填项，唯一
//     */
    private String clientName;
    private Integer companyTypeId;
    private String productType;
    private Integer deptId;
    private Integer userId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "QueryClient{" +
                "clientId=" + clientId +
                ", clientNum='" + clientNum + '\'' +
                ", clientName='" + clientName + '\'' +
                ", companyTypeId=" + companyTypeId +
                ", productType='" + productType + '\'' +
                ", deptId=" + deptId +
                ", userId=" + userId +
                '}';
    }
}
