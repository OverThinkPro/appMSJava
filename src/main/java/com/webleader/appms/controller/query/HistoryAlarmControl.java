package com.webleader.appms.controller.query;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.alarm.OvermanAlarm;
import com.webleader.appms.bean.alarm.OvertimeAlarm;
import com.webleader.appms.bean.alarm.SpecialRegionAlarm;
import com.webleader.appms.bean.alarm.StaffAlarm;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.alarm.AlarmService;
import com.webleader.appms.util.Response;

/**
 * @className HistoryAlarm
 * @description 查询历史报警信息
 * @author ding
 * @date 2017年4月24日 下午6:28:29
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class HistoryAlarmControl {

	@Autowired
	private AlarmService alarmService;
	@Autowired
	private PageConstants pageConstants;

	@RequestMapping(value = "/history/alarm/type/{alarmType}/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getAlarmHistoryByCondition(@RequestBody Map<Object, Object> alarmCondition,
			@PathVariable int alarmType, @PathVariable int currentPage) {
		Response response = new Response();
		
//		Map<Object, Object> pageCondition = new HashMap<Object, Object>();
//		pageCondition.put("alarmInhandle", "0");
//		pageCondition.put("regionName", "");
//		pageCondition.put("alarmStartTime", alarmStartTime);
//		pageCondition.put("alarmEndTime", alarmEndTime);
//		pageCondition.put("pageBegin", pageConstants.getRecordNums(currentPage));
//		pageCondition.put("pageSize", pageConstants.getPageSize());
		
		alarmCondition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		alarmCondition.put("pageSize", pageConstants.getPageSize());
		
		if (Objects.nonNull(alarmCondition.get("startTime"))) {
			alarmCondition.put("alarmStartTime", Timestamp.valueOf(alarmCondition.get("startTime").toString()));
		}
		if (Objects.nonNull(alarmCondition.get("endTime"))) {
			alarmCondition.put("alarmEndTime", Timestamp.valueOf(alarmCondition.get("endTime").toString()));
		}
		
		try {
			/* 超时报警 */
			if (alarmType == 1) {
				List<OvertimeAlarm> overtimeAlarmList = alarmService.listOvertimeByPageCondition(alarmCondition);
				int overtimeAlarmNum = alarmService.countOvertimeByConditon(alarmCondition);
				if (Objects.isNull(overtimeAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", overtimeAlarmList).put("total", overtimeAlarmNum).toCombineResult();
			}
			
			/* 超员报警 */
			else if (alarmType == 2) {
				List<OvermanAlarm> overAlarmList = alarmService.listOvermanByPageCondition(alarmCondition);
				int overAlarmNum = alarmService.countOvermanByConditon(alarmCondition);
				if (Objects.isNull(overAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", overAlarmList).put("total", overAlarmNum).toCombineResult();
			}
			
			/* 限制区域报警 */
			else if (alarmType == 3) {
				List<SpecialRegionAlarm> specialRegionAlarmList = alarmService.listRegionAlarmByPageCondition(alarmCondition);
				int specialRegionAlarmNum = alarmService.countSpecialRegionAlarmByConditon(alarmCondition);
				if (Objects.isNull(specialRegionAlarmList)) {
					return response.failure("查询失败，请重试").toSimpleResult();
				}
				return response.success().put("alarmResult", specialRegionAlarmList).put("total", specialRegionAlarmNum).toCombineResult();
			}
			
			/* 员工呼叫报警 */
			else if (alarmType == 4) {
				List<StaffAlarm> staffAlarmList = alarmService.listStaffAlarmByPageCondition(alarmCondition);
				int staffAlarmNum = alarmService.countStaffAlarmByConditon(alarmCondition);
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

	// @RequestMapping(value = "/test/p/{currentPage}")
	// public void testParam(@RequestBody Map<Object, Object> map1,
	// @PathVariable int currentPage){
	// System.out.println("fdsfd");
	// System.out.println(currentPage);
	// System.out.println(map1);
	// }

}
