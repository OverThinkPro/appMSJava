package com.webleader.appms.db.mapper.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.alarm.OvermanAlarm;

/**
 * @className OvermanAlarmMapper
 * @description 数据库关于OvermanAlarm的接口
 * @author HaoShaSha
 * @date 2017年4月12日 下午4:52:05
 * @version 1.0.0
 */
public interface OvermanAlarmMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/

	/** 
	 * @description 组合条件分页查询超员报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<OvermanAlarm> listOvermanByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计符合条件的超员报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countOvermanByConditon(Map<Object,Object> condition) throws SQLException;
    
	 
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/
	
	/** 
	 * @description 查询超员的区域，是否已经在报警表中存在
	 * @param condition
	 * @return
	 * @throws SQLException 
	 */
	public Map<Object, Object> getRegionOverman(Map<Object, Object> condition) throws SQLException;
	
	/** 
	 * @description 添加一条超员报警
	 * @param overmanAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int insertOvermanAlarm(Map<Object, Object> overmanAlarm) throws SQLException;
	
	/** 
	 * @description 修改一条超员报警
	 * @param overmanAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int updateOvermanAlarm(Map<Object, Object> overmanAlarm) throws SQLException;

}

	
