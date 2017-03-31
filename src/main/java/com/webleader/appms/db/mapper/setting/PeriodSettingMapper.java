package com.webleader.appms.db.mapper.setting;

import com.webleader.appms.bean.setting.PeriodSetting;

public interface PeriodSettingMapper {
    int deleteByPrimaryKey(String periodId);

    int insert(PeriodSetting record);

    int insertSelective(PeriodSetting record);

    PeriodSetting selectByPrimaryKey(String periodId);

    int updateByPrimaryKeySelective(PeriodSetting record);

    int updateByPrimaryKey(PeriodSetting record);
}