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
	 * @description 组合条件分页查询区域信息(区域名称，区域类型， 起始记录数，每页的记录数)
	 * @param pageCondition(regionName,regionType,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Region> getRegionByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
}
