package com.webleader.appms.controller.staff;

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

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.staff.Schedule;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.staff.ScheduleService;
import com.webleader.appms.util.Response;

/**
 * @className ScheduleControl
 * @description 班次管理
 * @author ding
 * @date 2017年5月8日 下午8:52:28
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class ScheduleControl {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private PageConstants pageConstants;
	
	/** 
	 * @description 条件查询，班次列表
	 * @param currentPage
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule/p/{currentPage}", method = RequestMethod.POST)
	@SystemLogController(opType="查询",opContent="条件查询班次列表")
	public Map<Object, Object> getScheduleListByCondition(@PathVariable int currentPage, 
			@RequestBody Map<Object, Object> condition) {
		Response response = new Response();
		List<Schedule> scheduleList = null;
		int total = 0;
		
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			scheduleList = scheduleService.getScheduleByPageCondition(condition);
			total = scheduleService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(scheduleList)) {
			return response.failure("查询班次失败，请重试").toSimpleResult();
		}
		return response.success().put("scheduleList", scheduleList).put("total", total).toCombineResult();
	}
	
	/** 
	 * @description 通过上级班次ID，查询下级所有班次信息
	 * @param upDutyId
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule/u/{upDutyId}", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="通过上级班次ID，查询下级所有班次信息")
	public Map<Object, Object> getScheduleByUpDutyId(@PathVariable String upDutyId) {
		Response response = new Response();
		List<Schedule> scheduleList = null;
		
		try {
			scheduleList = scheduleService.selectSchedule(upDutyId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(scheduleList)) {
			return response.failure("查询班次失败，请重试").toSimpleResult();
		}
		return response.success().put("scheduleList", scheduleList).toCombineResult();
	}
	
	/** 
	 * @description 通过dutyId查询当前班次信息
	 * @param dutyId
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule/{dutyId}", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="通过dutyId查询当前班次信息")
	public Map<Object, Object> getCurrentSchedule(@PathVariable String dutyId) {
		Response response = new Response();
		Schedule schedule = null;
		
		try {
			schedule = scheduleService.selectByPrimaryKey(dutyId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(schedule)) {
			return response.failure("查询班次失败，请重试").toSimpleResult();
		}
		return response.success().put("schedule", schedule).toCombineResult();
	}

	/** 
	 * @description 查询班次树
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule/tree", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="查询班次树")
	public Map<Object, Object> getScheduleTree() {
		Response response = new Response();
		List<Schedule> scheduleList = null;
		
		try {
			scheduleList = scheduleService.getScheduleTree();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(scheduleList)) {
			return response.failure("查询班次树失败，请重试").toSimpleResult();
		}
		return response.success().put("scheduleList", scheduleList).toCombineResult();
	}
	
	/** 
	 * @description 添加班次
	 * @param schedule
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule", method = RequestMethod.POST)
	@SystemLogController(opType="添加",opContent="添加一个新的班次信息")
	public Map<Object, Object> insertSchedule(@RequestBody Schedule schedule) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(schedule.getUpDutyId())) {
			schedule.setUpDutyId("1");
		}
		
		try {
			schedule.setDutyId(scheduleService.getMaxDutyId(schedule.getUpDutyId()));
			result = scheduleService.insert(schedule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(result)) {
			return response.failure("添加班次失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过班组ID，删除该班组
	 * @param dutyId
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule/{dutyId}", method = RequestMethod.DELETE)
	@SystemLogController(opType="删除",opContent="通过班组ID，删除该班组")
	public Map<Object, Object> deleteSchedule(@PathVariable String dutyId) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = scheduleService.deleteByPrimaryKey(dutyId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(result)) {
			return response.failure("删除班次失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 更新班次
	 * @param schedule
	 * @return 
	 */
	@RequestMapping(value = "/base/schedule", method = RequestMethod.PUT)
	@SystemLogController(opType="修改",opContent="更新班次信息")
	public Map<Object, Object> updateSchedule(@RequestBody Schedule schedule) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = scheduleService.updateByPrimaryKeySelective(schedule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(result)) {
			return response.failure("更新班次失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
