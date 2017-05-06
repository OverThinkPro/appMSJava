package com.webleader.appms.db.service.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.TBLog;

/**
 * @className TBLogService
 * @description 日志
 * @author HaoShaSha
 * @date 2017年5月3日 上午9:38:00
 * @version 1.0.0
 */
public interface TBLogService {
	
	
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
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;

	/** 
	 * @description 添加日志
	 * @param tbLog
	 * @return
	 * @throws SQLException 
	 */
	public int insert(TBLog tbLog) throws SQLException;

}
