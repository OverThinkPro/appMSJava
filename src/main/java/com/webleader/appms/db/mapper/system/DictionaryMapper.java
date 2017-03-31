package com.webleader.appms.db.mapper.system;

import com.webleader.appms.bean.system.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(String dictionaryId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(String dictionaryId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}