package com.webleader.appms.bean.alarm;

import java.util.Date;

/**
 * @className StaffAlarm
 * @description 井下人员呼叫井上人员报警表
 * @author ding
 * @date 2017年3月31日 下午2:31:20
 * @version 1.0.0
 */
public class StaffAlarm {
	private Date alarmTime;// 报警时间

	private Double readerDis;// 离分站的距离

	private String readerAntId;// 天线编号

	private String staffName;// 员工姓名

	private String unitId;// 部门ID

	private String unitName;// 部门名称

	private String readerId;// 分站ID

	private String alarmId;// 报警ID

	private String cardId;// 定位卡ID

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId == null ? null : readerId.trim();
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId == null ? null : alarmId.trim();
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
	}

	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public Double getReaderDis() {
		return readerDis;
	}

	public void setReaderDis(Double readerDis) {
		this.readerDis = readerDis;
	}

	public String getReaderAntId() {
		return readerAntId;
	}

	public void setReaderAntId(String readerAntId) {
		this.readerAntId = readerAntId == null ? null : readerAntId.trim();
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
		return "StaffAlarm [alarmTime=" + alarmTime + ", readerDis=" + readerDis + ", readerAntId=" + readerAntId
				+ ", staffName=" + staffName + ", unitId=" + unitId + ", unitName=" + unitName + ", readerId="
				+ readerId + ", alarmId=" + alarmId + ", cardId=" + cardId + "]";
	}

}