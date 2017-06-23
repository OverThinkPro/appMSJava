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
	 * @description 组合条件分页查询超时报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<OvertimeAlarm> listOvertimeByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计符合条件的超时报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countOvertimeByConditon(Map<Object,Object> condition) throws SQLException;
    
	 
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/
	
	/** 
	 * @description 查询实时表中有的，但限制区域表中没有的员工，需要查询这些员工是否超时
	 * @param condition
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getRealtimeOvertimeInDB(Map<Object, Object> condition) throws SQLException;

	/** 
	 * @description 查询得到数据库中，存在的超时报警，但员工以及离开的记录
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getUnovertimeInfoInDB() throws SQLException;
	
	/** 
	 * @description 在超时报警表中添加一条记录 
	 * @param overtimeAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int insertOvertimeAlarm(Map<Object, Object> overtimeAlarm) throws SQLException;
}

	
