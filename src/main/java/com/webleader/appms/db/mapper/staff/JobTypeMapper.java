package com.webleader.appms.db.mapper.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.JobType;

/**
 * @className JobTypeMapper
 * @description 数据库关于JobType的接口
 * @author HaoShaSha
 * @date 2017年4月15日 上午1:57:48
 * @version 1.0.0
 */
public interface JobTypeMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据工种编号查询工种信息
	 * @param jobId 
	 * @return
	 * @throws SQLException 
	 */
	public JobType selectByPrimaryKey(String jobId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询工种信息(工种编号，工种名称， 起始记录数，每页的记录数)
	 * @param pageCondition(jobId,jobName,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<JobType> getJobTypeByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的工种数量(工种编号，工种名称)
	 * @param pageCondition(jobId,jobTypeName)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加工种
	 * @param jobType
	 * @return
	 * @throws SQLException 
	 */
	public int insert(JobType jobType) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据工种编号删除工种
	 * @param jobId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String jobId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新工种信息
	 * @param jobType
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(JobType jobType) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}