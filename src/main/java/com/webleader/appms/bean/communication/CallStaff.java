package com.webleader.appms.bean.communication;

import java.util.Date;

public class CallStaff {
    private String callStaffId;

    private Date callTime;

    private String callType;

    private String userId;

    private String staffId;

    public String getCallStaffId() {
        return callStaffId;
    }

    public void setCallStaffId(String callStaffId) {
        this.callStaffId = callStaffId == null ? null : callStaffId.trim();
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
}