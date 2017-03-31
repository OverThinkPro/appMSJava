package com.webleader.appms.bean.positioning;

import java.util.Date;

/**
 * @className PastDoc
 * @description 员工历史轨迹信息
 * @author ding
 * @date 2017年3月31日 下午3:23:23
 * @version 1.0.0
 */
public class PastDoc {
	private String staffInfoHisId;// 员工历史信息ID

	private String readerId;// 分站ID

	private String readerDir;// 分站位置

	private Double readerDis;// 分站距离

	private String cardId;// 分站ID

	private Date daqDate;//

	private Object geoPoint;// 员工坐标

	private String staffId;// 员工ID

	private String staffName;// 员工姓名

	private String unitId;// 不萌ID

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

	@Override
	public String toString() {
		return "PastDoc [staffInfoHisId=" + staffInfoHisId + ", readerId=" + readerId + ", readerDir=" + readerDir
				+ ", readerDis=" + readerDis + ", cardId=" + cardId + ", daqDate=" + daqDate + ", geoPoint=" + geoPoint
				+ ", staffId=" + staffId + ", staffName=" + staffName + ", unitId=" + unitId + "]";
	}

}