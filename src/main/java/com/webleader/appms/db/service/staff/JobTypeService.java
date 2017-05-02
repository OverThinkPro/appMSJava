package com.webleader.appms.db.service.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.JobType;

/**
 * @className JobTypeService
 * @description 工种
 * @author ding
 * @date 2017年5月1日 下午5:28:08
 * @version 1.0.0
 */
public interface JobTypeService {
	
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

	/** 
	 * @description 添加工种
	 * @param jobType
	 * @return
	 * @throws SQLException 
	 */
	public int insert(JobType jobType) throws SQLException;

	/** 
	 * @description 根据工种编号删除工种
	 * @param jobId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String jobId) throws SQLException;
	
	/** 
	 * @description 更新工种信息
	 * @param jobType
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(JobType jobType) throws SQLException;

}
