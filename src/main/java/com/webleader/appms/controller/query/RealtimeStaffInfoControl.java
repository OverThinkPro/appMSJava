package com.webleader.appms.controller.query;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.positioning.TLStaff;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.positioning.TLStaffService;
import com.webleader.appms.util.Response;

/**
 * @className RealtimeStaffInfoControl
 * @description 实时查询员工信息
 * @author ding
 * @date 2017年4月25日 下午5:38:33
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class RealtimeStaffInfoControl {

	@Autowired
	private TLStaffService tlStaffService;
	@Autowired
	private PageConstants pageConstants;

	/** 
	 * @description 组合条件查询实时员工列表
	 * @param condition
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/realtime/staff/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getRealTimeStaffInfo(@RequestBody Map<Object, Object> condition,
			@PathVariable int currentPage) {
		List<TLStaff> tlStaffList = null;
		int totalCounts = 0;
		Response response = new Response();
		
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		condition.put("endTime", Timestamp.from(Instant.now()));
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			tlStaffList = tlStaffService.listRealStaffByPageCondition(condition);
			totalCounts = tlStaffService.countTotalStaffByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(tlStaffList)){
			return response.failure("实时查询员工信息失败，请重试").toSimpleResult();
		}
		return response.success().put("total", totalCounts).put("tlStaffList", tlStaffList).toCombineResult();
	}
	
	/** 
	 * @description 组合条件查询实时员工位置坐标
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/map/staff/count", method = RequestMethod.POST)
	public Map<Object, Object> getRealtimeStaffMap(@RequestBody Map<Object, Object> condition) {
		List<Map<Object, Object>> staffPointList = null;
		Response response = new Response();
		
		condition.put("startTime", Timestamp.valueOf("2017-04-14 18:32:14"));
		condition.put("endTime", Timestamp.from(Instant.now()));
		
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
}
