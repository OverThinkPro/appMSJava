package com.webleader.appms.bean.alarm;

import java.util.Date;

/**
 * @className OvertimeAlarm
 * @description 超时报警表
 * @author ding
 * @date 2017年3月31日 下午2:40:14
 * @version 1.0.0
 */
public class OvertimeAlarm {
	private String overtimeId;// 超时ID

	private Date arrivalTime;// 到达时间

	private Object arrivalLoc;// 到达位置

	private String staffId;// 员工ID

	private String alarmId;// 警报ID

	private String staffName;// 员工姓名

	private String cardId;// 定位卡ID

	private String unitId;// 部门ID

	private String unitName;// 部门名称

	private String regionId;// 区域ID

	private String regionName;// 区域名称

	public String getOvertimeId() {
		return overtimeId;
	}

	public void setOvertimeId(String overtimeId) {
		this.overtimeId = overtimeId == null ? null : overtimeId.trim();
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Object getArrivalLoc() {
		return arrivalLoc;
	}

	public void setArrivalLoc(Object arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId == null ? null : staffId.trim();
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId == null ? null : alarmId.trim();
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName == null ? null : staffName.trim();
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
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

	@Override
	public String toString() {
		return "OvertimeAlarm [overtimeId=" + overtimeId + ", arrivalTime=" + arrivalTime + ", arrivalLoc=" + arrivalLoc
				+ ", staffId=" + staffId + ", alarmId=" + alarmId + ", staffName=" + staffName + ", cardId=" + cardId
				+ ", unitId=" + unitId + ", unitName=" + unitName + ", regionId=" + regionId + ", regionName="
				+ regionName + "]";
	}

}