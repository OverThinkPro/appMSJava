package com.webleader.appms.db.mapper.positioning;

import com.webleader.appms.bean.positioning.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(String regionId);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(String regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}