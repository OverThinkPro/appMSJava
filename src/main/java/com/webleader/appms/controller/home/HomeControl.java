package com.webleader.appms.controller.home;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.positioning.TLStaff;
import com.webleader.appms.common.ModalPageConstants;
import com.webleader.appms.db.service.alarm.AlarmService;
import com.webleader.appms.db.service.positioning.TLStaffService;
import com.webleader.appms.db.service.setting.CoalmineService;
import com.webleader.appms.util.Response;

/**
 * @className HomeControl
 * @description 查询出首页需要的信息
 * @author ding
 * @date 2017年4月21日 上午11:29:36
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class HomeControl {

	@Autowired
	private AlarmService alarmService;
	@Autowired
	private TLStaffService tlStaffService;
	@Autowired
	private CoalmineService coalmineService;
	@Autowired
	private ModalPageConstants modalPageConstants;

	/**
	 * @description 查询煤矿基本信息
	 * @return Map
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/coalmine", method = RequestMethod.GET)
	public Map<Object, Object> getCoalmineInfo() {
		Map<Object, Object> condition = new HashMap<Object, Object>();
		Map<Object, Object> coalmineInfo = new HashMap<Object, Object>();

		/*测试用*/
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
//		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("currentCoalmineId", "1");
		try {
			coalmineInfo = coalmineService.getCoalmineInfo(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(coalmineInfo)) {
			return new Response().failure("请重新查询").toSimpleResult();
		}
		return new Response().success().put("coalmineInfo", coalmineInfo).toCombineResult();
	}

	/**
	 * @description 查询首页右侧的信息，当班人数，区域人数，未处理的警报
	 * @return Map
	 * @exception SQLException
	 */
	@RequestMapping(value = "/realtime/count", method = RequestMethod.GET)
	public Map<Object, Object> getRealTimeInfo() {
		/* 查询条件 */
		Map<Object, Object> condition = new HashMap<Object, Object>();
		/* 查询当班人数统计 */
		List<Map<Object, Object>> realStaffByUnit = new Stack<Map<Object, Object>>();
		/* 查询区域人数统计 */
		List<Map<Object, Object>> realStaffByRegion = new Stack<Map<Object, Object>>();
		/* 查询出来的未处理的报警 */
		List<Map<Object, Object>> realAlarmType = new Stack<Map<Object, Object>>();

		/*测试用*/
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
//		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));

		try {
			realStaffByUnit = tlStaffService.countRealStaffByUnit(condition);
			realStaffByRegion = tlStaffService.countRealStaffByRegion(condition);
			realAlarmType = alarmService.countRealAlarmType();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(realStaffByUnit) || Objects.isNull(realStaffByRegion) || Objects.isNull(realAlarmType)) {
			return new Response().failure("查询失败，请刷新界面").toSimpleResult();
		}
		return new Response().success().put("realUnit", realStaffByUnit).put("realRegion", realStaffByRegion)
				.put("realAlarm", realAlarmType).toCombineResult();
	}
	
	/** 
	 * @description 通过UnitID，查询员工列表， 当班人数详细信息
	 * @return Map
	 * @throws SQLException
	 */
	@RequestMapping(value = "/realtime/staff/unit/{unitId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getStaffListsByUnitId(@PathVariable String unitId, @PathVariable("currentPage") int currentPage){
		if (Objects.isNull(unitId)) {
			return null;
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<TLStaff> tlStaffList = new ArrayList<TLStaff>();
		int countTotalPages = 0;
		
		/*测试用*/
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
//		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());
		condition.put("unitId", unitId);
		try {
			tlStaffList = tlStaffService.listRealStaffByPageCondition(condition);
			countTotalPages = modalPageConstants.getPages(tlStaffService.countTotalStaffByConditon(condition));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(tlStaffList)) {
			return new Response().failure("查询失败，请重试").toSimpleResult();
		}
		return new Response().success().put("tlStaffList", tlStaffList).put("countTotalPages", countTotalPages).toCombineResult();
	}

}
