package com.webleader.appms.db.mapper.positioning;

import com.webleader.appms.bean.positioning.PastDoc;

public interface PastDocMapper {
    int deleteByPrimaryKey(String staffInfoHisId);

    int insert(PastDoc record);

    int insertSelective(PastDoc record);

    PastDoc selectByPrimaryKey(String staffInfoHisId);

    int updateByPrimaryKeySelective(PastDoc record);

    int updateByPrimaryKey(PastDoc record);
}