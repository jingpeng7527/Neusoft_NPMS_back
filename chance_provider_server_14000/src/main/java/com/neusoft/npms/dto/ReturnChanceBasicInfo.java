package com.neusoft.npms.dto;

import com.neusoft.npms.entity.Chance;
import com.neusoft.npms.entity.ChanceDraft;
import com.neusoft.npms.service.*;

import java.time.LocalDate;

public class ReturnChanceBasicInfo {
/*    {
        "id": 1,
            "chanceNum": "20210001",
            "name": "nuesoft-npms",
            "clientName": "neusoft",
            "chanceSourceId": 1,
            "chanceStageId": 1,
            "presignDate": "2021-07-01",
            "old": 0,
            "deptId": 3,
            "background": "阿巴阿巴",
            "userId": 1,
            "createDate": "2021-07-01",
            "chanceStatusId": 1,
            "clientId": 1
    }*/
//
//    IChanceSourceService iChanceSourceService;
//    IChanceStageService iChanceStageService;
//    IDeptService iDeptService;
//    IUserService iUserService;
//    IChanceStatusService iChanceStatusService;

    private int id;
    private String chanceNum;
    private String name;
    private String clientName;
    private int chanceSourceId;
    private String chanceSourceName;
    private int chanceStageId;
    private String chanceStageName;
    private LocalDate presignDate;
    private boolean old;
    private int deptId;
    private String deptName;
    private String background;
    private int userId;
    private String userName;
    private LocalDate createDate;
    private int chanceStatusId;
    private int clientId;
    private String chanceStatusName;

    public ReturnChanceBasicInfo(Chance chance,IChanceSourceService iChanceSourceService,
            IChanceStageService iChanceStageService,IDeptService iDeptService,
            IUserService iUserService,IChanceStatusService iChanceStatusService) {

        this.id = chance.getId();
        this.chanceNum = chance.getChanceNum();
        this.name = chance.getName();
        this.clientName = chance.getClientName();
        if (chance.getChanceSourceId()!=null){
            this.chanceSourceId = chance.getChanceSourceId();
            this.chanceSourceName = iChanceSourceService.getById(chance.getChanceStatusId()).getName();
        }

        if (chance.getChanceStageId()!=null){
            this.chanceStageId = chance.getChanceStageId();
            this.chanceStageName = iChanceStageService.getById(chance.getChanceStageId()).getName();
        }

        if (chance.getPresignDate()!= null)
            this.presignDate = chance.getPresignDate();
        this.old = chance.isOld();
        if (chance.getDeptId()!=null){
            this.deptId = chance.getDeptId();
            this.deptName = iDeptService.getById(chance.getDeptId()).getName();
        }

        if (chance.getBackground()!=null)
            this.background = chance.getBackground();
        if (chance.getUserId()!=null){
            this.userId = chance.getUserId();
            this.userName = iUserService.getById(chance.getUserId()).getUsername();
        }
        this.createDate = chance.getCreateDate();
        this.chanceStatusId = chance.getChanceStatusId();
        this.chanceStatusName = iChanceStatusService.getById(chance.getChanceStatusId()).getName();
        if (chance.getClientId()!=null)
            this.clientId = chance.getClientId();
    }

    public ReturnChanceBasicInfo(ChanceDraft chance,IChanceSourceService iChanceSourceService,
            IChanceStageService iChanceStageService,IDeptService iDeptService,
            IUserService iUserService,IChanceStatusService iChanceStatusService) {
        this.id = chance.getId();
        this.chanceNum = chance.getChanceNum();
        this.name = chance.getName();
        this.clientName = chance.getClientName();
        if (chance.getChanceSourceId()!=null){
            this.chanceSourceId = chance.getChanceSourceId();
            System.out.println(iChanceSourceService);
            this.chanceSourceName = iChanceSourceService.getById(chance.getChanceSourceId()).getName();
        }

        if (chance.getChanceStageId()!=null){
            this.chanceStageId = chance.getChanceStageId();
            this.chanceStageName = iChanceStageService.getById(chance.getChanceStageId()).getName();
        }

        if (chance.getPresignDate()!= null)
            this.presignDate = chance.getPresignDate();
        this.old = chance.isOld();
        if (chance.getDeptId()!=null){
            this.deptId = chance.getDeptId();
            this.deptName = iDeptService.getById(chance.getDeptId()).getName();
        }

        if (chance.getBackground()!=null)
            this.background = chance.getBackground();
        if (chance.getUserId()!=null){
            this.userId = chance.getUserId();
            this.userName = iUserService.getById(chance.getUserId()).getUsername();
        }
        this.createDate = chance.getCreateDate();
        this.chanceStatusId = chance.getChanceStatusId();
        this.chanceStatusName = iChanceStatusService.getById(chance.getChanceStatusId()).getName();
        if (chance.getClientId()!=null)
            this.clientId = chance.getClientId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getChanceSourceId() {
        return chanceSourceId;
    }

    public void setChanceSourceId(int chanceSourceId) {
        this.chanceSourceId = chanceSourceId;
    }

    public String getChanceSourceName() {
        return chanceSourceName;
    }

    public void setChanceSourceName(String chanceSourceName) {
        this.chanceSourceName = chanceSourceName;
    }

    public int getChanceStageId() {
        return chanceStageId;
    }

    public void setChanceStageId(int chanceStageId) {
        this.chanceStageId = chanceStageId;
    }

    public String getChanceStageName() {
        return chanceStageName;
    }

    public void setChanceStageName(String chanceStageName) {
        this.chanceStageName = chanceStageName;
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

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getChanceStatusId() {
        return chanceStatusId;
    }

    public void setChanceStatusId(int chanceStatusId) {
        this.chanceStatusId = chanceStatusId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getChanceStatusName() {
        return chanceStatusName;
    }

    public void setChanceStatusName(String chanceStatusName) {
        this.chanceStatusName = chanceStatusName;
    }

    @Override
    public String toString() {
        return "ReturnChanceBasicInfo{" +
                "id=" + id +
                ", chanceNum='" + chanceNum + '\'' +
                ", name='" + name + '\'' +
                ", clientName='" + clientName + '\'' +
                ", chanceSourceId=" + chanceSourceId +
                ", chanceSourceName='" + chanceSourceName + '\'' +
                ", chanceStageId=" + chanceStageId +
                ", chanceStageName='" + chanceStageName + '\'' +
                ", presignDate=" + presignDate +
                ", old=" + old +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", background='" + background + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", createDate=" + createDate +
                ", chanceStatusId=" + chanceStatusId +
                ", clientId=" + clientId +
                ", chanceStatusName='" + chanceStatusName + '\'' +
                '}';
    }
}
