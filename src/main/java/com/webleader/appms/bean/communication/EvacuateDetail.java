package com.webleader.appms.bean.communication;

import java.util.Date;

public class EvacuateDetail {
    private String detailId;

    private String evacuateId;

    private String callStatus;

    private String staffId;

    private String staffName;

    private Date enteringTime;

    private String jobName;

    private String unitName;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getEvacuateId() {
        return evacuateId;
    }

    public void setEvacuateId(String evacuateId) {
        this.evacuateId = evacuateId == null ? null : evacuateId.trim();
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus == null ? null : callStatus.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public Date getEnteringTime() {
        return enteringTime;
    }

    public void setEnteringTime(Date enteringTime) {
        this.enteringTime = enteringTime;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }
}