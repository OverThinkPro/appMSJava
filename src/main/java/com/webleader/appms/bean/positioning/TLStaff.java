package com.webleader.appms.bean.positioning;

import java.util.Date;

/**
 * @className TLStaff
 * @description 人员位置实时原始信息 分站每次采集回来的数据保存到该表中，采集回来的原始数据包括：
 *              分站编号、天线编号、卡号、卡和分站天线的距离，采集时间
 * @author ding
 * @date 2017年3月31日 下午3:06:50
 * @version 1.0.0
 */
public class TLStaff {
	private String id;// 逻辑主键

	private String staffId;// 员工ID

	private String cardId;// 定位卡ID

	private String staffName;// 员工姓名

	private String unitId;// 部门ID
	
	private String unitName;//部门名称
	
	private String jobId;	//工种编号
	
	private String jobName; //工种名称

	private String staffPost;//

	private String readerId;// 分站ID

	private String readerName;// 分站名称

	private String regionId;// 区域ID

	private String regionName;// 区域名称

	private String regionType;// 区域类型

	private Date daqTime;// 采集时间

	private Object geoPoint;// 卡在地图坐标

	private Double distance;// 卡与分站距离

	private String daqTimeType;// 采集时间类型
	// 0：正常时间； 1：进入重点区域时间； 2：出重点区域时间； 3：进入限制区域时间； 4：出限制区域时间';

	private String antId;// 天线编号

	private String flag;// 标志位

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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "TLStaff [id=" + id + ", staffId=" + staffId + ", cardId="
				+ cardId + ", staffName=" + staffName + ", unitId=" + unitId
				+ ", unitName=" + unitName + ", jobId=" + jobId + ", jobName="
				+ jobName + ", staffPost=" + staffPost + ", readerId="
				+ readerId + ", readerName=" + readerName + ", regionId="
				+ regionId + ", regionName=" + regionName + ", regionType="
				+ regionType + ", daqTime=" + daqTime + ", geoPoint="
				+ geoPoint + ", distance=" + distance + ", daqTimeType="
				+ daqTimeType + ", antId=" + antId + ", flag=" + flag + "]";
	}
	
}