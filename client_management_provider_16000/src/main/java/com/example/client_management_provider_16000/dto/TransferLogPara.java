package com.example.client_management_provider_16000.dto;

public class TransferLogPara {
    private Integer exportDeptId;
    private Integer exportUserId;
    private Integer importDeptId;
    private Integer importUserId;
    private String clientName;
    private String chanceName;

    @Override
    public String toString() {
        return "TransferLogPara{" +
                "exportDeptId=" + exportDeptId +
                ", exportUserId=" + exportUserId +
                ", importDeptId=" + importDeptId +
                ", importUserId=" + importUserId +
                ", clientName='" + clientName + '\'' +
                ", chanceName='" + chanceName + '\'' +
                '}';
    }

    public TransferLogPara(Integer exportDeptId, Integer exportUserId, Integer importDeptId, Integer importUserId, String clientName, String chanceName) {
        this.exportDeptId = exportDeptId;
        this.exportUserId = exportUserId;
        this.importDeptId = importDeptId;
        this.importUserId = importUserId;
        this.clientName = clientName;
        this.chanceName = chanceName;
    }

    public TransferLogPara() {
    }

    public Integer getExportDeptId() {
        return exportDeptId;
    }

    public void setExportDeptId(Integer exportDeptId) {
        this.exportDeptId = exportDeptId;
    }

    public Integer getExportUserId() {
        return exportUserId;
    }

    public void setExportUserId(Integer exportUserId) {
        this.exportUserId = exportUserId;
    }

    public Integer getImportDeptId() {
        return importDeptId;
    }

    public void setImportDeptId(Integer importDeptId) {
        this.importDeptId = importDeptId;
    }

    public Integer getImportUserId() {
        return importUserId;
    }

    public void setImportUserId(Integer importUserId) {
        this.importUserId = importUserId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getChanceName() {
        return chanceName;
    }

    public void setChanceName(String chanceName) {
        this.chanceName = chanceName;
    }
}
