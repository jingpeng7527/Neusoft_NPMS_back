package com.example.client_management_provider_16000.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.client_management_provider_16000.entity.ClientTransferLog;

import java.time.LocalDateTime;

public class TransferLogWithChance {
    private String exportDeptName;
    private String exportUserName;
    private String importDeptName;
    private String importUserName;

    private String clientNum;

    private String clientName;

    private LocalDateTime transferTime;

    private String chanceNum;

    private String chanceName;

//    public TransferLogWithChance(ClientTransferLog clientTransferLog,String clientNum,String clientName, String chanceName) {
//        this.exportDeptName = clientTransferLog.getExportDeptId();
//        this.exportUserName = clientTransferLog.getExportUserId();
//        this.importDeptName = clientTransferLog.getImportDeptId();
//        this.importUserName = clientTransferLog.getImportUserId();
//        this.clientName = clientName;
//        this.transferTime = clientTransferLog.getTransferTime();
//        this.chanceNum = clientTransferLog.getChanceNum();
//        this.chanceName = chanceName;
//    }

    public TransferLogWithChance() {
    }

    @Override
    public String toString() {
        return "TransferLogWithChance{" +
                "exportDeptName='" + exportDeptName + '\'' +
                ", exportUserName='" + exportUserName + '\'' +
                ", importDeptName='" + importDeptName + '\'' +
                ", importUserName='" + importUserName + '\'' +
                ", clientNum='" + clientNum + '\'' +
                ", clientName='" + clientName + '\'' +
                ", transferTime=" + transferTime +
                ", chanceNum='" + chanceNum + '\'' +
                ", chanceName='" + chanceName + '\'' +
                '}';
    }

    public String getExportDeptName() {
        return exportDeptName;
    }

    public void setExportDeptName(String exportDeptName) {
        this.exportDeptName = exportDeptName;
    }

    public String getExportUserName() {
        return exportUserName;
    }

    public void setExportUserName(String exportUserName) {
        this.exportUserName = exportUserName;
    }

    public String getImportDeptName() {
        return importDeptName;
    }

    public void setImportDeptName(String importDeptName) {
        this.importDeptName = importDeptName;
    }

    public String getImportUserName() {
        return importUserName;
    }

    public void setImportUserName(String importUserName) {
        this.importUserName = importUserName;
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

    public LocalDateTime getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(LocalDateTime transferTime) {
        this.transferTime = transferTime;
    }

    public String getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(String chanceNum) {
        this.chanceNum = chanceNum;
    }

    public String getChanceName() {
        return chanceName;
    }

    public void setChanceName(String chanceName) {
        this.chanceName = chanceName;
    }
}
