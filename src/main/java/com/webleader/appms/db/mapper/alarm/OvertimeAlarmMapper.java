package com.webleader.appms.db.mapper.alarm;

import com.webleader.appms.bean.alarm.OvertimeAlarm;

public interface OvertimeAlarmMapper {
    int deleteByPrimaryKey(String overtimeId);

    int insert(OvertimeAlarm record);

    int insertSelective(OvertimeAlarm record);

    OvertimeAlarm selectByPrimaryKey(String overtimeId);

    int updateByPrimaryKeySelective(OvertimeAlarm record);

    int updateByPrimaryKey(OvertimeAlarm record);
}