package com.webleader.appms.bean.alarm;

import java.util.Date;

public class OvermanAlarm {
    private String overmanId;

    private String alarmId;

    private String regionName;

    private Integer reqNumber;

    private Integer realNumber;

    private Date alarmStartTime;

    private String alarmState;

    private Date alarmEndTime;

    private String regionId;

    public String getOvermanId() {
        return overmanId;
    }

    public void setOvermanId(String overmanId) {
        this.overmanId = overmanId == null ? null : overmanId.trim();
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId == null ? null : alarmId.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Integer getReqNumber() {
        return reqNumber;
    }

    public void setReqNumber(Integer reqNumber) {
        this.reqNumber = reqNumber;
    }

    public Integer getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(Integer realNumber) {
        this.realNumber = realNumber;
    }

    public Date getAlarmStartTime() {
        return alarmStartTime;
    }

    public void setAlarmStartTime(Date alarmStartTime) {
        this.alarmStartTime = alarmStartTime;
    }

    public String getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState == null ? null : alarmState.trim();
    }

    public Date getAlarmEndTime() {
        return alarmEndTime;
    }

    public void setAlarmEndTime(Date alarmEndTime) {
        this.alarmEndTime = alarmEndTime;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }
}