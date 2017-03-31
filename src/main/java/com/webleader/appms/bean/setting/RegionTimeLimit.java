package com.webleader.appms.bean.setting;

import java.util.Date;

public class RegionTimeLimit {
    private String regionTimeLimtId;

    private Date dutyTime;

    private String regionId;

    private String jobId;

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
}