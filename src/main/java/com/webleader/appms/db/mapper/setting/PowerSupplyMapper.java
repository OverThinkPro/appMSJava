package com.webleader.appms.db.mapper.setting;

import java.sql.SQLException;

import com.webleader.appms.bean.setting.PowerSupply;

/**
 * @className PowerSupplyMapper
 * @description 数据库关于PowerSupply的接口
 * @author HaoShaSha
 * @date 2017年4月15日 下午6:24:49
 * @version 1.0.0
 */
public interface PowerSupplyMapper {
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据电源供应编号查询电源供应信息
	 * @param powerSupplyId 
	 * @return
	 * @throws SQLException 
	 */
	 public PowerSupply selectByPrimaryKey(String powerSupplyId) throws SQLException;

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加电源供应
	 * @param powerSupply
	 * @return
	 * @throws SQLException 
	 */
	public int insert(PowerSupply powerSupply) throws SQLException;

	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据电源供应编号删除电源供应
	 * @param powerSupplyId
	 * @return
	 * @throws SQLException 
	 */
	 public int deleteByPrimaryKey(String powerSupplyId) throws SQLException;


	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新电源供应信息
	 * @param powerSupply
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(PowerSupply powerSupply) throws SQLException;

	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
    
}

