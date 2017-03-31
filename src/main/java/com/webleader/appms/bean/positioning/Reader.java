package com.webleader.appms.bean.positioning;

import java.util.Date;

public class Reader {
    private String readerId;

    private String readerName;

    private String readerType;

    private String regionId;

    private String readerStatus;

    private Date installDate;

    private String powerSupplyMode;

    private Double batteryCapacity;

    private String readerIp;

    private Integer rfNumber;

    private Object geoPoint;

    private Object geoPointRef;

    private Double refSin;

    private Double refCos;

    private String deviceId;

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

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType == null ? null : readerType.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getReaderStatus() {
        return readerStatus;
    }

    public void setReaderStatus(String readerStatus) {
        this.readerStatus = readerStatus == null ? null : readerStatus.trim();
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getPowerSupplyMode() {
        return powerSupplyMode;
    }

    public void setPowerSupplyMode(String powerSupplyMode) {
        this.powerSupplyMode = powerSupplyMode == null ? null : powerSupplyMode.trim();
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getReaderIp() {
        return readerIp;
    }

    public void setReaderIp(String readerIp) {
        this.readerIp = readerIp == null ? null : readerIp.trim();
    }

    public Integer getRfNumber() {
        return rfNumber;
    }

    public void setRfNumber(Integer rfNumber) {
        this.rfNumber = rfNumber;
    }

    public Object getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(Object geoPoint) {
        this.geoPoint = geoPoint;
    }

    public Object getGeoPointRef() {
        return geoPointRef;
    }

    public void setGeoPointRef(Object geoPointRef) {
        this.geoPointRef = geoPointRef;
    }

    public Double getRefSin() {
        return refSin;
    }

    public void setRefSin(Double refSin) {
        this.refSin = refSin;
    }

    public Double getRefCos() {
        return refCos;
    }

    public void setRefCos(Double refCos) {
        this.refCos = refCos;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }
}