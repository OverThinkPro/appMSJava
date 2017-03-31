package com.webleader.appms.bean.staff;

import java.util.Date;

public class Staff {
    private String staffId;

    private String staffName;

    private String staffAbbr;

    private String staffBirthday;

    private String staffGender;

    private String staffPicPath;

    private String staffIdCard;

    private String staffNativePlace;

    private String staffTelephone;

    private Date staffWorkDate;

    private String unitId;

    private String jobId;

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

    public String getStaffAbbr() {
        return staffAbbr;
    }

    public void setStaffAbbr(String staffAbbr) {
        this.staffAbbr = staffAbbr == null ? null : staffAbbr.trim();
    }

    public String getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(String staffBirthday) {
        this.staffBirthday = staffBirthday == null ? null : staffBirthday.trim();
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender == null ? null : staffGender.trim();
    }

    public String getStaffPicPath() {
        return staffPicPath;
    }

    public void setStaffPicPath(String staffPicPath) {
        this.staffPicPath = staffPicPath == null ? null : staffPicPath.trim();
    }

    public String getStaffIdCard() {
        return staffIdCard;
    }

    public void setStaffIdCard(String staffIdCard) {
        this.staffIdCard = staffIdCard == null ? null : staffIdCard.trim();
    }

    public String getStaffNativePlace() {
        return staffNativePlace;
    }

    public void setStaffNativePlace(String staffNativePlace) {
        this.staffNativePlace = staffNativePlace == null ? null : staffNativePlace.trim();
    }

    public String getStaffTelephone() {
        return staffTelephone;
    }

    public void setStaffTelephone(String staffTelephone) {
        this.staffTelephone = staffTelephone == null ? null : staffTelephone.trim();
    }

    public Date getStaffWorkDate() {
        return staffWorkDate;
    }

    public void setStaffWorkDate(Date staffWorkDate) {
        this.staffWorkDate = staffWorkDate;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }
}