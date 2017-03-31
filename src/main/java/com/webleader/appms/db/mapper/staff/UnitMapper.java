package com.webleader.appms.db.mapper.staff;

import com.webleader.appms.bean.staff.Unit;

public interface UnitMapper {
    int deleteByPrimaryKey(String unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(String unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}