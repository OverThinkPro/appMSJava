package com.webleader.appms.staff;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.staff.JobType;
import com.webleader.appms.db.mapper.staff.JobTypeMapper;

/**
 * @className JobTypeTest
 * @description 测试数据库接口JobTypeMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午5:29:06
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JobTypeTest {
	
	@Autowired
	private JobTypeMapper jobTypeMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据工种编号查询工种信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String jobTypeId = "1";
		try {
			JobType jobType = jobTypeMapper.selectByPrimaryKey(jobTypeId);
			System.out.println(jobType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询工种信息
	 */
	@Test
	public void getJobTypeByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("jobId", "1");
		pageCondition.put("jobName", "掘进工");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<JobType> jobTypes = jobTypeMapper.getJobTypeByPageCondition(pageCondition);
			for (int i = 0; i < jobTypes.size(); i++) {
				System.out.println(jobTypes.get(i));
			}
			System.out.println(jobTypes.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的工种数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("jobId", "1");
		condition.put("jobName", "掘进工");
		try {
			int totalCount = jobTypeMapper.getCountByConditon(condition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加工种
	 */
	@Test
	public void insert(){
		JobType jobType = new JobType();
		jobType.setJobId("jobTypeId");
		jobType.setJobName("添加工种");
		jobType.setJobCode("1");
		jobType.setJobIconUrl("/");
		jobType.setRemark("");
		try {
			int count = jobTypeMapper.insert(jobType);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据工种编号删除工种
	 */
	@Test
	public void deleteByPrimaryKey(){
		String jobTypeId = "jobTypeId";
		try {
			int count = jobTypeMapper.deleteByPrimaryKey(jobTypeId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新工种信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		JobType jobType = new JobType();
		jobType.setJobId("jobTypeId");
		jobType.setJobName("修改工种");
		jobType.setJobCode("1");
		jobType.setJobIconUrl("/");
		jobType.setRemark("");
		try {
			int count = jobTypeMapper.updateByPrimaryKeySelective(jobType);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}