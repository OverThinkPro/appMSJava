package com.webleader.appms.db.mapper.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.Schedule;

/**
 * @className ScheduleMapper
 * @description 数据库关于Schedule的接口
 * @author HaoShaSha
 * @date 2017年4月15日 上午1:54:28
 * @version 1.0.0
 */
public interface ScheduleMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据班次编号查询班次信息
	 * @param dutyId 
	 * @return
	 * @throws SQLException 
	 */
	public Schedule selectByPrimaryKey(String dutyId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询班次信息(班次编号，班次名称， 起始记录数，每页的记录数)
	 * @param pageCondition(dutyId,dutyName,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> getScheduleByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的班次数量(班次编号，班次名称)
	 * @param pageCondition(dutyId,scheduleName)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加班次
	 * @param schedule
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Schedule schedule) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据班次编号删除班次
	 * @param dutyId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String dutyId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新班次信息
	 * @param schedule
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Schedule schedule) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}