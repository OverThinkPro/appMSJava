package com.webleader.appms.db.service.setting;

import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.alarm.AlarmSetting;


/**
 * @className AlarmSettingService
 * @description 报警类型
 * @author HaoShaSha
 * @date 2017年5月3日 上午9:47:13
 * @version 1.0.0
 */
public interface AlarmSettingService {
	
	/** 
	 * @description 根据报警类型编号查询报警类型信息
	 * @param alarmSettingId 
	 * @return
	 * @throws SQLException 
	 */
	public AlarmSetting selectByPrimaryKey(String alarmSettingId) throws SQLException;
	
	/** 
	 * @description 查询所有的报警类型信息
	 * @param 
	 * @return
	 * @throws SQLException 
	 */
	public List<AlarmSetting> getAllAlarmTypes() throws SQLException;
	
	
	/** 
	 * @description 添加报警类型
	 * @param alarmSetting
	 * @return
	 * @throws SQLException 
	 */
	public int insert(AlarmSetting alarmSetting) throws SQLException;

	/** 
	 * @description 根据报警类型编号删除报警类型
	 * @param alarmSettingId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String alarmSettingId) throws SQLException;
	
	/** 
	 * @description 更新报警类型信息
	 * @param alarmSetting
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(AlarmSetting alarmSetting) throws SQLException;

}
