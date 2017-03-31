package com.webleader.appms.db.mapper.system;

import com.webleader.appms.bean.system.SysParameter;

public interface SysParameterMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysParameter record);

    int insertSelective(SysParameter record);

    SysParameter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysParameter record);

    int updateByPrimaryKey(SysParameter record);
}