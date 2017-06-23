package com.webleader.appms.db.mapper.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.alarm.SpecialRegionAlarm;


/**
 * @className SpecialRegionAlarmMapper
 * @description 数据库关于SpecialRegionAlarm的接口
 * @author HaoShaSha
 * @date 2017年4月12日 下午10:43:47
 * @version 1.0.0
 */
public interface SpecialRegionAlarmMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/

	/** 
	 * @description 组合条件分页查询限制区域报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<SpecialRegionAlarm> listRegionAlarmByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计符合条件的限制区域报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countSpecialRegionAlarmByConditon(Map<Object,Object> condition) throws SQLException;
    
	 
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/
	
	/** 
	 * @description 查询报警表中未处理的，但是实时表中已经没有记录的
	 * @param condition
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getSpecialAlarmInDB () throws SQLException;
	
	/** 
	 * @description 员工在危险区域，且没有在报警表中存在
	 * @param condition
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getSpecialStaffInDB () throws SQLException;
	
	/** 
	 * @description 添加一条特殊区域报警
	 * @param specialAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int insertSpecialAlarm(Map<Object, Object> specialAlarm) throws SQLException;

}

	
