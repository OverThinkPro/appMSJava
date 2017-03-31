package com.webleader.appms.bean.alarm;

import java.util.Date;

/**
 * @className OvermanAlarm
 * @description 超时报警表
 * @author ding
 * @date 2017年3月31日 下午2:42:51
 * @version 1.0.0
 */
public class OvermanAlarm {
	private String overmanId;// 超员ID

	private String alarmId;// 警报ID

	private String regionName;// 区域名称

	private Integer reqNumber;// 应到人数

	private Integer realNumber;// 实到人数

	private Date alarmStartTime;// 报警开始时间

	private String alarmState;// 报警状态：0：新报警；1：已解除

	private Date alarmEndTime;// 报警结束时间，当报警解除后，需要修改alarmState：1以及alarmEndTime

	private String regionId;// 区域ID

	public String getOvermanId() {
		return overmanId;
	}

	public void setOvermanId(String overmanId) {
		this.overmanId = overmanId == null ? null : overmanId.trim();
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId == null ? null : alarmId.trim();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName == null ? null : regionName.trim();
	}

	public Integer getReqNumber() {
		return reqNumber;
	}

	public void setReqNumber(Integer reqNumber) {
		this.reqNumber = reqNumber;
	}

	public Integer getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(Integer realNumber) {
		this.realNumber = realNumber;
	}

	public Date getAlarmStartTime() {
		return alarmStartTime;
	}

	public void setAlarmStartTime(Date alarmStartTime) {
		this.alarmStartTime = alarmStartTime;
	}

	public String getAlarmState() {
		return alarmState;
	}

	public void setAlarmState(String alarmState) {
		this.alarmState = alarmState == null ? null : alarmState.trim();
	}

	public Date getAlarmEndTime() {
		return alarmEndTime;
	}

	public void setAlarmEndTime(Date alarmEndTime) {
		this.alarmEndTime = alarmEndTime;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId == null ? null : regionId.trim();
	}

	@Override
	public String toString() {
		return "OvermanAlarm [overmanId=" + overmanId + ", alarmId=" + alarmId + ", regionName=" + regionName
				+ ", reqNumber=" + reqNumber + ", realNumber=" + realNumber + ", alarmStartTime=" + alarmStartTime
				+ ", alarmState=" + alarmState + ", alarmEndTime=" + alarmEndTime + ", regionId=" + regionId + "]";
	}

}