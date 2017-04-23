package com.webleader.appms.db.service.impl.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.alarm.StaffAlarm;
import com.webleader.appms.db.mapper.alarm.AlarmMapper;
import com.webleader.appms.db.mapper.alarm.StaffAlarmMapper;
import com.webleader.appms.db.service.alarm.AlarmService;

/**
 * @className AlarmServiceImpl
 * @description 处理各种警报
 * @author ding
 * @date 2017年4月21日 上午10:28:52
 * @version 1.0.0
 */

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {
	
	@Autowired
	private AlarmMapper alarmMapper;
	@Autowired
	private StaffAlarmMapper staffAlarmMapper;

	/**
	 * @description 统计未被处理的各个类型的报警信息的数量
	 * @return List<Map<Object,Object>>(alarm_type_id,alarm_name,total)
	 * @throws SQLException
	 */
	public List<Map<Object, Object>> countRealAlarmType() throws SQLException {
		return alarmMapper.countRealAlarmType(); 
	}
	
	/** 
	 * @description 组合条件分页查询呼叫报警信息(警报处理状态，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return List<StaffAlarm>
	 * @throws SQLException 
	 */
	public List<StaffAlarm> listStaffAlarmByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return staffAlarmMapper.listStaffAlarmByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的呼叫报警信息数量(警报处理状态，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,alarmStartTime,alarmEndTime)
	 * @return int
	 * @throws SQLException 
	 */
	public int countStaffAlarmByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return staffAlarmMapper.countStaffAlarmByConditon(condition);
	}
}
