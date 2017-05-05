package com.webleader.appms.db.service.impl.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.positioning.Region;
import com.webleader.appms.db.mapper.positioning.RegionMapper;
import com.webleader.appms.db.service.positioning.RegionService;

/**
 * @className RegionServiceImpl
 * @description 区域
 * @author ding
 * @date 2017年4月24日 下午9:05:35
 * @version 1.0.0
 */
@Service("regionService")
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private RegionMapper regionMapper;

	/** 
	 * @description 主键查询区域信息
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public Region selectByPrimaryKey(String regionId) throws SQLException{
		if (Objects.isNull(regionId)) {
			return null;
		}
		return regionMapper.selectByPrimaryKey(regionId);
	}

	/** 
	 * @description 组合条件分页查询区域信息(区域名称，区域类型， 起始记录数，每页的记录数)
	 * @param pageCondition(regionName,regionType,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Region> getRegionByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return regionMapper.getRegionByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的区域数量(区域名称，区域类型)
	 * @param condition(regionName,regionType)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return regionMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 查询所有的区域地图坐标信息
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getRegionMapList() throws SQLException {
		return regionMapper.getRegionMapList();
	}
	
	/** 
	 * @description 添加区域
	 * @param region
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Region region) throws SQLException {
		if (Objects.isNull(region)) {
			return 0;
		}
		return regionMapper.insert(region);
	}
	
	/** 
	 * @description 根据主键删除区域
	 * @param regionId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String regionId) throws SQLException{
		if (Objects.isNull(regionId)) {
			return 0;
		}
		return regionMapper.deleteByPrimaryKey(regionId);
	}
	
	/** 
	 * @description 主键选择性修改区域 
	 * @param region
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Region region) throws SQLException {
		if (Objects.isNull(region)) {
			return 0;
		}
		return regionMapper.updateByPrimaryKeySelective(region);
	}
	

}
