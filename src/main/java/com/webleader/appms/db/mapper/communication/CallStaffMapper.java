package com.webleader.appms.db.mapper.communication;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.communication.CallStaff;

/**
 * @className CallStaffMapper
 * @description 数据库关于CallStaff的接口
 * @author HaoShaSha
 * @date 2017年4月13日 下午9:21:10
 * @version 1.0.0
 */
public interface CallStaffMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 分页查询满足条件的回电呼叫记录(开始时间，结束时间，起始记录数，每页的记录数)
	 * @param pageCondition(startTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<CallStaff> listCallStaffByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计满足条件的回电呼叫记录(开始时间，结束时间)
	 * @param condition(startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countCallStaffByCondition(Map<Object,Object> condition) throws SQLException;
    
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/

	/** 
	 * @description 添加回电呼叫记录
	 * @param callStaff
	 * @return
	 * @throws SQLException 
	 */
	public int insert(CallStaff callStaff) throws SQLException;
	/*****************插入接口结束*******************/
   	/*****************END BY HaoShaSha***********/

}