package com.example.client_management_provider_16000.dto;

import com.example.client_management_provider_16000.entity.ClientRelate;

public class SaveClientRelate {
    private Integer id;
    private Integer clientCurrentId;
    private Integer clientRelateId;
    private Integer clientRelateTypeId;
    private String clientRelateName;
    private String clientRelateTypeName;


//    public SaveClientRelate(ClientRelate clientRelate) {
//        this.clientCurrentId = clientRelate.getClientCurrentId();
//        this.clientRelateId = clientRelate.getClientRelateId();
//        this.clientRelateTypeId = clientRelate.getClientRelateTypeId();
//    }


    @Override
    public String toString() {
        return "SaveClientRelate{" +
                "id=" + id +
                ", clientCurrentId=" + clientCurrentId +
                ", clientRelateId=" + clientRelateId +
                ", clientRelateTypeId=" + clientRelateTypeId +
                ", clientRelateName='" + clientRelateName + '\'' +
                ", clientRelateTypeName='" + clientRelateTypeName + '\'' +
                '}';
    }

    public String getClientRelateTypeName() {
        return clientRelateTypeName;
    }

    public void setClientRelateTypeName(String clientRelateTypeName) {
        this.clientRelateTypeName = clientRelateTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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