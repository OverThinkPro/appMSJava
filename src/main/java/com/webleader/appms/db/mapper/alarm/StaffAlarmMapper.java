package com.webleader.appms.db.mapper.alarm;

import com.webleader.appms.bean.alarm.StaffAlarm;

public interface StaffAlarmMapper {
    int deleteByPrimaryKey(StaffAlarm key);

    int insert(StaffAlarm record);

    int insertSelective(StaffAlarm record);

    StaffAlarm selectByPrimaryKey(StaffAlarm key);

    int updateByPrimaryKeySelective(StaffAlarm record);

    int updateByPrimaryKey(StaffAlarm record);
}