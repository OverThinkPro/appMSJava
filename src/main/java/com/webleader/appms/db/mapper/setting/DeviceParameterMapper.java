package com.webleader.appms.db.mapper.setting;

import java.sql.SQLException;

import com.webleader.appms.bean.setting.DeviceParameter;

/**
 * @className DeviceParameterMapper
 * @description TODO
 * @author HaoShaSha
 * @date 2017年4月15日 下午6:24:49
 * @version 1.0.0
 */
public interface DeviceParameterMapper {
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据设备参数编号查询设备参数信息
	 * @param deviceId 
	 * @return
	 * @throws SQLException 
	 */
	 public DeviceParameter selectByPrimaryKey(String deviceId) throws SQLException;

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加设备参数
	 * @param deviceParameter
	 * @return
	 * @throws SQLException 
	 */
	public int insert(DeviceParameter deviceParameter) throws SQLException;

	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据设备参数编号删除设备参数
	 * @param deviceId
	 * @return
	 * @throws SQLException 
	 */
	 public int deleteByPrimaryKey(String deviceId) throws SQLException;


	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新设备参数信息
	 * @param deviceParameter
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(DeviceParameter deviceParameter) throws SQLException;

	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
    
}

