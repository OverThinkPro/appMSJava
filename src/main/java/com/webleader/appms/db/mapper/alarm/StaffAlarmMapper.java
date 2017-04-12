package com.webleader.appms.db.mapper.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.alarm.StaffAlarm;

/**
 * @className StaffAlarmMapper
 * @description 数据库关于StaffAlarm的接口
 * @author HaoShaSha
 * @date 2017年4月12日 下午10:45:21
 * @version 1.0.0
 */
public interface StaffAlarmMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/

	/** 
	 * @description 组合条件分页查询呼叫报警信息(警报处理状态，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<StaffAlarm> listStaffAlarmByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计符合条件的呼叫报警信息数量(警报处理状态，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countStaffAlarmByConditon(Map<Object,Object> condition) throws SQLException;
    
	 
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/

}

	
