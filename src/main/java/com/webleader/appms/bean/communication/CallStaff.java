package com.webleader.appms.bean.communication;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @className CallStaff
 * @description 井上回电呼叫井下人员信息
 * @author ding
 * @date 2017年3月31日 下午2:58:18
 * @version 1.0.0
 */
public class CallStaff {
	private String callStaffId;// 井上呼叫员工ID

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date callTime;// 呼叫时间

	private String callType;// 呼叫类型

	private String userId;// 用户ID

	private String staffId;// 员工ID

	public String getCallStaffId() {
		return callStaffId;
	}

	public void setCallStaffId(String callStaffId) {
		this.callStaffId = callStaffId == null ? null : callStaffId.trim();
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType == null ? null : callType.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId == null ? null : staffId.trim();
	}

	@Override
	public String toString() {
		return "CallStaff [callStaffId=" + callStaffId + ", callTime=" + callTime + ", callType=" + callType
				+ ", userId=" + userId + ", staffId=" + staffId + "]";
	}

}