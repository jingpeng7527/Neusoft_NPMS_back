package com.neusoft.npms.dto;

public class ApproveChanceDraft {
    private String userId;
    private String chanceNum;
    private String content;
    private String opinionTypeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(String chanceNum) {
        this.chanceNum = chanceNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOpinionTypeId() {
        return opinionTypeId;
    }

    public void setOpinionTypeId(String opinionTypeId) {
        this.opinionTypeId = opinionTypeId;
    }

    @Override
    public String toString() {
        return "ApproveChanceDraft{" +
                "userId='" + userId + '\'' +
                ", chanceNum='" + chanceNum + '\'' +
                ", content='" + content + '\'' +
                ", opinionTypeId='" + opinionTypeId + '\'' +
                '}';
    }
}
