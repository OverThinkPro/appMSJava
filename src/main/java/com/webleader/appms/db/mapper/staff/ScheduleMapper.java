package com.webleader.appms.db.mapper.staff;

import com.webleader.appms.bean.staff.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String dutyId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String dutyId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}