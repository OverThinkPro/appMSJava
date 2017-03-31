package com.webleader.appms.bean.communication;

import java.util.Date;

/**
 * @className Evacuation
 * @description 撤离呼叫表
 * @author ding
 * @date 2017年3月31日 下午2:52:42
 * @version 1.0.0
 */
public class Evacuation {
	private String evacuateId;// 撤离ID

	private String userId;// 用户ID

	private Date callTime;// 呼叫时间

	private String regionId;// 区域ID

	private String regionName;// 区域名称

	private String userName;// 用户名

	public String getEvacuateId() {
		return evacuateId;
	}

	public void setEvacuateId(String evacuateId) {
		this.evacuateId = evacuateId == null ? null : evacuateId.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId == null ? null : regionId.trim();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName == null ? null : regionName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	@Override
	public String toString() {
		return "Evacuation [evacuateId=" + evacuateId + ", userId=" + userId + ", callTime=" + callTime + ", regionId="
				+ regionId + ", regionName=" + regionName + ", userName=" + userName + "]";
	}

}