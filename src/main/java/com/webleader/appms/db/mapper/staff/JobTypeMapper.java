package com.webleader.appms.db.mapper.staff;

import com.webleader.appms.bean.staff.JobType;

public interface JobTypeMapper {
    int deleteByPrimaryKey(String jobId);

    int insert(JobType record);

    int insertSelective(JobType record);

    JobType selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(JobType record);

    int updateByPrimaryKey(JobType record);
}