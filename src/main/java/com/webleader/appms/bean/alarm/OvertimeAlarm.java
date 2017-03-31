package com.webleader.appms.bean.alarm;

import java.util.Date;

public class OvertimeAlarm {
    private String overtimeId;

    private Date arrivalTime;

    private Object arrivalLoc;

    private String staffId;

    private String alarmId;

    private String staffName;

    private String cardId;

    private String unitId;

    private String unitName;

    private String regionId;

    private String regionName;

    public String getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(String overtimeId) {
        this.overtimeId = overtimeId == null ? null : overtimeId.trim();
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Object getArrivalLoc() {
        return arrivalLoc;
    }

    public void setArrivalLoc(Object arrivalLoc) {
        this.arrivalLoc = arrivalLoc;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId == null ? null : alarmId.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
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
}