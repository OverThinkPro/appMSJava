package com.webleader.appms.db.mapper.setting;

import java.util.List;

import com.webleader.appms.bean.setting.Coalmine;

public interface CoalmineMapper {
	
    int deleteByPrimaryKey(String coalmineId);

    int insert(Coalmine record);

    int insertSelective(Coalmine record);

    Coalmine selectByPrimaryKey(String coalmineId);

    int updateByPrimaryKeySelective(Coalmine record);

    int updateByPrimaryKey(Coalmine record);
    
    List<Coalmine> getCoalmineList();
}