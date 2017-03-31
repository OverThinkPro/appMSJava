package com.webleader.appms.bean.system;

import java.util.Date;

/**
 * @className User
 * @description 用户表
 * @author ding
 * @date 2017年3月31日 下午4:00:47
 * @version 1.0.0
 */
public class User {
	private String userId;// 用户ID

	private String userName;// 用户名

	private String password;// 密码

	private String inUse;// 是否启用

	private Date createTime;// 创建时间

	private Date lastLoginTime;// 最后一次登陆时间

	private String remark;// 备注

	private String staffId;// 员工ID

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getInUse() {
		return inUse;
	}

	public void setInUse(String inUse) {
		this.inUse = inUse == null ? null : inUse.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId == null ? null : staffId.trim();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", inUse=" + inUse
				+ ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + ", remark=" + remark
				+ ", staffId=" + staffId + "]";
	}

}