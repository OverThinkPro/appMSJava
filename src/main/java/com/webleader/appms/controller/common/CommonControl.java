package com.webleader.appms.controller.common;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.positioning.Reader;
import com.webleader.appms.bean.positioning.Region;
import com.webleader.appms.bean.staff.Unit;
import com.webleader.appms.db.service.positioning.ReaderService;
import com.webleader.appms.db.service.positioning.RegionService;
import com.webleader.appms.db.service.positioning.TLStaffService;
import com.webleader.appms.db.service.staff.UnitService;
import com.webleader.appms.util.Response;

/**
 * @className CommonControl
 * @description 用于查询公用数据
 * @author ding
 * @date 2017年4月24日 下午7:48:51
 * @version 1.0.0
 */

@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class CommonControl {
	
	@Autowired
	private TLStaffService tlStaffService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private UnitService unitService;
	@Autowired
	private ReaderService readerService;
	@Autowired
	private Response response;
	
	/** 
	 * @description 查询得到实时的区域信息列表
	 * @return 
	 */
	public Map<Object, Object> getRealTimeRegion(){
		List<Map<Object, Object>> realStaffByRegion = new Stack<Map<Object, Object>>();
		Map<Object, Object> condition = new HashMap<Object, Object>();

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-03-02 02:20:57"));
		condition.put("endTime", Timestamp.from(Instant.now()));
		
		try {
			realStaffByRegion = tlStaffService.countRealStaffByRegion(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(realStaffByRegion)){
			return response.failure("请重新查询").toSimpleResult();
		}
		return response.success().put("realStaffByRegion", realStaffByRegion).toCombineResult();
	}
	
	/** 
	 * @description 查询所有区域列表
	 * @return 
	 */
	@RequestMapping(value = "/base/region", method = RequestMethod.GET)
	public Map<Object, Object> getAllRegion(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		List<Region> regionList = new ArrayList<Region>();
		
		try {
			regionList = regionService.getRegionByPageCondition(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(regionList)){
			return response.failure("查询失败请重试").toSimpleResult();
		}
		return response.success().put("regionList", regionList).toCombineResult();
	}
	
	/** 
	 * @description 查询所有的部门列表
	 * @return 
	 */
	@RequestMapping(value = "/base/unit", method = RequestMethod.GET)
	public Map<Object, Object> getAllUnit(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		List<Unit> unitList = new ArrayList<Unit>();
		
		try {
			unitList = unitService.getUnitByPageCondition(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(unitList)){
			return response.failure("查询失败请重试").toSimpleResult();
		}
		return response.success().put("unitList", unitList).toCombineResult();
	}
	
	/** 
	 * @description 查询所有的分站
	 * @return 
	 */
	@RequestMapping(value = "/base/reader", method = RequestMethod.GET)
	public Map<Object, Object> getAllReader() {
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		List<Reader> readerList = new ArrayList<Reader>();
		
		try {
			readerList = readerService.getReaderByPageCondition(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(readerList)){
			return response.failure("查询失败请重试").toSimpleResult();
		}
			return response.success().put("readerList", readerList).toCombineResult();
	}
	
}
