package com.webleader.appms.db.mapper.setting;

import com.webleader.appms.bean.setting.PowerSupply;

public interface PowerSupplyMapper {
    int deleteByPrimaryKey(String powerSupplyId);

    int insert(PowerSupply record);

    int insertSelective(PowerSupply record);

    PowerSupply selectByPrimaryKey(String powerSupplyId);

    int updateByPrimaryKeySelective(PowerSupply record);

    int updateByPrimaryKey(PowerSupply record);
}