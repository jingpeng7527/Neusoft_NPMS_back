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
public class ChanceDraft implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 机会编号，审批通过之后才会生成编号
     */
    private String chanceNum;

    /**
     * 机会名词，必填，唯一
     */
    private String name;

    /**
     * 下拉框
     */
    private String clientName;

    /**
     * 外键 机会来源
     */
    private Integer chanceSourceId;

    /**
     * 外键 机会阶段
     */
    private Integer chanceStageId;

    /**
     * 必填 预签时间
     */
    private LocalDate presignDate;

    /**
     * 烟草/电力老客户
     */
    private boolean old;

    /**
     * 机会归属=部门
     */
    private Integer deptId;

    /**
     * 背景说明
     */
    private String background;

    /**
     * 客户经理 和这个机会对应的客户的客户经理是同一个人
     */
    private Integer userId;

    /**
     * 提交日期
     */
    private LocalDate createDate;

    /**
     * （外键）大机会状态，状态的种类参考静态表
     */
    private Integer chanceStatusId;

    /**
     * （外键）关联机会对应的客户
     */
    private Integer clientId;

    public ChanceDraft(){}

    public ChanceDraft(Chance chance) {
        this.id = chance.getId();
        this.chanceNum = chance.getChanceNum();
        this.name = chance.getName();
        this.clientName = chance.getClientName();
        this.chanceSourceId = chance.getChanceSourceId();
        this.chanceStageId = chance.getChanceStageId();
        this.presignDate = chance.getPresignDate();
        this.old = chance.isOld();
        this.deptId = chance.getDeptId();
        this.background = chance.getBackground();
        this.userId = chance.getUserId();
        this.createDate = chance.getCreateDate();
        this.chanceStatusId = chance.getChanceStatusId();
        this.clientId = chance.getClientId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(String chanceNum) {
        this.chanceNum = chanceNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getChanceSourceId() {
        return chanceSourceId;
    }

    public void setChanceSourceId(Integer chanceSourceId) {
        this.chanceSourceId = chanceSourceId;
    }

    public Integer getChanceStageId() {
        return chanceStageId;
    }

    public void setChanceStageId(Integer chanceStageId) {
        this.chanceStageId = chanceStageId;
    }

    public LocalDate getPresignDate() {
        return presignDate;
    }

    public void setPresignDate(LocalDate presignDate) {
        this.presignDate = presignDate;
    }

    public boolean isOld() {
        return old;
    }

    public void setOld(boolean old) {
        this.old = old;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getChanceStatusId() {
        return chanceStatusId;
    }

    public void setChanceStatusId(Integer chanceStatusId) {
        this.chanceStatusId = chanceStatusId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "ChanceDraft{" +
        "id=" + id +
        ", chanceNum=" + chanceNum +
        ", name=" + name +
        ", clientName=" + clientName +
        ", chanceSourceId=" + chanceSourceId +
        ", chanceStageId=" + chanceStageId +
        ", presignDate=" + presignDate +
        ", old=" + old +
        ", deptId=" + deptId +
        ", background=" + background +
        ", userId=" + userId +
        ", createDate=" + createDate +
        ", chanceStatusId=" + chanceStatusId +
        ", clientId=" + clientId +
        "}";
    }
}
