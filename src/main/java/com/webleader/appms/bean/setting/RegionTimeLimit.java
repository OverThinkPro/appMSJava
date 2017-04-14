package com.webleader.appms.bean.setting;

import java.util.Date;

/**
 * @className RegionTimeLimit
 * @description 记录每个区域各个工种应到岗时间，依据此表进行超时报警判断（暂时不做）
 * @author ding
 * @date 2017年3月31日 下午3:30:07
 * @version 1.0.0
 */
/**
 * @className RegionTimeLimit
 * @description 添加了一些冗余的字段，方便接受数据库的数据。
 * @author HaoShaSha
 * @date 2017年4月14日 下午5:37:47
 * @version 1.0.0
 */
public class RegionTimeLimit {
	private String regionTimeLimtId;// 区域时间限制ID

	private Date dutyTime;// 工作时间

	private String regionId;// 区域ID
	
	private String regionName;//区域名称

	private String jobId;// 工种ID
	
	private String jobName; //工种名称

	public String getRegionTimeLimtId() {
		return regionTimeLimtId;
	}

	public void setRegionTimeLimtId(String regionTimeLimtId) {
		this.regionTimeLimtId = regionTimeLimtId == null ? null : regionTimeLimtId.trim();
	}

	public Date getDutyTime() {
		return dutyTime;
	}

	public void setDutyTime(Date dutyTime) {
		this.dutyTime = dutyTime;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId == null ? null : regionId.trim();
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId == null ? null : jobId.trim();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "RegionTimeLimit [regionTimeLimtId=" + regionTimeLimtId
				+ ", dutyTime=" + dutyTime + ", regionId=" + regionId
				+ ", regionName=" + regionName + ", jobId=" + jobId
				+ ", jobName=" + jobName + "]";
	}
	
}