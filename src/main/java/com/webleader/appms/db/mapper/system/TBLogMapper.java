package com.webleader.appms.db.mapper.system;

import com.webleader.appms.bean.system.TBLog;

public interface TBLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(TBLog record);

    int insertSelective(TBLog record);

    TBLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(TBLog record);

    int updateByPrimaryKey(TBLog record);
}