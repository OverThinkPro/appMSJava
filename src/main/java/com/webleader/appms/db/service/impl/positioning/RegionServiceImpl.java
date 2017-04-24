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
	 * @description 组合条件分页查询区域信息(区域名称，区域类型， 起始记录数，每页的记录数)
	 * @param pageCondition(regionName,regionType,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Region> getRegionByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return regionMapper.getRegionByPageCondition(pageCondition);
	}
}
