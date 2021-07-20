package com.neusoft.npms.dto;

import com.neusoft.npms.entity.ChanceApproveLog;
import com.neusoft.npms.service.IOpinionTypeService;
import com.neusoft.npms.service.IUserService;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReturnChanceApproveLog implements Serializable {
    private Integer id;

    /**
     * 处理意见 外键
     */
    private Integer opinionTypeId;
    private String opinion;
    /**
     * 审批意见
     */
    private String content;

    /**
     * 外键
     */
    private Integer chanceNum;

    /**
     * 审批时间
     */
    private LocalDateTime approveTime;

    /**
     * 外键
     */
    private Integer userId;
    private String userName;
    /**
     * 流程名称
     */
    private String name;

    /**
     * 审批状态
     */
    private String chanceApproveState;

    public ReturnChanceApproveLog() {
    }

    public ReturnChanceApproveLog (ChanceApproveLog chanceApproveLog, IOpinionTypeService iOpinionTypeService, IUserService iUserService) {
        this.id = chanceApproveLog.getId();
        this.opinionTypeId = chanceApproveLog.getOpinionTypeId();
        this.opinion = iOpinionTypeService.getById(chanceApproveLog.getId()).getName();
        this.content = chanceApproveLog.getContent();
        this.chanceNum = chanceApproveLog.getChanceNum();
        this.approveTime = chanceApproveLog.getApproveTime();
        this.userId = chanceApproveLog.getUserId();
        this.userName = iUserService.getById(chanceApproveLog.getId()).getUsername();
        this.name = chanceApproveLog.getName();
        this.chanceApproveState = chanceApproveLog.getChanceApproveState();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpinionTypeId() {
        return opinionTypeId;
    }

    public void setOpinionTypeId(Integer opinionTypeId) {
        this.opinionTypeId = opinionTypeId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(Integer chanceNum) {
        this.chanceNum = chanceNum;
    }

    public LocalDateTime getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(LocalDateTime approveTime) {
        this.approveTime = approveTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChanceApproveState() {
        return chanceApproveState;
    }

    public void setChanceApproveState(String chanceApproveState) {
        this.chanceApproveState = chanceApproveState;
    }

    @Override
    public String toString() {
        return "ReturnChanceApproveLog{" +
                "id=" + id +
                ", opinionTypeId=" + opinionTypeId +
                ", opinion='" + opinion + '\'' +
                ", content='" + content + '\'' +
                ", chanceNum=" + chanceNum +
                ", approveTime=" + approveTime +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", chanceApproveState='" + chanceApproveState + '\'' +
                '}';
    }
}
