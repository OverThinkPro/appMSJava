package com.webleader.appms.db.mapper.communication;

import com.webleader.appms.bean.communication.Evacuation;

public interface EvacuationMapper {
    int deleteByPrimaryKey(String evacuateId);

    int insert(Evacuation record);

    int insertSelective(Evacuation record);

    Evacuation selectByPrimaryKey(String evacuateId);

    int updateByPrimaryKeySelective(Evacuation record);

    int updateByPrimaryKey(Evacuation record);
}