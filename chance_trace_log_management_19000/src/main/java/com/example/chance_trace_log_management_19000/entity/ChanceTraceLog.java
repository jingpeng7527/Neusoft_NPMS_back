package com.example.chance_trace_log_management_19000.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author abigail
 * @since 2021-07-19
 */
public class ChanceTraceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务类型（别） 外键
     */
    @JsonProperty("business_type_id")
    private Integer businessTypeId;

    /**
     * 外键 机会
     */
    @JsonProperty("chance_num")
    private String chanceNum;

    /**
     * 我方人员
     */
    @JsonProperty("our_personnel")
    private String ourPersonnel;

    /**
     * 客户方人员
     */
    @JsonProperty("client_personnel")
    private String clientPersonnel;

    /**
     * 第三方
     */
    @JsonProperty("third_party_personnel")
    private String thirdPartyPersonnel;

    private String address;

    private String effect;

    @JsonProperty("communication_condition")
    private String communicationCondition;

    /**
     * 沟通方式
     */
    @JsonProperty("communication_type")
    private String communicationType;

    /**
     * 创建时间
     */
    @JsonProperty("create_date")
    private LocalDate createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Integer businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(String chanceNum) {
        this.chanceNum = chanceNum;
    }

    public String getOurPersonnel() {
        return ourPersonnel;
    }

    public void setOurPersonnel(String ourPersonnel) {
        this.ourPersonnel = ourPersonnel;
    }

    public String getClientPersonnel() {
        return clientPersonnel;
    }

    public void setClientPersonnel(String clientPersonnel) {
        this.clientPersonnel = clientPersonnel;
    }

    public String getThirdPartyPersonnel() {
        return thirdPartyPersonnel;
    }

    public void setThirdPartyPersonnel(String thirdPartyPersonnel) {
        this.thirdPartyPersonnel = thirdPartyPersonnel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCommunicationCondition() {
        return communicationCondition;
    }

    public void setCommunicationCondition(String communicationCondition) {
        this.communicationCondition = communicationCondition;
    }

    public String getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "ChanceTraceLog{" +
        "id=" + id +
        ", businessTypeId=" + businessTypeId +
        ", chanceNum=" + chanceNum +
        ", ourPersonnel=" + ourPersonnel +
        ", clientPersonnel=" + clientPersonnel +
        ", thirdPartyPersonnel=" + thirdPartyPersonnel +
        ", address=" + address +
        ", effect=" + effect +
        ", communicationCondition=" + communicationCondition +
        ", communicationType=" + communicationType +
        ", createDate=" + createDate +
        "}";
    }
}
