package com.webleader.appms.bean.system;

import java.util.Date;

/**
 * @className TBLog
 * @description 系统操作日志表
 * @author ding
 * @date 2017年3月31日 下午4:03:35
 * @version 1.0.0
 */
public class TBLog {
	private String logId;		// 日志ID

	private String userName;	// 用户名

	private String opType;		//操作类型

	private String opContent;	//操作内容

	private Date opDate;		//操作日期

	private String userId;		// 用户ID

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId == null ? null : logId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType == null ? null : opType.trim();
	}

	public String getOpContent() {
		return opContent;
	}

	public void setOpContent(String opContent) {
		this.opContent = opContent == null ? null : opContent.trim();
	}

	public Date getOpDate() {
		return opDate;
	}

	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	@Override
	public String toString() {
		return "TBLog [logId=" + logId + ", userName=" + userName + ", opType=" + opType + ", opContent=" + opContent
				+ ", opDate=" + opDate + ", userId=" + userId + "]";
	}
}