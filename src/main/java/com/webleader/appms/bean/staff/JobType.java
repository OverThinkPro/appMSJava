package com.webleader.appms.bean.staff;

public class JobType {
    private String jobId;

    private String jobName;

    private String jobCode;

    private String jobIconUrl;

    private String remark;

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
}