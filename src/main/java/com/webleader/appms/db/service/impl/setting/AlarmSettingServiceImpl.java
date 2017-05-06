package com.webleader.appms.db.service.impl.setting;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.alarm.AlarmSetting;
import com.webleader.appms.db.mapper.alarm.AlarmSettingMapper;
import com.webleader.appms.db.service.setting.AlarmSettingService;


/**
 * @className AlarmSettingServiceImpl
 * @description 报警类型服务层
 * @author HaoShaSha
 * @date 2017年5月3日 上午9:54:44
 * @version 1.0.0
 */
@Service("alarmSettingService")
public class AlarmSettingServiceImpl implements AlarmSettingService{
	
	@Autowired
	private AlarmSettingMapper alarmSettingMapper;
	
	/** 
	 * @description 查询所有的报警类型
	 * @return
	 * @throws SQLExeception 
	 */
	public List<AlarmSetting> getAllAlarmTypes() throws SQLException{
		
		return alarmSettingMapper.getAllAlarmTypes();
	}
	
	/** 
	 * @description 根据报警类型编号查询报警类型信息
	 * @param alarmSettingId 
	 * @return
	 * @throws SQLException 
	 */
	public AlarmSetting selectByPrimaryKey(String alarmSettingId) throws SQLException{
		if (Objects.isNull(alarmSettingId)) {
			return null;
		}
		return alarmSettingMapper.selectByPrimaryKey(alarmSettingId);
	}
	
	/** 
	 * @description 添加报警类型
	 * @param alarmSetting
	 * @return
	 * @throws SQLException 
	 */
	public int insert(AlarmSetting alarmSetting) throws SQLException{
		if (Objects.isNull(alarmSetting)) {
			return 0;
		}
		return alarmSettingMapper.insert(alarmSetting);
	}

	/** 
	 * @description 根据报警类型编号删除报警类型
	 * @param alarmSettingId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String alarmSettingId) throws SQLException{
		if (Objects.isNull(alarmSettingId)) {
			return 0;
		}
		return alarmSettingMapper.deleteByPrimaryKey(alarmSettingId);
	}
	
	/** 
	 * @description 更新报警类型信息
	 * @param alarmSetting
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(AlarmSetting alarmSetting) throws SQLException{
		if (Objects.isNull(alarmSetting)) {
			return 0;
		}
		return alarmSettingMapper.updateByPrimaryKeySelective(alarmSetting);
	}

}
