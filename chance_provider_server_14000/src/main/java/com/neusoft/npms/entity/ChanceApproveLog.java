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
 * @since 2021-07-19
 */
public class ChanceApproveLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 处理意见 外键
     */
    private Integer opinionTypeId;

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

    /**
     * 流程名称
     */
    private String name;

    /**
     * 审批状态
     */
    private String chanceApproveState;

    public String getChanceApproveState() {
        return chanceApproveState;
    }

    public void setChanceApproveState(String chanceApproveState) {
        this.chanceApproveState = chanceApproveState;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChanceApproveLog{" +
        "id=" + id +
        ", opinionTypeId=" + opinionTypeId +
        ", content=" + content +
        ", chanceNum=" + chanceNum +
        ", approveTime=" + approveTime +
        ", userId=" + userId +
        ", name=" + name +
        "}";
    }
}
