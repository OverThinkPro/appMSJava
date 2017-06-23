package com.webleader.appms.controller.home;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.alarm.OvermanAlarm;
import com.webleader.appms.bean.alarm.OvertimeAlarm;
import com.webleader.appms.bean.alarm.SpecialRegionAlarm;
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
import com.webleader.appms.util.ErrorMsg;
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
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
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

		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-10)));
		condition.put("endTime", Timestamp.from(Instant.now()));

		try {
			realStaffByUnit = tlStaffService.countRealStaffByUnit(condition);
			realStaffByRegion = tlStaffService.countRealStaffByRegion(condition);
			
			/*判断是否有超员*/
			Map<Object, Object> realStaffRegionInfo = null;
			/*查询数据库是否有超员记录，条件*/
			Map<Object, Object> overmanCondition = new HashMap<Object, Object>();
			/*是否有超员记录结果*/
			Map<Object, Object> overmanResult = null;
			
			for (int i = 0; i < realStaffByRegion.size(); i++) {
				realStaffRegionInfo = realStaffByRegion.get(i);
				
				overmanCondition.put("regionId", realStaffRegionInfo.get("region_id"));
				overmanResult = alarmService.getRegionOverman(overmanCondition);
				
				/*数据库中有该区域历史的超员报警*/
				if (Objects.nonNull(overmanResult) && overmanResult.size() > 0) {
					/*该区域再次超员*/
					if (Integer.valueOf(realStaffRegionInfo.get("total").toString()) > Integer.valueOf(realStaffRegionInfo.get("region_max_people").toString())){
						overmanResult.put("realNumber", realStaffRegionInfo.get("total"));
						/*更新该区域在超员表中的实时人数*/
						alarmService.updateOvermanAlarm(overmanResult);
					}
					
					/*该区域没有超员*/
					else {
						realStaffRegionInfo.put("alarmInhandle", "1");
						realStaffRegionInfo.put("alarmEndTime", Timestamp.from(Instant.now()));
						realStaffRegionInfo.put("alarmId", overmanResult.get("alarm_id"));
						alarmService.updateByPrimaryKeySelective(realStaffRegionInfo);
					}
					
				}
				/*该区域没有历史超员报警*/
				else {
					/*该区域超员*/
					if (Integer.valueOf(realStaffRegionInfo.get("total").toString()) > Integer.valueOf(realStaffRegionInfo.get("region_max_people").toString())){
						realStaffRegionInfo.put("alarmId", uuidUtil.getUUID());
						realStaffRegionInfo.put("alarmStartTime", Timestamp.from(Instant.now()));
						realStaffRegionInfo.put("alarmInhandle", "0");
						realStaffRegionInfo.put("alarmTypeId", "2");
						realStaffRegionInfo.put("overmanId", uuidUtil.getUUID());
						
						alarmService.insertAlarmInfo(realStaffRegionInfo);
						alarmService.insertOvermanAlarm(realStaffRegionInfo);
					}
				}
			}
			
			realAlarmType = alarmService.countRealAlarmType();
			
			
			/*限制区域报警*/
			/*查询报警表中未处理的，但是实时表中已经没有记录的*/
			List<Map<Object, Object>> listAlarm = alarmService.getSpecialAlarmInDB();
			/*员工在危险区域，且没有在报警表中存在*/
			List<Map<Object, Object>> listSpecial = alarmService.getSpecialStaffInDB();
			Map<Object, Object> removeSpecialAlarm = new HashMap<>();
			Map<Object, Object> addSpecialAlarm = new HashMap<>();
			
			if (Objects.nonNull(listAlarm) && listAlarm.size() > 0) {				
				removeSpecialAlarm.put("alarmInhandle", "1");
				removeSpecialAlarm.put("alarmEndTime", Timestamp.from(Instant.now()));
				
				for (int i = 0; i < listAlarm.size(); i++) {
					removeSpecialAlarm.put("alarmId", listAlarm.get(i).get("alarm_id"));
					/*解除报警*/
					alarmService.updateByPrimaryKeySelective(removeSpecialAlarm);
				}
			}
			if (Objects.nonNull(listSpecial) && listSpecial.size() > 0) {
				for (int i = 0; i < listSpecial.size(); i++) {
					addSpecialAlarm.put("alarmId", uuidUtil.getUUID());
					addSpecialAlarm.put("alarmStartTime", Timestamp.from(Instant.now()));
					addSpecialAlarm.put("alarmInhandle", "0");
					addSpecialAlarm.put("alarmTypeId", "3");
					addSpecialAlarm.put("cardId", listSpecial.get(i).get("card_id"));
					
					/*添加一条限制区域报警，到总表中*/
					alarmService.insertAlarmInfo(addSpecialAlarm);
					/*添加一条限制区域报警，到限制区域报警表中*/
					alarmService.insertSpecialAlarm(addSpecialAlarm);
					
				}
			}
			
			
			
			/*超时报警*/
			Map<Object, Object> overtimeCondition = new HashMap<>();
			Map<Object, Object> removeOvertimeAlarm = new HashMap<>();
			Map<Object, Object> addOvertimeAlarm = new HashMap<>();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date currentDate = java.sql.Date.valueOf(formatter.format(Timestamp.from(Instant.now())));
			overtimeCondition.put("workDate", currentDate);
			overtimeCondition.put("currentDate", Timestamp.valueOf(currentDate.toString()+ " 00:00:00"));
			
			List<Map<Object, Object>> listUnOvertime = alarmService.getUnovertimeInfoInDB();
			List<Map<Object, Object>> listRealtimeOvertime = alarmService.getRealtimeOvertimeInDB(overtimeCondition);
			
			if (Objects.nonNull(listUnOvertime) && listUnOvertime.size() > 0) {
				removeOvertimeAlarm.put("alarmInhandle", "1");
				removeOvertimeAlarm.put("alarmEndTime", Timestamp.from(Instant.now()));

				for (int i = 0; i < listUnOvertime.size(); i++) {
					removeOvertimeAlarm.put("alarmId", listUnOvertime.get(i).get("alarm_id"));
					/*解除报警*/
					alarmService.updateByPrimaryKeySelective(removeOvertimeAlarm);
				}
			}
			if (Objects.nonNull(listRealtimeOvertime) && listRealtimeOvertime.size() > 0) {
				addOvertimeAlarm.put("alarmStartTime", Timestamp.from(Instant.now()));
				addOvertimeAlarm.put("alarmInhandle", "0");
				addOvertimeAlarm.put("alarmTypeId", "1");
				
				for (int i = 0; i < listRealtimeOvertime.size(); i++) {
					
					if ((boolean) listRealtimeOvertime.get(i).get("isovertime")) {
						addOvertimeAlarm.put("alarmId", uuidUtil.getUUID());
						addOvertimeAlarm.put("staffId", listRealtimeOvertime.get(i).get("staff_id"));
						addOvertimeAlarm.put("overtimeId", uuidUtil.getUUID());
						addOvertimeAlarm.put("arriveTime", listRealtimeOvertime.get(i).get("arrive_time"));
						
						/*在报警总表中添加一条记录*/
						alarmService.insertAlarmInfo(addOvertimeAlarm);
						/*在超时报警表中，添加一条记录*/
						alarmService.insertOvertimeAlarm(addOvertimeAlarm);
					}
				}
			}
			
			
			
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
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
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
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-10)));
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
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
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
	@RequestMapping(value = "/realtime/alarm/{alarmType}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getCurrentAlarmInfoByType(@PathVariable int alarmType, @PathVariable int currentPage) {
		Response response = new Response();
		Map<Object, Object> condition = new HashMap<Object, Object>();
//		List<StaffAlarm> staffAlarmList = new ArrayList<StaffAlarm>();
//		int countTotalPages = 0;

		/* 测试用 */
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
		// condition.put("startTime",
		// Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());

		/*try {
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
		*/
		
		
		try {
			/* 超时报警 */
			if (alarmType == 1) {
				List<OvertimeAlarm> overtimeAlarmList = alarmService.listOvertimeByPageCondition(condition);
				int overtimeAlarmNum = alarmService.countOvertimeByConditon(condition);
				if (Objects.isNull(overtimeAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", overtimeAlarmList).put("total", overtimeAlarmNum).toCombineResult();
			}
			
			/* 超员报警 */
			else if (alarmType == 2) {
				List<OvermanAlarm> overAlarmList = alarmService.listOvermanByPageCondition(condition);
				int overAlarmNum = alarmService.countOvermanByConditon(condition);
				if (Objects.isNull(overAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", overAlarmList).put("total", overAlarmNum).toCombineResult();
			}
			
			/* 限制区域报警 */
			else if (alarmType == 3) {
				List<SpecialRegionAlarm> specialRegionAlarmList = alarmService.listRegionAlarmByPageCondition(condition);
				int specialRegionAlarmNum = alarmService.countSpecialRegionAlarmByConditon(condition);
				if (Objects.isNull(specialRegionAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", specialRegionAlarmList).put("total", specialRegionAlarmNum).toCombineResult();
			}
			
			/* 员工呼叫报警 */
			else if (alarmType == 4) {
				List<StaffAlarm> staffAlarmList = alarmService.listStaffAlarmByPageCondition(condition);
				int staffAlarmNum = alarmService.countStaffAlarmByConditon(condition);
				if (Objects.isNull(staffAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", staffAlarmList).put("total", staffAlarmNum).toCombineResult();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response.failure("查询失败，请重试").toSimpleResult();
		
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
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
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
	@SystemLogController(opType="呼叫",opContent="记录一条或多条撤离呼叫")
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
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
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
	@SystemLogController(opType="呼叫",opContent="回电呼叫")
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
	
	/** 
	 * @description 首页实时查询实时员工位置坐标
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/map/realtime/staff", method = RequestMethod.GET)
	public Map<Object, Object> getRealtimeStaffMap(@RequestParam(value = "unitId", required = false) String unitId) {
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<Map<Object, Object>> staffPointList = null;
		Response response = new Response();
		
		if (Objects.nonNull(unitId) && !unitId.equals("")){
			condition.put("unitId", unitId);
		}
//		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		condition.put("startTime", Timestamp.from(Instant.now().plusSeconds(-50)));
		condition.put("endTime", Timestamp.from(Instant.now().plusSeconds(50)));
		
		try {
			staffPointList = tlStaffService.listStaffPointByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(staffPointList)){
			return response.failure("实时查询员工信息失败，请重试").toSimpleResult();
		}
		return response.success().put("staffPointList", staffPointList).toCombineResult();
	}
	
//	***************************************************************************测试
	/** 
	 * @description 添加一个呼叫报警记录 
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/staff/alarm/{cardId}", method = RequestMethod.POST)
	public Map<Object, Object> insertStaffAlarm(@PathVariable String cardId) {
		Response response = new Response();
		Map<Object, Object> staffAlarm = new HashMap<Object, Object>();
		int insertBaseAlarm = 0;
		int insertStaffAlarm = 0;
		
		staffAlarm.put("alarmId", uuidUtil.getUUID());
		staffAlarm.put("alarmStartTime", Timestamp.from(Instant.now()));
		staffAlarm.put("alarmInhandle", "0");
		staffAlarm.put("alarmTypeId", "4");
		staffAlarm.put("cardId", cardId);
		
		try {
			insertBaseAlarm = alarmService.insertAlarmInfo(staffAlarm);
			insertStaffAlarm = alarmService.insertStaffAlarm(staffAlarm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (insertStaffAlarm > 0 && insertBaseAlarm > 0) {
			return response.success().toSimpleResult();
		}
		return response.failure("员工呼叫失败").toSimpleResult();
	}
	
	
	/** 
	 * @description 解除员工呼叫报警
	 * @param regionIdArr
	 * @return 
	 */
	@RequestMapping(value = "/staff/alarm", method = RequestMethod.POST)
	public Map<Object, Object> updateStaffAlarm(@RequestParam("alarmIdArr[]") String[] alarmIdArr) {
		Response response = new Response();
		Map<Object, Object> alarm = new HashMap<Object, Object>();
		int updateBaseAlarm = 0;
		
		alarm.put("alarmInhandle", "1");
		alarm.put("alarmEndTime", Timestamp.from(Instant.now()));
		
		try {
			for (int i = 0; i < alarmIdArr.length; i++) {
				alarm.put("alarmId", alarmIdArr[i]);
				updateBaseAlarm = alarmService.updateByPrimaryKeySelective(alarm);
				if (updateBaseAlarm <= 0) {
					return response.failure("员工呼叫失败").toSimpleResult();
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return response.success(ErrorMsg.SUCCESS).toSimpleResult();
	}
//**********************************************************************测试
}
