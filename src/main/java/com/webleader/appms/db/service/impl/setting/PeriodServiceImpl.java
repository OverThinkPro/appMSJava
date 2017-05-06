package com.webleader.appms.db.service.impl.setting;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.setting.PeriodSetting;
import com.webleader.appms.db.mapper.setting.PeriodSettingMapper;
import com.webleader.appms.db.service.setting.PeriodService;

/**
 * @className PeriodServiceImpl
 * @description 周期服务层
 * @author HaoShaSha
 * @date 2017年5月3日 上午10:05:45
 * @version 1.0.0
 */
@Service("periodSettingService")
public class PeriodServiceImpl implements PeriodService{
	
	@Autowired
	private PeriodSettingMapper periodSettingMapper;
	
	/** 
	 * @description 查询所有的周期
	 * @return
	 * @throws SQLExeception 
	 */
	public List<PeriodSetting> getAllPeriodTypes() throws SQLException{
		
		return periodSettingMapper.getAllPeriodTypes();
	}
	
	/** 
	 * @description 根据周期编号查询周期信息
	 * @param periodSettingId 
	 * @return
	 * @throws SQLException 
	 */
	public PeriodSetting selectByPrimaryKey(String periodSettingId) throws SQLException{
		if (Objects.isNull(periodSettingId)) {
			return null;
		}
		return periodSettingMapper.selectByPrimaryKey(periodSettingId);
	}
	
	/** 
	 * @description 添加周期
	 * @param periodSetting
	 * @return
	 * @throws SQLException 
	 */
	public int insert(PeriodSetting periodSetting) throws SQLException{
		if (Objects.isNull(periodSetting)) {
			return 0;
		}
		return periodSettingMapper.insert(periodSetting);
	}

	/** 
	 * @description 根据周期编号删除周期
	 * @param periodSettingId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String periodSettingId) throws SQLException{
		if (Objects.isNull(periodSettingId)) {
			return 0;
		}
		return periodSettingMapper.deleteByPrimaryKey(periodSettingId);
	}
	
	/** 
	 * @description 更新周期信息
	 * @param periodSetting
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(PeriodSetting periodSetting) throws SQLException{
		if (Objects.isNull(periodSetting)) {
			return 0;
		}
		return periodSettingMapper.updateByPrimaryKeySelective(periodSetting);
	}

}
