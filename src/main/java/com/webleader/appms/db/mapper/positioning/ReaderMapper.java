package com.webleader.appms.db.mapper.positioning;

import com.webleader.appms.bean.positioning.Reader;

public interface ReaderMapper {
    int deleteByPrimaryKey(String readerId);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(String readerId);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}