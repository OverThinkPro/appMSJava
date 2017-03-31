package com.webleader.appms.bean.alarm;

import java.util.Date;

/**
 * @className SpecialRegionAlarm
 * @description 进出入限制区域报警信息表
 * @author ding
 * @date 2017年3月31日 下午2:35:36
 * @version 1.0.0
 */
public class SpecialRegionAlarm {
	private String regionName;// 区域名称

	private Date alertTime;// 报警事件

	private String regionDir;// 区域位置

	private String alarmId;// 报警ID

	private String staffName;// 员工姓名

	private String unitId;// 部门ID

	private String unitName;// 部门名称

	private String staffId;// 员工ID

	private String cardId;// 定位卡ID

	private String regionId;// 区域ID

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

	public Date getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(Date alertTime) {
		this.alertTime = alertTime;
	}

	public String getRegionDir() {
		return regionDir;
	}

	public void setRegionDir(String regionDir) {
		this.regionDir = regionDir == null ? null : regionDir.trim();
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

	@Override
	public String toString() {
		return "SpecialRegionAlarm [regionName=" + regionName + ", alertTime=" + alertTime + ", regionDir=" + regionDir
				+ ", alarmId=" + alarmId + ", staffName=" + staffName + ", unitId=" + unitId + ", unitName=" + unitName
				+ ", staffId=" + staffId + ", cardId=" + cardId + ", regionId=" + regionId + "]";
	}

}