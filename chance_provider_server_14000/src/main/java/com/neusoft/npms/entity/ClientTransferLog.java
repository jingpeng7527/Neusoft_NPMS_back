package com.neusoft.npms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public class ClientTransferLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 移出方销售部门id
     */
    private Integer exportDeptId;

    /**
     * 移出方客户经理id
     */
    private Integer exportUserId;

    /**
     * 接收方销售部门id
     */
    private Integer importDeptId;

    /**
     * 接收方客户经理id
     */
    private Integer importUserId;

    private Integer clientId;

    private LocalDateTime transferTime;

    private Integer chanceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(LocalDateTime transferTime) {
        this.transferTime = transferTime;
    }

    public Integer getChanceId() {
        return chanceId;
    }

    public void setChanceId(Integer chanceId) {
        this.chanceId = chanceId;
    }

    @Override
    public String toString() {
        return "ClientTransferLog{" +
        "id=" + id +
        ", exportDeptId=" + exportDeptId +
        ", exportUserId=" + exportUserId +
        ", importDeptId=" + importDeptId +
        ", importUserId=" + importUserId +
        ", clientId=" + clientId +
        ", transferTime=" + transferTime +
        ", chanceId=" + chanceId +
        "}";
    }
}
