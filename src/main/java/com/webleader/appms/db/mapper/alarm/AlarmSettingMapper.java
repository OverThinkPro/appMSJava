package com.webleader.appms.db.mapper.alarm;

import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.alarm.AlarmSetting;

/**
 * @className AlarmSettingMapper
 * @description 数据库关于AlarmSetting的接口
 * @author HaoShaSha
 * @date 2017年4月11日 下午7:41:52
 * @version 1.0.0
 */

public interface AlarmSettingMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据周期类型编号查询周期类型
	 * @param periodId
	 * @return
	 * @throws SQLException 
	 */
	public AlarmSetting selectByPrimaryKey(String periodId) throws SQLException;
	
	/** 
	 * @description 获得所有的周期类型
	 * @return
	 * @throws SQLException 
	 */
	public List<AlarmSetting> getAllAlarmTypes() throws SQLException;
    
	/*****************查询接口结束*******************/
    /*****************插入接口开始*******************/

    /** 
     * @description 添加周期类型
     * @param record
     * @return
     * @throws SQLException 
     */
    public int insert(AlarmSetting alarmSetting) throws SQLException;
    
    /** 
     * @description 选择性的添加周期类型（同insert）
     * @param record
     * @return
     * @throws SQLException 
     */
    public int insertSelective(AlarmSetting alarmSetting) throws SQLException;
    /*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
    
    /** 
     * @description 根据周期类型编号删除周期类型
     * @param periodId
     * @return
     * @throws SQLException 
     */
    public int deleteByPrimaryKey(String periodId) throws SQLException;
    
    /*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
    
    /** 
     * @description 更新周期类型
     * @param record
     * @return
     * @throws SQLException 
     */
    public int updateByPrimaryKeySelective(AlarmSetting alarmSetting) throws SQLException;
    
    /*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}

	
