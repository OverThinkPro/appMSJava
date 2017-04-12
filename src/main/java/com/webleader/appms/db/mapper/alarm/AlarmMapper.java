package com.webleader.appms.db.mapper.alarm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.alarm.Alarm;

/**
 * @className AlarmMapper
 * @description 数据库关于Alarm的接口
 * @author HaoShaSha
 * @date 2017年4月11日 下午11:34:50
 * @version 1.0.0
 */
public interface AlarmMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	
	/** 
	 * @description 主键查询报警信息
	 * @param alarmId
	 * @return
	 * @throws SQLException 
	 */
	public Alarm selectByPrimaryKey(String alarmId) throws SQLException;
	
	
	/** 
	 * @description 统计未被处理的各个类型的报警信息的数量
	 * @return List<Map<Object,Object>>(alarm_type_id,alarm_name,total)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> countRealAlarmType() throws SQLException;
    
	/*****************查询接口结束*******************/
    /*****************删除接口开始*******************/
    
   
    /** 
     * @description 根据条件删除报警信息or清空表
     * @param condition(alarm_inhandle,alarmId,alarmTime,alarmEndTime)
     * @return
     * @throws SQLException 
     */
    public int deleteByCondition(Map<Object,Object> condition) throws SQLException;
    
    /*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
   
    /** 
     * @description 更新报警处理结果
     * @param alarm (alarmInhandle,alarmId,alarmEndTime)
     * @return
     * @throws SQLException 
     */
    public int updateByPrimaryKeySelective(Alarm alarm) throws SQLException;
    
    /*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}

	
