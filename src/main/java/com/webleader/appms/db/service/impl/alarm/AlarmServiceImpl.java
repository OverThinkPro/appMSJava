package com.webleader.appms.db.service.impl.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.db.mapper.alarm.AlarmMapper;
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

	/**
	 * @description 统计未被处理的各个类型的报警信息的数量
	 * @return List<Map<Object,Object>>(alarm_type_id,alarm_name,total)
	 * @throws SQLException
	 */
	public List<Map<Object, Object>> countRealAlarmType() throws SQLException {
		List<Map<Object, Object>> realAlarmType = new Stack<Map<Object,Object>>();
		
		realAlarmType = alarmMapper.countRealAlarmType(); 
		return realAlarmType;
	}
}
