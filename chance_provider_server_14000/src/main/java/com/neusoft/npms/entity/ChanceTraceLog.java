package com.neusoft.npms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
public class ChanceTraceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务类型（别） 外键
     */
    private Integer businessTypeId;

    /**
     * 外键 机会
     */
    private Integer chanceId;

    /**
     * 我方人员
     */
    private String ourPersonnel;

    /**
     * 客户方人员
     */
    private String clientPersonnel;

    /**
     * 第三方
     */
    private String thirdPartyPersonnel;

    private String address;

    private String effect;

    private String condition;

    /**
     * 沟通方式
     */
    private String communicationType;

    /**
     * 创建时间
     */
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

    public Integer getChanceId() {
        return chanceId;
    }

    public void setChanceId(Integer chanceId) {
        this.chanceId = chanceId;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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
        ", chanceId=" + chanceId +
        ", ourPersonnel=" + ourPersonnel +
        ", clientPersonnel=" + clientPersonnel +
        ", thirdPartyPersonnel=" + thirdPartyPersonnel +
        ", address=" + address +
        ", effect=" + effect +
        ", condition=" + condition +
        ", communicationType=" + communicationType +
        ", createDate=" + createDate +
        "}";
    }
}
