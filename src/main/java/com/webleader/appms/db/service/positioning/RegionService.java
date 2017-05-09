package com.webleader.appms.db.service.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.Region;

/**
 * @className RegionService
 * @description 区域service
 * @author ding
 * @date 2017年4月24日 下午9:05:03
 * @version 1.0.0
 */
public interface RegionService {
	
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
	
	/** 
	 * @description 条件查询区域地图坐标信息
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getRegionMapByCondition(Map<Object, Object> condition) throws SQLException;
	
	/** 
	 * @description 添加区域
	 * @param region
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Region region) throws SQLException;
	
	/** 
	 * @description 根据主键删除区域
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String regionId) throws SQLException;
	
	/** 
	 * @description 主键选择性修改区域 
	 * @param region
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Region region) throws SQLException;
	
	/** 
	 * @description 批量更新区域坐标点
	 * @param RegionList
	 * @return
	 * @throws SQLException 
	 */
	public int updateRegionList(List<Map<Object, Object>> RegionList) throws SQLException;
	
}
