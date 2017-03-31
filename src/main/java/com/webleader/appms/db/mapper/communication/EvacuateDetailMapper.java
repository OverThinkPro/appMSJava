package com.webleader.appms.db.mapper.communication;

import com.webleader.appms.bean.communication.EvacuateDetail;

public interface EvacuateDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(EvacuateDetail record);

    int insertSelective(EvacuateDetail record);

    EvacuateDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(EvacuateDetail record);

    int updateByPrimaryKey(EvacuateDetail record);
}