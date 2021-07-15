package com.neusoft.npms.dto;

import java.time.LocalDate;

public class SalesLogQueryCondition {
    private String userid;
    private LocalDate startTime;
    private LocalDate endTime;
    private String week;

    public SalesLogQueryCondition(String userid, LocalDate startTime, LocalDate endTime, String week) {
        this.userid = userid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.week = week;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "SalesLogQueryCondition{" +
                "userid='" + userid + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", week='" + week + '\'' +
                '}';
    }
}
