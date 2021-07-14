//package com.example.client_management_provider_16000.dto;
//
//import com.example.client_management_provider_16000.entity.Client;
//
//import java.time.LocalDateTime;
//import java.io.Serializable;
//
//
//public class ClientQuery implements Serializable {
//    public ClientQuery(Client client) {
//        this.id = client.getId();
//        this.clientNum = client.getClientNum();
//        this.name = client.getName();
//        this.taxpayerCode = client.getTaxpayerCode();
//        this.country = client.getCountry();
//        this.accountGroupId = client.getAccountGroupId();
//        this.province = client.getProvince();
//        this.address = client.getAddress();
//        this.postcode = client.getPostcode();
//        this.productType = client.getProductType();
//        this.companyTypeId = client.getCompanyTypeId();
//        this.coreSoftwareBrand = client.getCoreSoftwareBrand();
//        this.annualSalesRevenue = client.getAnnualSalesRevenue();
//        this.website = client.getWebsite();
//        this.taxTypeId = client.getTaxTypeId();
//        this.effect = client.getEffect();
//        this.isFrozen = client.getIsFrozen();
//        this.userId = client.getUserId();
//        this.userNum = client.getUserNum();
//        this.createTime = client.getCreateTime();
//        this.deptName = client.getName();
//        this.userName = client.getName();
//    }
//
//    private Integer id;
//
//    /**
//     * 8开头+5个数字的编号
//     */
//    private String clientNum;
//
//    /**
//     * 必填项，唯一
//     */
//    private String name;
//
//    /**
//     * only one
//     */
//    private String taxpayerCode;
//
//    private String country;
//
//    /**
//     * 账号分配组外键
//     */
//    private Integer accountGroupId;
//
//    private String province;
//
//    private String address;
//
//    private String postcode;
//
//    private String productType;
//
//    /**
//     * 外键
//     */
//    private Integer companyTypeId;
//
//    private String coreSoftwareBrand;
//
//    private Double annualSalesRevenue;
//
//    private String website;
//
//    /**
//     * 外键
//     */
//    private Integer taxTypeId;
//
//    private String effect;
//
//    private Integer isFrozen;
//
//    private Integer userId;
//
//    private String userNum;
//
//    private LocalDateTime createTime;
//
//
//    private String deptName;
//    private String userName;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getClientNum() {
//        return clientNum;
//    }
//
//    public void setClientNum(String clientNum) {
//        this.clientNum = clientNum;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTaxpayerCode() {
//        return taxpayerCode;
//    }
//
//    public void setTaxpayerCode(String taxpayerCode) {
//        this.taxpayerCode = taxpayerCode;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public Integer getAccountGroupId() {
//        return accountGroupId;
//    }
//
//    public void setAccountGroupId(Integer accountGroupId) {
//        this.accountGroupId = accountGroupId;
//    }
//
//    public String getProvince() {
//        return province;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPostcode() {
//        return postcode;
//    }
//
//    public void setPostcode(String postcode) {
//        this.postcode = postcode;
//    }
//
//    public String getProductType() {
//        return productType;
//    }
//
//    public void setProductType(String productType) {
//        this.productType = productType;
//    }
//
//    public Integer getCompanyTypeId() {
//        return companyTypeId;
//    }
//
//    public void setCompanyTypeId(Integer companyTypeId) {
//        this.companyTypeId = companyTypeId;
//    }
//
//    public String getCoreSoftwareBrand() {
//        return coreSoftwareBrand;
//    }
//
//    public void setCoreSoftwareBrand(String coreSoftwareBrand) {
//        this.coreSoftwareBrand = coreSoftwareBrand;
//    }
//
//    public Double getAnnualSalesRevenue() {
//        return annualSalesRevenue;
//    }
//
//    public void setAnnualSalesRevenue(Double annualSalesRevenue) {
//        this.annualSalesRevenue = annualSalesRevenue;
//    }
//
//    public String getWebsite() {
//        return website;
//    }
//
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    public Integer getTaxTypeId() {
//        return taxTypeId;
//    }
//
//    public void setTaxTypeId(Integer taxTypeId) {
//        this.taxTypeId = taxTypeId;
//    }
//
//    public String getEffect() {
//        return effect;
//    }
//
//    public void setEffect(String effect) {
//        this.effect = effect;
//    }
//
//    public Integer getIsFrozen() {
//        return isFrozen;
//    }
//
//    public void setIsFrozen(Integer isFrozen) {
//        this.isFrozen = isFrozen;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getUserNum() {
//        return userNum;
//    }
//
//    public void setUserNum(String userNum) {
//        this.userNum = userNum;
//    }
//
//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }
//
//
//    public String getDeptName() {
//        return deptName;
//    }
//
//    public void setDeptName(String deptName) {
//        this.deptName = deptName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Client{" +
//                "id=" + id +
//                ", clientNum='" + clientNum + '\'' +
//                ", name='" + name + '\'' +
//                ", taxpayerCode='" + taxpayerCode + '\'' +
//                ", country='" + country + '\'' +
//                ", accountGroupId=" + accountGroupId +
//                ", province='" + province + '\'' +
//                ", address='" + address + '\'' +
//                ", postcode='" + postcode + '\'' +
//                ", productType='" + productType + '\'' +
//                ", companyTypeId=" + companyTypeId +
//                ", coreSoftwareBrand='" + coreSoftwareBrand + '\'' +
//                ", annualSalesRevenue=" + annualSalesRevenue +
//                ", website='" + website + '\'' +
//                ", taxTypeId=" + taxTypeId +
//                ", effect='" + effect + '\'' +
//                ", isFrozen=" + isFrozen +
//                ", userId=" + userId +
//                ", userNum='" + userNum + '\'' +
//                ", createTime=" + createTime +
//                ", deptName='" + deptName + '\'' +
//                ", userName='" + userName + '\'' +
//                '}';
//    }
//}
