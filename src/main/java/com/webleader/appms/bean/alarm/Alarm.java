package com.webleader.appms.bean.alarm;

import java.util.Date;

/**
 * @className Alarm
 * @description 报警简要信息表
 * @author ding
 * @date 2017年3月31日 下午2:48:36
 * @version 1.0.0
 */
public class Alarm {
	private String alarmId;//报警ID

	private Date alarmTime;//报警时间

	private String alarmInhandle;//是否处理 0:未处理；1：已处理

	private String alarmTypeId;//报警类型ID

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId == null ? null : alarmId.trim();
	}

	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmInhandle() {
		return alarmInhandle;
	}

	public void setAlarmInhandle(String alarmInhandle) {
		this.alarmInhandle = alarmInhandle == null ? null : alarmInhandle.trim();
	}

	public String getAlarmTypeId() {
		return alarmTypeId;
	}

	public void setAlarmTypeId(String alarmTypeId) {
		this.alarmTypeId = alarmTypeId == null ? null : alarmTypeId.trim();
	}

	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", alarmTime=" + alarmTime + ", alarmInhandle=" + alarmInhandle
				+ ", alarmTypeId=" + alarmTypeId + "]";
	}

}