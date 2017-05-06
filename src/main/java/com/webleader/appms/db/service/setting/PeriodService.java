package com.webleader.appms.db.service.setting;

import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.setting.PeriodSetting;

/**
 * @className PeriodSettingService
 * @description 周期
 * @author HaoShaSha
 * @date 2017年5月3日 上午10:03:23
 * @version 1.0.0
 */
public interface PeriodService {
	
	/** 
	 * @description 根据周期编号查询周期信息
	 * @param periodSettingId 
	 * @return
	 * @throws SQLException 
	 */
	public PeriodSetting selectByPrimaryKey(String periodSettingId) throws SQLException;
	
	/** 
	 * @description 查询所有的周期信息
	 * @param 
	 * @return
	 * @throws SQLException 
	 */
	public List<PeriodSetting> getAllPeriodTypes() throws SQLException;
	
	
	/** 
	 * @description 添加周期
	 * @param periodSetting
	 * @return
	 * @throws SQLException 
	 */
	public int insert(PeriodSetting periodSetting) throws SQLException;

	/** 
	 * @description 根据周期编号删除周期
	 * @param periodSettingId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String periodSettingId) throws SQLException;
	
	/** 
	 * @description 更新周期信息
	 * @param periodSetting
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(PeriodSetting periodSetting) throws SQLException;

}
