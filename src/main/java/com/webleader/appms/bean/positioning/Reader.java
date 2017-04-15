package com.webleader.appms.bean.positioning;

import java.sql.Date;

/**
 * @className Reader
 * @description 分站基本信息，在地图标注分站时需要维护该表
 * @author ding
 * @date 2017年3月31日 下午3:17:39
 * @version 1.0.0
 */
public class Reader {
	private String readerId;// 分站ID

	private String readerName;// 分站名称

	private String readerType;// 分站类型

	private String regionId;// 区域ID

	private String readerStatus;// 分站状态

	private Date installDate;// 安装时间

	private String powerSupplyMode;// 供电方式，0：电源 1:电池

	private Double batteryCapacity;// 电池容量

	private String readerIp;// 分站IP

	private Integer rfNumber;//

	private Object geoPoint;// 分站位置

	private Object geoPointRef;// 分站参考点坐标

	private Double refSin;// 分站与参考点的sin

	private Double refCos;// 分站与参考点的cos

	private String deviceId;// 设备ID

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

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", readerName=" + readerName + ", readerType=" + readerType
				+ ", regionId=" + regionId + ", readerStatus=" + readerStatus + ", installDate=" + installDate
				+ ", powerSupplyMode=" + powerSupplyMode + ", batteryCapacity=" + batteryCapacity + ", readerIp="
				+ readerIp + ", rfNumber=" + rfNumber + ", geoPoint=" + geoPoint + ", geoPointRef=" + geoPointRef
				+ ", refSin=" + refSin + ", refCos=" + refCos + ", deviceId=" + deviceId + "]";
	}

}