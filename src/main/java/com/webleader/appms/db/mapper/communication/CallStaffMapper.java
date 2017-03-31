package com.webleader.appms.db.mapper.communication;

import com.webleader.appms.bean.communication.CallStaff;

public interface CallStaffMapper {
    int deleteByPrimaryKey(String callStaffId);

    int insert(CallStaff record);

    int insertSelective(CallStaff record);

    CallStaff selectByPrimaryKey(String callStaffId);

    int updateByPrimaryKeySelective(CallStaff record);

    int updateByPrimaryKey(CallStaff record);
}