package com.webleader.appms.db.service.impl.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.staff.JobType;
import com.webleader.appms.db.mapper.staff.JobTypeMapper;
import com.webleader.appms.db.service.staff.JobTypeService;

/**
 * @className JobTypeServiceImpl
 * @description 工种服务层
 * @author ding
 * @date 2017年5月1日 下午5:29:09
 * @version 1.0.0
 */
@Service("jobTypeService")
public class JobTypeServiceImpl implements JobTypeService{
	
	@Autowired
	private JobTypeMapper jobTypeMapper;
	
	/** 
	 * @description 根据工种编号查询工种信息
	 * @param jobId 
	 * @return
	 * @throws SQLException 
	 */
	public JobType selectByPrimaryKey(String jobId) throws SQLException{
		if (Objects.isNull(jobId)) {
			return null;
		}
		return jobTypeMapper.selectByPrimaryKey(jobId);
	}
	
	/** 
	 * @description 组合条件分页查询工种信息(工种编号，工种名称， 起始记录数，每页的记录数)
	 * @param pageCondition(jobId,jobName,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<JobType> getJobTypeByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return jobTypeMapper.getJobTypeByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的工种数量(工种编号，工种名称)
	 * @param pageCondition(jobId,jobTypeName)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return jobTypeMapper.getCountByConditon(condition);
	}

	/** 
	 * @description 添加工种
	 * @param jobType
	 * @return
	 * @throws SQLException 
	 */
	public int insert(JobType jobType) throws SQLException{
		if (Objects.isNull(jobType)) {
			return 0;
		}
		return jobTypeMapper.insert(jobType);
	}

	/** 
	 * @description 根据工种编号删除工种
	 * @param jobId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String jobId) throws SQLException{
		if (Objects.isNull(jobId)) {
			return 0;
		}
		return jobTypeMapper.deleteByPrimaryKey(jobId);
	}
	
	/** 
	 * @description 更新工种信息
	 * @param jobType
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(JobType jobType) throws SQLException{
		if (Objects.isNull(jobType)) {
			return 0;
		}
		return jobTypeMapper.updateByPrimaryKeySelective(jobType);
	}

}
