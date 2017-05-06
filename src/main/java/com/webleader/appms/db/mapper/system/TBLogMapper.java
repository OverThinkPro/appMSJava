package com.webleader.appms.db.mapper.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.TBLog;

/**
 * @className TBLogMapper
 * @description 数据库关于TBLog的接口
 * @author HaoShaSha
 * @date 2017年4月1日 上午9:46:42
 * @version 1.0.0
 */
public interface TBLogMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据日志编号查询日志信息
	 * @param moduleId 
	 * @return
	 * @throws SQLException 
	 */
	public TBLog selectByPrimaryKey(String logId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询日志信息(用户编号，用户姓名，操作类型，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(userId,userName,opType,beginTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<TBLog> getLogByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的日志数量(用户编号，用户姓名，操作类型，开始时间，结束时间)
	 * @param pageCondition(userId,userName,opType,beginTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> pageCondition) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加日志
	 * @param tbLog
	 * @return
	 * @throws SQLException 
	 */
	public int insert(TBLog tbLog) throws SQLException;
	
	/** 
	 * @description 选择性的添加日志（同insert）
	 * @param tbLog
	 * @return
	 * @throws SQLException 
	 */
	public int insertSelective(TBLog tbLog) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据日志编号删除日志
	 * @param logId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String logId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新日志信息（应该用不到）
	 * @param tbLog
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(TBLog tbLog) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}