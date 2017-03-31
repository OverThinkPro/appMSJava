package com.webleader.appms.bean.positioning;

import java.util.Date;

public class TLStaff {
    private String id;

    private String staffId;

    private String cardId;

    private String staffName;

    private String unitId;

    private String staffPost;

    private String readerId;

    private String readerName;

    private String regionId;

    private String regionName;

    private String regionType;

    private Date daqTime;

    private Object geoPoint;

    private Double distance;

    private String daqTimeType;

    private String antId;

    private String flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
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

    public String getStaffPost() {
        return staffPost;
    }

    public void setStaffPost(String staffPost) {
        this.staffPost = staffPost == null ? null : staffPost.trim();
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId == null ? null : readerId.trim();
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
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

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType == null ? null : regionType.trim();
    }

    public Date getDaqTime() {
        return daqTime;
    }

    public void setDaqTime(Date daqTime) {
        this.daqTime = daqTime;
    }

    public Object getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(Object geoPoint) {
        this.geoPoint = geoPoint;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getDaqTimeType() {
        return daqTimeType;
    }

    public void setDaqTimeType(String daqTimeType) {
        this.daqTimeType = daqTimeType == null ? null : daqTimeType.trim();
    }

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId == null ? null : antId.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}