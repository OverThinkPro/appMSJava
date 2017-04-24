package com.webleader.appms.db.service.impl.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.alarm.OvermanAlarm;
import com.webleader.appms.bean.alarm.OvertimeAlarm;
import com.webleader.appms.bean.alarm.SpecialRegionAlarm;
import com.webleader.appms.bean.alarm.StaffAlarm;
import com.webleader.appms.db.mapper.alarm.AlarmMapper;
import com.webleader.appms.db.mapper.alarm.OvermanAlarmMapper;
import com.webleader.appms.db.mapper.alarm.OvertimeAlarmMapper;
import com.webleader.appms.db.mapper.alarm.SpecialRegionAlarmMapper;
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
	private OvertimeAlarmMapper overtimeAlarmMapper;
	@Autowired
	private OvermanAlarmMapper overmanAlarmMapper;
	@Autowired
	private SpecialRegionAlarmMapper specialRegionAlarmMapper;
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
	 * @description 组合条件分页查询超时报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<OvertimeAlarm> listOvertimeByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return overtimeAlarmMapper.listOvertimeByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的超时报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countOvertimeByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return 0;
		}
		return overtimeAlarmMapper.countOvertimeByConditon(condition);
	}
	
	/** 
	 * @description 组合条件分页查询超员报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<OvermanAlarm> listOvermanByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return overmanAlarmMapper.listOvermanByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的超员报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countOvermanByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return 0;
		}
		return overmanAlarmMapper.countOvermanByConditon(condition);
	}
	
	/** 
	 * @description 组合条件分页查询限制区域报警信息(警报处理状态，区域名称，警报开始时间，警报结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(alarmInhandle,regionName,alarmStartTime,alarmEndTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<SpecialRegionAlarm> listRegionAlarmByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return specialRegionAlarmMapper.listRegionAlarmByPageCondition(pageCondition);
	}

	/** 
	 * @description 统计符合条件的限制区域报警信息数量(警报处理状态，区域名称，警报开始时间，警报结束时间)
	 * @param condition(alarmInhandle,regionName,alarmStartTime,alarmEndTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countSpecialRegionAlarmByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return 0;
		}
		return specialRegionAlarmMapper.countSpecialRegionAlarmByConditon(condition);
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
