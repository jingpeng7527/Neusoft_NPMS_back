package com.example.client_management_provider_16000.dto;

import com.example.client_management_provider_16000.entity.Client;

public class QueryClient {

    private Integer id;
    private String clientNum;
//
//    /**
//     * 必填项，唯一
//     */
    private String name;
    private Integer companyTypeId;
    private String productType;
    private Integer deptId;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer clientId) {
        this.id = clientId;
    }

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String clientName) {
        this.name = clientName;
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
                "clientId=" + id +
                ", clientNum='" + clientNum + '\'' +
                ", clientName='" + name + '\'' +
                ", companyTypeId=" + companyTypeId +
                ", productType='" + productType + '\'' +
                ", deptId=" + deptId +
                ", userId=" + userId +
                '}';
    }
}
