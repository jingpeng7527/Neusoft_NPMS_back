package com.neusoft.npms.dto;

import java.time.LocalDate;

public class SalesLogQueryCondition {
    private String userid;
    private LocalDate startTime;
    private LocalDate endTime;

    public SalesLogQueryCondition(String userid, LocalDate startTime, LocalDate endTime) {
        this.userid = userid;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SalesLogQueryCondition{" +
                "userid='" + userid + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
