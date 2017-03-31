package com.webleader.appms.db.mapper.setting;

import com.webleader.appms.bean.setting.DeviceParameter;

public interface DeviceParameterMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceParameter record);

    int insertSelective(DeviceParameter record);

    DeviceParameter selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(DeviceParameter record);

    int updateByPrimaryKey(DeviceParameter record);
}