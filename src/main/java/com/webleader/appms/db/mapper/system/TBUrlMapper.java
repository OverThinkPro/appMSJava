package com.webleader.appms.db.mapper.system;

import com.webleader.appms.bean.system.TBUrl;

public interface TBUrlMapper {
    int deleteByPrimaryKey(String moduleId);

    int insert(TBUrl record);

    int insertSelective(TBUrl record);

    TBUrl selectByPrimaryKey(String moduleId);

    int updateByPrimaryKeySelective(TBUrl record);

    int updateByPrimaryKey(TBUrl record);
}