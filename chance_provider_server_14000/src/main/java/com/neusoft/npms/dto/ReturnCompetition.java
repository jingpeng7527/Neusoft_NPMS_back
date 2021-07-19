package com.neusoft.npms.dto;

import com.neusoft.npms.entity.Competition;
import com.neusoft.npms.service.ICompetitivePositionService;

public class ReturnCompetition {

//    ICompetitivePositionService iCompetitionPositionService;

    private int id;
    /**
     * 外键
     */
    private String chanceNum;

    /**
     * 必填 竞争对手
     */
    private String competitor;

    /**
     * 竞争位势外键
     */
    private Integer competitivePositionId;
    private String competitivePositionName;

    /**
     * 开放或者关闭
     */
    private boolean state;

    public ReturnCompetition(Competition competition,ICompetitivePositionService iCompetitionPositionService) {

        this.id = competition.getId();
        this.chanceNum = competition.getChanceNum();
        this.competitor = competition.getCompetitor();
        this.competitivePositionId = competition.getCompetitivePositionId();
        this.competitivePositionName = iCompetitionPositionService.getById(competition.getCompetitivePositionId()).getName();
        this.state = competition.isState();
    }

    public ReturnCompetition() {
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

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public Integer getCompetitivePositionId() {
        return competitivePositionId;
    }

    public void setCompetitivePositionId(Integer competitivePositionId) {
        this.competitivePositionId = competitivePositionId;
    }

    public String getCompetitivePositionName() {
        return competitivePositionName;
    }

    public void setCompetitivePositionName(String competitivePositionName) {
        this.competitivePositionName = competitivePositionName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ReturnCompetition{" +
                "id=" + id +
                ", chanceNum='" + chanceNum + '\'' +
                ", competitor='" + competitor + '\'' +
                ", competitivePositionId=" + competitivePositionId +
                ", competitivePositionName='" + competitivePositionName + '\'' +
                ", state=" + state +
                '}';
    }
}
