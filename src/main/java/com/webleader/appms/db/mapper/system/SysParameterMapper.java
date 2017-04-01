package com.webleader.appms.db.mapper.system;

import java.sql.SQLException;

import com.webleader.appms.bean.system.SysParameter;

/**
 * @className SysParameterMapper
 * @description 数据库关于SysParameter的接口
 * @author HaoShaSha
 * @date 2017年4月1日 下午3:20:14
 * @version 1.0.0
 */
public interface SysParameterMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据系统参数编号查询系统参数信息
	 * @param id 
	 * @return
	 * @throws SQLException 
	 */
	public SysParameter selectByPrimaryKey(String id) throws SQLException;
	
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加系统参数
	 * @param sysParameter
	 * @return
	 * @throws SQLException 
	 */
	public int insert(SysParameter sysParameter) throws SQLException;
	
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据系统参数编号删除系统参数
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String id) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新系统参数信息
	 * @param sysParameter
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(SysParameter sysParameter) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}