package com.webleader.appms.db.service.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
}
