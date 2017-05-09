package com.webleader.appms.controller.region;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.positioning.Region;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.positioning.RegionService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className RegionControl
 * @description 区域管理
 * @author ding
 * @date 2017年5月3日 下午3:59:34
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class RegionControl {

	@Autowired
	private RegionService regionService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 条件查询区域分页信息
	 * @param currentPage
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/base/region/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getRegionListByCondition(@PathVariable int currentPage,
			@RequestBody Map<Object, Object> condition) {
		Response response = new Response();
		List<Region> regionList = null;
		int total = 0;
		
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		try {
			regionList = regionService.getRegionByPageCondition(condition);
			total = regionService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(regionList)) {
			return response.failure("条件查询区域信息失败，请重试").toSimpleResult();
		}
		return response.success().put("regionList", regionList).put("total", total).toCombineResult();
	}
	
	/** 
	 * @description 条件查询区域坐标列表
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/base/map/region", method = RequestMethod.POST)
	public Map<Object, Object> getRegionMapByCondition(@RequestBody Map<Object, Object> condition) {
		Response response = new Response();
		List<Map<Object, Object>> regionList = null;
		
		try {
			regionList = regionService.getRegionMapByCondition(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(regionList)) {
			return response.failure("条件查询区域信息失败，请重试").toSimpleResult();
		}
		return response.success().put("regionList", regionList).toCombineResult();
	}
	
	/** 
	 * @description 添加一个区域信息
	 * @param region
	 * @return 
	 */
	@RequestMapping(value = "/base/region", method = RequestMethod.POST)
	public Map<Object, Object> insertRegion(@RequestBody Region region) {
		Response response = new Response();
		int result = 0;
		region.setRegionId(uuidUtil.getUUID());
		
		try {
			result = regionService.insert(region);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加区域失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改区域普通信息
	 * @param region
	 * @return 
	 */
	@RequestMapping(value = "/base/region", method = RequestMethod.PUT)
	public Map<Object, Object> updateReader(@RequestBody Region region) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = regionService.updateByPrimaryKeySelective(region);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("修改区域失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改区域地图信息
	 * @param region
	 * @return 
	 */
	@RequestMapping(value = "/base/map/region", method = RequestMethod.PUT)
	public Map<Object, Object> updateMapReader(@RequestBody List<Map<Object, Object>> mapInfo) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = regionService.updateRegionList(mapInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result <= 0) {
			return response.failure("修改区域失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 删除区域
	 * @param regionId
	 * @return 
	 */
	@RequestMapping(value = "/base/region/{regionId}", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteReader(@PathVariable String regionId) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = regionService.deleteByPrimaryKey(regionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result <= 0) {
			return response.failure("删除区域失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 查询所有区域地图坐标
	 * @return 
	 */
	@RequestMapping(value = "/base/map/region", method = RequestMethod.GET)
	public Map<Object, Object> getRegionMapList() {
		Response response = new Response();
		List<Map<Object, Object>> regionList = null;
		
		try {
			regionList = regionService.getRegionMapList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(regionList)) {
			return response.failure("条件查询区域信息失败，请重试").toSimpleResult();
		}
		return response.success().put("regionList", regionList).toCombineResult();
	}
}
