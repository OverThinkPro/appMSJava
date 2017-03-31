package com.webleader.appms.db.mapper.alarm;

import com.webleader.appms.bean.alarm.SpecialRegionAlarm;

public interface SpecialRegionAlarmMapper {
    int deleteByPrimaryKey(SpecialRegionAlarm key);

    int insert(SpecialRegionAlarm record);

    int insertSelective(SpecialRegionAlarm record);

    SpecialRegionAlarm selectByPrimaryKey(SpecialRegionAlarm key);

    int updateByPrimaryKeySelective(SpecialRegionAlarm record);

    int updateByPrimaryKey(SpecialRegionAlarm record);
}