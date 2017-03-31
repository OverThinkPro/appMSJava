package com.webleader.appms.db.mapper.positioning;

import com.webleader.appms.bean.positioning.TLStaff;

public interface TLStaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(TLStaff record);

    int insertSelective(TLStaff record);

    TLStaff selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TLStaff record);

    int updateByPrimaryKey(TLStaff record);
}