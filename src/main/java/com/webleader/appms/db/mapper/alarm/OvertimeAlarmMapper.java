package com.webleader.appms.db.mapper.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.alarm.OvertimeAlarm;


/**
 * @className OvertimeAlarmMapper
 * @description 数据库关于OvertimeAlarm的接口
 * @author HaoShaSha
 * @date 2017年4月12日 下午9:34:38
 * @version 1.0.0
 */
public interface OvertimeAlarmMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/

	/** 
	 * @description 组合条件分页查询超员报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<OvertimeAlarm> listOvertimeByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计符合条件的超员报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countOvertimeByConditon(Map<Object,Object> condition) throws SQLException;
    
	 
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/

}

	
