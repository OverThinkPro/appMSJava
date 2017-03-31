package com.webleader.appms.db.mapper.setting;

import com.webleader.appms.bean.setting.RegionTimeLimit;

public interface RegionTimeLimitMapper {
    int deleteByPrimaryKey(String regionTimeLimtId);

    int insert(RegionTimeLimit record);

    int insertSelective(RegionTimeLimit record);

    RegionTimeLimit selectByPrimaryKey(String regionTimeLimtId);

    int updateByPrimaryKeySelective(RegionTimeLimit record);

    int updateByPrimaryKey(RegionTimeLimit record);
}