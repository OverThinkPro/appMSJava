package com.webleader.appms.bean.alarm;

import java.util.Date;

/**
 * @className Alarm
 * @description 报警简要信息表
 * @author ding
 * @date 2017年3月31日 下午2:48:36
 * @version 1.0.0
 */
/**
 * @className Alarm
 * @description 修改了Alarm类的属性
 * @author HaoShaSha
 * @date 2017年4月12日 下午5:24:51
 * @version 1.0.0
 */
public class Alarm {
	private String alarmId;//报警ID

	private Date alarmStartTime;//报警开始时间
	
	private Date alarmEndTime;//报警开始时间

	private String alarmInhandle;//是否处理 0:未处理；1：已处理

	private String alarmTypeId;//报警类型ID
	
	private String alarmTypeName; //报警类型名称

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId == null ? null : alarmId.trim();
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

	public Date getAlarmStartTime() {
		return alarmStartTime;
	}

	public void setAlarmStartTime(Date alarmStartTime) {
		this.alarmStartTime = alarmStartTime;
	}

	public Date getAlarmEndTime() {
		return alarmEndTime;
	}

	public void setAlarmEndTime(Date alarmEndTime) {
		this.alarmEndTime = alarmEndTime;
	}

	public String getAlarmTypeName() {
		return alarmTypeName;
	}

	public void setAlarmTypeName(String alarmTypeName) {
		this.alarmTypeName = alarmTypeName;
	}
	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", alarmStartTime="
				+ alarmStartTime + ", alarmEndTime=" + alarmEndTime
				+ ", alarmInhandle=" + alarmInhandle + ", alarmTypeId="
				+ alarmTypeId + ", alarmTypeName=" + alarmTypeName + "]";
	}
}