package com.webleader.appms.db.mapper.alarm;

import com.webleader.appms.bean.alarm.OvermanAlarm;

public interface OvermanAlarmMapper {
    int deleteByPrimaryKey(String overmanId);

    int insert(OvermanAlarm record);

    int insertSelective(OvermanAlarm record);

    OvermanAlarm selectByPrimaryKey(String overmanId);

    int updateByPrimaryKeySelective(OvermanAlarm record);

    int updateByPrimaryKey(OvermanAlarm record);
}