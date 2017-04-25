package com.webleader.appms.controller.home;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.alarm.StaffAlarm;
import com.webleader.appms.bean.communication.CallStaff;
import com.webleader.appms.bean.communication.EvacuateDetail;
import com.webleader.appms.bean.positioning.TLStaff;
import com.webleader.appms.common.ModalPageConstants;
import com.webleader.appms.db.service.alarm.AlarmService;
import com.webleader.appms.db.service.communication.CallBackService;
import com.webleader.appms.db.service.communication.EvacuationService;
import com.webleader.appms.db.service.positioning.TLStaffService;
import com.webleader.appms.db.service.setting.CoalmineService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

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
	private EvacuationService evacuationService;
	@Autowired
	private CallBackService callBackService;
	@Autowired
	private ModalPageConstants modalPageConstants;
	@Autowired
	private UUIDUtil uuidUtil;

	/**
	 * @description 查询煤矿基本信息
	 * @return Map
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/coalmine", method = RequestMethod.GET)
	public Map<Object, Object> getCoalmineInfo() {
		Map<Object, Object> condition = new HashMap<Object, Object>();
		Map<Object, Object> coalmineInfo = new HashMap<Object, Object>();
		Response response = new Response();

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("currentCoalmineId", "1");
		try {
			coalmineInfo = coalmineService.getCoalmineInfo(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(coalmineInfo)) {
			return response.failure("请重新查询").toSimpleResult();
		}
		return response.success().put("coalmineInfo", coalmineInfo).toCombineResult();
	}

	/**
	 * @description 查询首页右侧的信息，当班人数，区域人数，未处理的警报
	 * @return Map
	 * @exception SQLException
	 */
	@RequestMapping(value = "/realtime/count", method = RequestMethod.GET)
	public Map<Object, Object> getRealTimeInfo() {
		Response response = new Response();
		/* 查询条件 */
		Map<Object, Object> condition = new HashMap<Object, Object>();
		/* 查询当班人数统计 */
		List<Map<Object, Object>> realStaffByUnit = new Stack<Map<Object, Object>>();
		/* 查询区域人数统计 */
		List<Map<Object, Object>> realStaffByRegion = new Stack<Map<Object, Object>>();
		/* 查询出来的未处理的报警 */
		List<Map<Object, Object>> realAlarmType = new Stack<Map<Object, Object>>();

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));

		try {
			realStaffByUnit = tlStaffService.countRealStaffByUnit(condition);
			realStaffByRegion = tlStaffService.countRealStaffByRegion(condition);
			realAlarmType = alarmService.countRealAlarmType();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(realStaffByUnit) || Objects.isNull(realStaffByRegion) || Objects.isNull(realAlarmType)) {
			return response.failure("查询失败，请刷新界面").toSimpleResult();
		}
		return response.success().put("realUnit", realStaffByUnit).put("realRegion", realStaffByRegion)
				.put("realAlarm", realAlarmType).toCombineResult();
	}

	/**
	 * @description 通过UnitID，查询员工列表， 当班人数详细信息
	 * @return Map
	 * @throws SQLException
	 */
	@RequestMapping(value = "/realtime/staff/unit/{unitId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getStaffListsByUnitId(@PathVariable String unitId,
			@PathVariable("currentPage") int currentPage) {
		Response response = new Response();
		
		if (Objects.isNull(unitId)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<TLStaff> tlStaffList = new ArrayList<TLStaff>();
		int countTotalPages = 0;

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());
		condition.put("unitId", unitId);
		try {
			tlStaffList = tlStaffService.listRealStaffByPageCondition(condition);
			countTotalPages = tlStaffService.countTotalStaffByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(tlStaffList)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		return response.success().put("tlStaffList", tlStaffList).put("countTotalPages", countTotalPages)
				.toCombineResult();
	}

	/**
	 * @description 通过regionID，查询员工列表， 区域人数的详细信息
	 * @return Map
	 * @throws SQLException
	 */
	@RequestMapping(value = "/realtime/staff/region/{regionId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getStaffListsByRegionId(@PathVariable String regionId, @PathVariable int currentPage) {
		Response response = new Response();
		
		if (Objects.isNull(regionId) || Objects.isNull(currentPage)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<TLStaff> tlStaffList = new ArrayList<TLStaff>();
		int countTotalPages = 0;

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());
		condition.put("regionId", regionId);
		try {
			tlStaffList = tlStaffService.listRealStaffByPageCondition(condition);
			countTotalPages = tlStaffService.countTotalStaffByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(tlStaffList)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		return response.success().put("tlStaffList", tlStaffList).put("countTotalPages", countTotalPages)
				.toCombineResult();
	}

	/**
	 * @description 通过区域ID，查询撤离呼叫的详细信息
	 * @param regionId，currentPage
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/realtime/evacuate/region/{regionId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getEvacuateDetailByRegionId(@PathVariable String regionId,
			@PathVariable int currentPage) {
		Response response = new Response();
		
		if (Objects.isNull(regionId) || Objects.isNull(currentPage)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<EvacuateDetail> evacuationDetails = new ArrayList<EvacuateDetail>();
		/* 总页数 */
		int countTotalPages = 0;
		/* 已呼叫人数 */
		int called = 0;
		/* 总共需要呼叫的人数 */
		int callCount = 0;

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-03-02 02:20:57"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());
		condition.put("regionId", regionId);

		try {
			evacuationDetails = evacuationService.listEvacuateDetailByPageCondition(condition);
			callCount = evacuationService.countEvacuateDetailByCondition(condition);
			countTotalPages = callCount;

			condition.put("call_status", "1");
			called = evacuationService.countEvacuateDetailByCondition(condition);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(evacuationDetails)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}

		return response.success().put("evacuationDetails", evacuationDetails).put("calledNum", called)
				.put("countTotalPages", countTotalPages).put("callCount", callCount).toCombineResult();
	}

	/**
	 * @description 通过alarmID查询各种警报的详细信息
	 * @param alarmId
	 * @return
	 */
	@RequestMapping(value = "/realtime/alarm/{alarmId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getCurrentAlarmInfoByType(@PathVariable String alarmId, @PathVariable int currentPage) {
		Response response = new Response();
		
		if (Objects.isNull(alarmId) || Objects.isNull(currentPage)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<StaffAlarm> staffAlarmList = new ArrayList<StaffAlarm>();
		int countTotalPages = 0;

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-03-02 02:20:57"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());

		try {
			staffAlarmList = alarmService.listStaffAlarmByPageCondition(condition);
			countTotalPages = alarmService.countStaffAlarmByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(staffAlarmList)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		return response.success().put("staffAlarmList", staffAlarmList).put("countTotalPages", countTotalPages)
				.toCombineResult();
	}

	/**
	 * @description 撤离呼叫中，查询区域统计信息
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/base/region/count/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getRegionInfo(@PathVariable int currentPage) {
		return realStaffByCondition(null, currentPage);
	}

	/**
	 * @description 撤离呼叫中，通过区域ID，查询出区域信息
	 * @param regionId
	 * @return
	 */
	@RequestMapping(value = "/base/region/count/{regionId}", method = RequestMethod.GET)
	public Map<Object, Object> getRegionInfoByRegionId(@PathVariable String regionId) {
		return realStaffByCondition(regionId, null);
	}

	private Map<Object, Object> realStaffByCondition(String regionId, Integer currentPage) {
		List<Map<Object, Object>> realStaffByRegion = new Stack<Map<Object, Object>>();
		Map<Object, Object> condition = new HashMap<Object, Object>();
		Integer countTotalPages = 0;
		Response response = new Response();

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-03-02 02:20:57"));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("regionId", regionId);

		try {
			if (Objects.nonNull(currentPage)) {
				countTotalPages = tlStaffService.countAllRegion(condition);
				condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
				condition.put("pageSize", modalPageConstants.getPageSize());

				// response = response.success().put("countTotalPages",
				// countTotalPages);
			}

			realStaffByRegion = tlStaffService.countRealStaffByRegion(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(realStaffByRegion)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		} else {
			response = response.success().put("realStaffByRegion", realStaffByRegion);
			if (Objects.nonNull(currentPage)) {
				return response.put("countTotalPages", countTotalPages).toCombineResult();
			}
			return response.toCombineResult();
		}
	}

	/**
	 * @description 记录一条或多条撤离呼叫
	 * @param regionId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/base/evacuate/region/u/{userId}", method = RequestMethod.POST)
	public Map<Object, Object> evacuationCall(@RequestParam("regionIdArr[]") String[] regionIdArr,
			@PathVariable String userId) {
		Response response = new Response();
		
		if (Objects.isNull(userId) || Objects.isNull(regionIdArr)) {
			return response.failure("撤离呼叫失败请重试").toSimpleResult();
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		int insertEvacuate = 0;
		int insertEvacuateDetail = 0;
		// String[] regionIdList = regionIdArr.split(",");

		try {

			for (String regionId : regionIdArr) {
				condition.put("userId", userId);
				condition.put("callTime", Timestamp.from(Instant.now()));
				condition.put("regionId", regionId);
				condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
				condition.put("endTime", Timestamp.from(Instant.now()));

				List<Map<Object, Object>> InsertEvacuationList = evacuationService.getInsertEvacuation(condition);

				InsertEvacuationList.forEach(item -> {
					item.put("evacuate_id", uuidUtil.getUUID());
					item.put("detail_id", uuidUtil.getUUID());
					item.put("call_status", "0");
					item.put("call_time", Timestamp.from(Instant.now()));
					item.put("entering_time", Timestamp.valueOf(item.get("entering_date").toString()));
				});
				insertEvacuate = evacuationService.insertEvacuation(InsertEvacuationList);
				insertEvacuateDetail = evacuationService.insertEvacuateDetail(InsertEvacuationList);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (insertEvacuate == 0 || insertEvacuateDetail == 0) {
			return response.failure("添加撤离呼叫失败").toSimpleResult();
		}

		return response.success().put("insertEvacuate", insertEvacuate)
				.put("insertEvacuateDetail", insertEvacuateDetail).toCombineResult();
	}

	/**
	 * @description 回电呼叫，条件查询所有员工信息
	 * @param currentPage
	 * @param unitId
	 * @param staffName
	 * @return
	 */
	@RequestMapping(value = "/base/staff/count/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getStaffByCondition(@PathVariable int currentPage,
			@RequestParam(value = "unitId", required = false) String unitId,
			@RequestParam(value = "staffName", required = false) String staffName) {
		Response response = new Response();
		
		if (Objects.isNull(currentPage)) {
			return response.failure("查询失败请重试").toSimpleResult();
		}
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<TLStaff> tlStaffList = new ArrayList<TLStaff>();
		int countTotalPages = 0;

		/* 测试用 */
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());
		if (Objects.nonNull(unitId) && !unitId.equals("")) {
			condition.put("unitId", unitId);
		}
		if (Objects.nonNull(staffName) && !staffName.equals("")) {
			condition.put("staffName", staffName);
		}

		try {
			tlStaffList = tlStaffService.listRealStaffByPageCondition(condition);
			countTotalPages = tlStaffService.countTotalStaffByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(tlStaffList)) {
			return response.failure("查询失败请重试").toSimpleResult();
		}
		return response.success().put("realStaffByCondition", tlStaffList).put("countTotalPages", countTotalPages)
				.toCombineResult();
	}

	@RequestMapping(value = "/base/callback/staff/u/{userId}", method = RequestMethod.POST)
	public Map<Object, Object> callStaffBack(@PathVariable String userId,
			@RequestParam(value = "staffIdArr[]", required = false) String[] staffIdArr) {
		Response response = new Response();
		
		if (Objects.isNull(staffIdArr)) {
			return response.failure("回电呼叫失败，请重试").toSimpleResult();
		}
		Date callTime = Timestamp.from(Instant.now());
		List<CallStaff> callStaffList = new ArrayList<CallStaff>();
		int callBackNum = 0;

		for (String staffId : staffIdArr) {
			CallStaff callStaffBean = new CallStaff();

			callStaffBean.setCallStaffId(uuidUtil.getUUID());
			callStaffBean.setCallTime(callTime);
			callStaffBean.setStaffId(staffId);
			callStaffBean.setUserId(userId);
			callStaffBean.setCallType("撤退");
			callStaffList.add(callStaffBean);

		}
		try {
			callBackNum = callBackService.insert(callStaffList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (callBackNum == 0) {
			return response.failure("回电呼叫失败，请重试").toSimpleResult();
		}
		return response.success().put("callBackNum", callBackNum).toCombineResult();
	}
}
