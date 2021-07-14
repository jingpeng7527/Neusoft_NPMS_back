package com.example.client_management_provider_16000.dto;

import com.example.client_management_provider_16000.entity.ClientRelate;

public class SaveClientRelate {
    private Integer clientCurrentId;
    private Integer clientRelateId;
    private String clientRelateName;
    private Integer clientRelateTypeId;

    public SaveClientRelate(ClientRelate clientRelate) {
        this.clientCurrentId = clientRelate.getClientCurrentId();
        this.clientRelateId = clientRelate.getClientRelateId();
        this.clientRelateTypeId = clientRelate.getClientRelateTypeId();
    }

    @Override
    public String toString() {
        return "SaveClientRelate{" +
                "clientCurrentId=" + clientCurrentId +
                ", clientRelateId=" + clientRelateId +
                ", clientRelateName='" + clientRelateName + '\'' +
                ", clientRelateTypeId=" + clientRelateTypeId +
                '}';
    }

    public Integer getClientCurrentId() {
        return clientCurrentId;
    }

    public void setClientCurrentId(Integer clientCurrentId) {
        this.clientCurrentId = clientCurrentId;
    }

    public Integer getClientRelateId() {
        return clientRelateId;
    }

    public void setClientRelateId(Integer clientRelateId) {
        this.clientRelateId = clientRelateId;
    }

    public String getClientRelateName() {
        return clientRelateName;
    }

    public void setClientRelateName(String clientRelateName) {
        this.clientRelateName = clientRelateName;
    }

    public Integer getClientRelateTypeId() {
        return clientRelateTypeId;
    }

    public void setClientRelateTypeId(Integer clientRelateTypeId) {
        this.clientRelateTypeId = clientRelateTypeId;
    }
}