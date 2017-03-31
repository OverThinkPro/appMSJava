package com.webleader.appms.db.mapper.alarm;

import com.webleader.appms.bean.alarm.Alarm;

public interface AlarmMapper {
	
    int deleteByPrimaryKey(String alarmId);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    Alarm selectByPrimaryKey(String alarmId);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);
}