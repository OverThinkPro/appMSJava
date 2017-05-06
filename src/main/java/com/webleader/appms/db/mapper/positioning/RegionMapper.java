package com.webleader.appms.db.mapper.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.Region;

/**
 * @className RegionMapper
 * @description 数据库关于Region的接口
 * @author HaoShaSha
 * @date 2017年4月14日 下午5:44:35
 * @version 1.0.0
 */
public interface RegionMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 主键查询区域信息
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public Region selectByPrimaryKey(String regionId) throws SQLException;

	/** 
	 * @description 组合条件分页查询区域信息(区域名称，区域类型， 起始记录数，每页的记录数)
	 * @param pageCondition(regionName,regionType,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Region> getRegionByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的区域数量(区域名称，区域类型)
	 * @param condition(regionName,regionType)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 查询所有的区域地图坐标信息
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getRegionMapList() throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加区域
	 * @param region
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Region region) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据主键删除区域
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String regionId) throws SQLException;
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 主键选择性修改区域 
	 * @param region
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Region region) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}