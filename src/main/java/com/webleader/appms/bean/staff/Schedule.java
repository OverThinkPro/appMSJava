package com.webleader.appms.bean.staff;

import java.util.Date;

/**
 * @className Schedule
 * @description 下井值班表
 * @author ding
 * @date 2017年3月31日 下午3:48:36
 * @version 1.0.0
 */
public class Schedule {
	private String dutyId;// 班次ID

	private String dutyName;// 班次名称

	private Date startTime;// 班次开始时间

	private Date endTime;// 班次结束时间

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId == null ? null : dutyId.trim();
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName == null ? null : dutyName.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Schedule [dutyId=" + dutyId + ", dutyName=" + dutyName + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

}