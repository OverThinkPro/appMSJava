package com.webleader.appms.db.mapper.alarm;

import com.webleader.appms.bean.alarm.AlarmSetting;

public interface AlarmSettingMapper {
    int deleteByPrimaryKey(String alarmTypeId);

    int insert(AlarmSetting record);

    int insertSelective(AlarmSetting record);

    AlarmSetting selectByPrimaryKey(String alarmTypeId);

    int updateByPrimaryKeySelective(AlarmSetting record);

    int updateByPrimaryKey(AlarmSetting record);
}