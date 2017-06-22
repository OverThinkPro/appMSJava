package com.webleader.appms.db.service.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.alarm.OvermanAlarm;
import com.webleader.appms.bean.alarm.OvertimeAlarm;
import com.webleader.appms.bean.alarm.SpecialRegionAlarm;
import com.webleader.appms.bean.alarm.StaffAlarm;

/**
 * @className AlarmService
 * @description 处理各种警报
 * @author ding
 * @date 2017年4月21日 上午10:28:02
 * @version 1.0.0
 */
public interface AlarmService {
	
	/** 
	 * @description 统计未被处理的各个类型的报警信息的数量
	 * @return List<Map<Object,Object>>(alarm_type_id,alarm_name,total)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> countRealAlarmType() throws SQLException;
	
	/** 
	 * @description 查询超员的区域，是否已经在报警表中存在
	 * @param condition
	 * @return
	 * @throws SQLException 
	 */
	public Map<Object, Object> getRegionOverman(Map<Object, Object> condition) throws SQLException;
	
	/** 
	 * @description 在报警信息表中，插入一条记录
	 * @param alarmInfo
	 * @return
	 * @throws SQLException 
	 */
	public int insertAlarmInfo(Map<Object, Object> alarmInfo) throws SQLException;
	
	/** 
	 * @description 添加一条超员报警
	 * @param overmanAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int insertOvermanAlarm(Map<Object, Object> overmanAlarm) throws SQLException;
	
	/** 
	 * @description 添加一条员工呼叫报警
	 * @param staffAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int insertStaffAlarm (Map<Object, Object> staffAlarm) throws SQLException;
	
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
	
	/** 
	 * @description 组合条件分页查询呼叫报警信息(警报处理状态，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return List<StaffAlarm>
	 * @throws SQLException 
	 */
	public List<StaffAlarm> listStaffAlarmByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的呼叫报警信息数量(警报处理状态，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,alarmStartTime,alarmEndTime)
	 * @return int
	 * @throws SQLException 
	 */
	public int countStaffAlarmByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 修改报警总表
	 * @param alarm
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Map<Object, Object> alarm) throws SQLException;
	
	/** 
	 * @description 修改一条超员报警
	 * @param overmanAlarm
	 * @return
	 * @throws SQLException 
	 */
	public int updateOvermanAlarm(Map<Object, Object> overmanAlarm) throws SQLException;
}
