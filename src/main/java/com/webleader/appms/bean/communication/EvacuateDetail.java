package com.webleader.appms.bean.communication;

import java.util.Date;

/**
 * @className EvacuateDetail
 * @description 撤离信息明细表
 * @author ding
 * @date 2017年3月31日 下午2:55:12
 * @version 1.0.0
 */
public class EvacuateDetail {
	private String detailId;// 撤离明细ID

	private String evacuateId;// 撤离ID

	private String callStatus;// 呼叫状态

	private String staffId;// 员工ID

	private String staffName;// 员工姓名

	private Date enteringTime;// 进入煤矿时间

	private String jobName;// 工种

	private String unitName;// 部门名称

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId == null ? null : detailId.trim();
	}

	public String getEvacuateId() {
		return evacuateId;
	}

	public void setEvacuateId(String evacuateId) {
		this.evacuateId = evacuateId == null ? null : evacuateId.trim();
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus == null ? null : callStatus.trim();
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

	public Date getEnteringTime() {
		return enteringTime;
	}

	public void setEnteringTime(Date enteringTime) {
		this.enteringTime = enteringTime;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName == null ? null : unitName.trim();
	}

	@Override
	public String toString() {
		return "EvacuateDetail [detailId=" + detailId + ", evacuateId=" + evacuateId + ", callStatus=" + callStatus
				+ ", staffId=" + staffId + ", staffName=" + staffName + ", enteringTime=" + enteringTime + ", jobName="
				+ jobName + ", unitName=" + unitName + "]";
	}

}