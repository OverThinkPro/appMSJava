package com.webleader.appms.db.mapper.setting;

import java.sql.SQLException;

import com.webleader.appms.bean.setting.Coalmine;

/**
 * @className CoalmineMapper
 * @description 数据库关于Coalmine的接口
 * @author HaoShaSha
 * @date 2017年4月11日 下午6:22:00
 * @version 1.0.0
 */
 public interface CoalmineMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	
	/** 
	 * @description 主键coalmineId查询煤矿信息
	 * @param coalmineId
	 * @return
	 * @throws SQLException 
	 */
	 Coalmine selectByPrimaryKey(String coalmineId) throws SQLException;
	
	
	/*****************查询接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新煤矿信息
	 * @param coalmine
	 * @return
	 * @throws SQLException 
	 */
	 int updateByPrimaryKeySelective(Coalmine coalmine) throws SQLException;
	
	/*****************更新接口结束*******************/					
	/*****************END BY HaoShaSha***********/
}