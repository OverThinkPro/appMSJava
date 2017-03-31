package com.webleader.appms.bean.staff;

/**
 * @className JobType
 * @description 工种表
 * @author ding
 * @date 2017年3月31日 下午3:46:59
 * @version 1.0.0
 */
public class JobType {
	private String jobId;// 工种ID

	private String jobName;// 工种名称

	private String jobCode;// 工种编号

	private String jobIconUrl;// 工种图例文件路径

	private String remark;// 备注

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId == null ? null : jobId.trim();
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode == null ? null : jobCode.trim();
	}

	public String getJobIconUrl() {
		return jobIconUrl;
	}

	public void setJobIconUrl(String jobIconUrl) {
		this.jobIconUrl = jobIconUrl == null ? null : jobIconUrl.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "JobType [jobId=" + jobId + ", jobName=" + jobName + ", jobCode=" + jobCode + ", jobIconUrl="
				+ jobIconUrl + ", remark=" + remark + "]";
	}

}