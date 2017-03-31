package com.webleader.appms.db.mapper.positioning;

import com.webleader.appms.bean.positioning.Card;

public interface CardMapper {
    int deleteByPrimaryKey(String cardId);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(String cardId);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}