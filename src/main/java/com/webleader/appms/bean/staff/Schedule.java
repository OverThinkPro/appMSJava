package com.webleader.appms.bean.staff;

import java.sql.Time;
import java.util.List;

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

	private Time startTime; // 班次开始时间

	private Time endTime;// 班次结束时间
	
	private String upDutyId; //上级班次Id
	
	private String isUse; //是否启用
	
	private String shiftCircle; //倒班周期
	
	private String shiftOrder; //倒班顺序
	
	private Time overtimeValue; //超时时长
	
	private Time mostTimeValue; //井下最大时长
	
	private List<Schedule> children; //下级班次

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getUpDutyId() {
		return upDutyId;
	}

	public void setUpDutyId(String upDutyId) {
		this.upDutyId = upDutyId;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getShiftCircle() {
		return shiftCircle;
	}

	public void setShiftCircle(String shiftCircle) {
		this.shiftCircle = shiftCircle;
	}

	public String getShiftOrder() {
		return shiftOrder;
	}

	public void setShiftOrder(String shiftOrder) {
		this.shiftOrder = shiftOrder;
	}

	public Time getOvertimeValue() {
		return overtimeValue;
	}

	public void setOvertimeValue(Time overtimeValue) {
		this.overtimeValue = overtimeValue;
	}

	public Time getMostTimeValue() {
		return mostTimeValue;
	}

	public void setMostTimeValue(Time mostTimeValue) {
		this.mostTimeValue = mostTimeValue;
	}

	public List<Schedule> getChildren() {
		return children;
	}

	public void setChildren(List<Schedule> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Schedule [dutyId=" + dutyId + ", dutyName=" + dutyName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", upDutyId=" + upDutyId + ", isUse=" + isUse + ", shiftCircle=" + shiftCircle
				+ ", shiftOrder=" + shiftOrder + ", overtimeValue=" + overtimeValue + ", mostTimeValue=" + mostTimeValue
				+ ", children=" + children + "]";
	}

}