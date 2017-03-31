package com.webleader.appms.bean.alarm;

public class AlarmSetting {
    private String alarmTypeId;

    private String alarmName;

    private Boolean alarmInUse;

    private String alarmFile;

    private String remark;

    public String getAlarmTypeId() {
        return alarmTypeId;
    }

    public void setAlarmTypeId(String alarmTypeId) {
        this.alarmTypeId = alarmTypeId == null ? null : alarmTypeId.trim();
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName == null ? null : alarmName.trim();
    }

    public Boolean getAlarmInUse() {
        return alarmInUse;
    }

    public void setAlarmInUse(Boolean alarmInUse) {
        this.alarmInUse = alarmInUse;
    }

    public String getAlarmFile() {
        return alarmFile;
    }

    public void setAlarmFile(String alarmFile) {
        this.alarmFile = alarmFile == null ? null : alarmFile.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}