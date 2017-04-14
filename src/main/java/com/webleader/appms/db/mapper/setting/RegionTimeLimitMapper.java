package com.webleader.appms.db.mapper.setting;

import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.setting.RegionTimeLimit;

/**
 * @className RegionTimeLimitMapper
 * @description 数据库关于RegionTimeLimit的接口
 * @author HaoShaSha
 * @date 2017年4月14日 下午5:33:27
 * @version 1.0.0
 */
public interface RegionTimeLimitMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	

	/** 
	 * @description 主键查询区域时间限制
	 * @param regionTimeLimtId
	 * @return
	 * @throws SQLException 
	 */
	public RegionTimeLimit selectByPrimaryKey(String regionTimeLimtId) throws SQLException;

	/** 
	 * @description 根据区域编号查询该区域时间限制
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public List<RegionTimeLimit> selectByRegionId(String regionId) throws SQLException;
	
	/** 
	 * @description 根据工种编号查询该工种收到的区域时间限制
	 * @param jobId
	 * @return
	 * @throws SQLException 
	 */
	public List<RegionTimeLimit> selectByJobId(String jobId) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加区域时间限制
	 * @param regionTimeLimit
	 * @return
	 * @throws SQLException 
	 */
	public int insert(RegionTimeLimit regionTimeLimit) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据主键删除区域时间限制
	 * @param regionTimeLimtId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String regionTimeLimtId) throws SQLException;
	
	/** 
	 * @description 根据区域编号删除区域时间限制 
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByRegionId(String regionId) throws SQLException;
	
	/** 
	 * @description 根据工种编号删除区域时间限制
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByJobId(String jobId) throws SQLException;
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 主键选择性修改区域时间限制(注意：修改应该只针对时间字段)
	 * @param regionTimeLimit
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(RegionTimeLimit regionTimeLimit) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}