package com.webleader.appms.bean.communication;

import java.util.Date;

public class Evacuation {
    private String evacuateId;

    private String userId;

    private Date callTime;

    private String regionId;

    private String regionName;

    private String userName;

    public String getEvacuateId() {
        return evacuateId;
    }

    public void setEvacuateId(String evacuateId) {
        this.evacuateId = evacuateId == null ? null : evacuateId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}