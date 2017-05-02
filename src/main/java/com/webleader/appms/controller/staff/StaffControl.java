package com.webleader.appms.controller.staff;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.staff.Staff;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.staff.StaffService;
import com.webleader.appms.util.Response;

/**
 * @className StaffControl
 * @description 员工管理
 * @author ding
 * @date 2017年4月26日 下午5:15:57
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class StaffControl {

	@Autowired
	private StaffService staffService;
	@Autowired
	private PageConstants pageConstants;

	/** 
	 * @description 分页条件查询，员工信息列表
	 * @param currentPage
	 * @param unitId
	 * @param staffName
	 * @param staffId
	 * @param jobId
	 * @return 
	 */
	@RequestMapping(value = "/base/staff/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getStaffListByCondition(@PathVariable int currentPage,
			@RequestParam(required = false) String unitId, @RequestParam(required = false) String staffName,
			@RequestParam(required = false) String staffId, @RequestParam(required = false) String jobId) {
		Response response = new Response();
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		List<Staff> staffList = null;
		int totalPage = 0;
		
		if (Objects.nonNull(unitId) && !unitId.equals("")) {
			pageCondition.put("unitId", unitId);
		}
		if (Objects.nonNull(staffName) && !staffName.equals("")) {
			pageCondition.put("staffName", staffName);
		}
		if (Objects.nonNull(staffId) && !staffId.equals("")) {
			pageCondition.put("staffId", staffId);
		}
		if (Objects.nonNull(jobId) && !jobId.equals("")) {
			pageCondition.put("jobId", jobId);
		}
		pageCondition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		pageCondition.put("pageSize", pageConstants.getPageSize());

		try {
			staffList = staffService.getStaffByPageCondition(pageCondition);
			totalPage = staffService.getCountByConditon(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(staffList)) {
			return response.failure("查询员工失败，请重试").toSimpleResult();
		}
		return response.success().put("staffList", staffList).put("total", totalPage).toCombineResult();
	}
	
	/** 
	 * @description 通过点击部门树，查询该部门下的所有员工
	 * @param unitId
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/staff/u/{unitId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getStaffListByUnitId (@PathVariable String unitId, @PathVariable int currentPage) {
		Response response = new Response();
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		List<Staff> staffList = null;
		int totalPage = 0;
		
		pageCondition.put("unitId", unitId);
		pageCondition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		pageCondition.put("pageSize", pageConstants.getPageSize());

		try {
			staffList = staffService.getStaffByPageCondition(pageCondition);
			totalPage = staffService.getCountByConditon(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(staffList)) {
			return response.failure("查询员工失败，请重试").toSimpleResult();
		}
		return response.success().put("staffList", staffList).put("total", totalPage).toCombineResult();
	}
	
	/** 
	 * @description 添加一个员工信息
	 * @param staff
	 * @return 
	 */
	@RequestMapping(value = "/base/staff", method = RequestMethod.POST)
	public Map<Object, Object> addStaff (@RequestBody Staff staff) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = staffService.insert(staff);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加员工失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过员工id,删除员工
	 * @param staffId
	 * @return 
	 */
	@RequestMapping(value = "/base/staff", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteStaff (@RequestParam String staffId) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = staffService.deleteByPrimaryKey(staffId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("删除员工失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改员工信息
	 * @param staff
	 * @return 
	 */
	@RequestMapping(value = "/base/staff", method = RequestMethod.PUT)
	public Map<Object, Object> updateStaff (@RequestBody Staff staff) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = staffService.updateByPrimaryKeySelective(staff);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("修改员工失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
