package com.webleader.appms.db.service.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
}
