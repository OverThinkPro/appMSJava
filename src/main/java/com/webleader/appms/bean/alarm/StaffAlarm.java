package com.webleader.appms.bean.alarm;

import java.util.Date;

public class StaffAlarm {
    private Date alarmTime;

    private Double readerDis;

    private String readerAntId;

    private String staffName;

    private String unitId;

    private String unitName;
    
    private String readerId;

    private String alarmId;

    private String cardId;

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId == null ? null : readerId.trim();
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId == null ? null : alarmId.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }
    
    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Double getReaderDis() {
        return readerDis;
    }

    public void setReaderDis(Double readerDis) {
        this.readerDis = readerDis;
    }

    public String getReaderAntId() {
        return readerAntId;
    }

    public void setReaderAntId(String readerAntId) {
        this.readerAntId = readerAntId == null ? null : readerAntId.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
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
}