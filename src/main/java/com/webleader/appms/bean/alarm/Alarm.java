package com.webleader.appms.bean.alarm;

import java.util.Date;

public class Alarm {
    private String alarmId;

    private Date alarmTime;

    private String alarmInhandle;

    private String alarmTypeId;

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId == null ? null : alarmId.trim();
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmInhandle() {
        return alarmInhandle;
    }

    public void setAlarmInhandle(String alarmInhandle) {
        this.alarmInhandle = alarmInhandle == null ? null : alarmInhandle.trim();
    }

    public String getAlarmTypeId() {
        return alarmTypeId;
    }

    public void setAlarmTypeId(String alarmTypeId) {
        this.alarmTypeId = alarmTypeId == null ? null : alarmTypeId.trim();
    }
}