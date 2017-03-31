package com.webleader.appms.bean.positioning;

import java.util.Date;

public class PastDoc {
    private String staffInfoHisId;

    private String readerId;

    private String readerDir;

    private Double readerDis;

    private String cardId;

    private Date daqDate;

    private Object geoPoint;

    private String staffId;

    private String staffName;

    private String unitId;

    public String getStaffInfoHisId() {
        return staffInfoHisId;
    }

    public void setStaffInfoHisId(String staffInfoHisId) {
        this.staffInfoHisId = staffInfoHisId == null ? null : staffInfoHisId.trim();
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId == null ? null : readerId.trim();
    }

    public String getReaderDir() {
        return readerDir;
    }

    public void setReaderDir(String readerDir) {
        this.readerDir = readerDir == null ? null : readerDir.trim();
    }

    public Double getReaderDis() {
        return readerDis;
    }

    public void setReaderDis(Double readerDis) {
        this.readerDis = readerDis;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Date getDaqDate() {
        return daqDate;
    }

    public void setDaqDate(Date daqDate) {
        this.daqDate = daqDate;
    }

    public Object getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(Object geoPoint) {
        this.geoPoint = geoPoint;
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

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }
}