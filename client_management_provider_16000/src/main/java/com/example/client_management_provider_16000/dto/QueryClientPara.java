package com.example.client_management_provider_16000.dto;

public class QueryClientPara {

//    private Integer id;
    private String clientNum;
//
//    /**
//     * 必填项，唯一
//     */
    private String name;
    private Integer companyTypeId;
    private Integer deptId;
    private Integer userId;

    public QueryClientPara(String clientNum, String clientName, Integer companyTypeId, Integer deptId, Integer userId) {
        this.clientNum = clientNum;
        this.name = clientName;
        this.companyTypeId = companyTypeId;
        this.deptId = deptId;
        this.userId = userId;
    }

    public QueryClientPara() {

    }

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public String getClientName() {
        return name;
    }

    public void setClientName(String clientName) {
        this.name = clientName;
    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
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
        return "QueryClientPara{" +
                "clientNum='" + clientNum + '\'' +
                ", name='" + name + '\'' +
                ", companyTypeId=" + companyTypeId +
                ", deptId=" + deptId +
                ", userId=" + userId +
                '}';
    }
}
