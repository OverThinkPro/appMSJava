package com.webleader.appms.setting;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.setting.RegionTimeLimit;
import com.webleader.appms.db.mapper.setting.RegionTimeLimitMapper;

/**
 * @className RegionTimeLimitTest
 * @description 测试数据库接口 RegionTimeLimitMapper
 * @author HaoShaSha
 * @date 2017年4月14日 下午6:20:49
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RegionTimeLimitTest {
	
	@Autowired
	private RegionTimeLimitMapper regionMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 主键查询区域时间限制
	 */
	@Test
	public void selectByPrimaryKey(){
		String regionTimeLimtId = "1";
		try {
			RegionTimeLimit region = regionMapper.selectByPrimaryKey(regionTimeLimtId);
			System.out.println(region);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据区域编号查询该区域时间限制
	 */
	@Test
	public void selectByRegionId(){
		String regionId = "a";
		try {
			List<RegionTimeLimit> regions = regionMapper.selectByRegionId(regionId);
			System.out.println(regions.size());
			System.out.println(regions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据工种编号查询该工种收到的区域时间限制
	 */
	@Test
	public void selectByJobId(){
		String jobId = "1";
		try {
			List<RegionTimeLimit> regions = regionMapper.selectByJobId(jobId);
			System.out.println(regions.size());
			System.out.println(regions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加数字字典
	 */
	@Test
	public void insert(){
		//注意，这个表的所有字段不为空
		Timestamp dutyTime = Timestamp.valueOf("2017-04-14 17:06:23");
		RegionTimeLimit regionTimeLimit = new RegionTimeLimit();
		regionTimeLimit.setRegionTimeLimtId("limitId");
		regionTimeLimit.setRegionId("c");
		regionTimeLimit.setDutyTime(dutyTime);
		regionTimeLimit.setJobId("1");
		try {
			int count = regionMapper.insert(regionTimeLimit);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据主键删除区域时间限制
	 */
	@Test
	public void deleteByPrimaryKey(){
		String regionTimeLimtId = "limitId";
		try {
			int count = regionMapper.deleteByPrimaryKey(regionTimeLimtId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据主键删除区域时间限制
	 */
	@Test
	public void deleteByRegionId(){
		String regionId = "a";
		try {
			int count = regionMapper.deleteByRegionId(regionId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据主键删除区域时间限制
	 */
	@Test
	public void deleteByJobId(){
		String jobId = "1";
		try {
			int count = regionMapper.deleteByJobId(jobId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 主键选择性修改区域时间限制
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		
		Timestamp dutyTime = Timestamp.valueOf("2017-05-14 17:06:23");
		RegionTimeLimit regionTimeLimit = new RegionTimeLimit();
		regionTimeLimit.setRegionTimeLimtId("limitId");
		regionTimeLimit.setRegionId("c");
		regionTimeLimit.setDutyTime(dutyTime);
		regionTimeLimit.setJobId("1");
		try {
			int count = regionMapper.updateByPrimaryKeySelective(regionTimeLimit);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}