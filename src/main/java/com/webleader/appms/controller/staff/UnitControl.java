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

import com.webleader.appms.bean.staff.Unit;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.staff.UnitService;
import com.webleader.appms.util.Response;

/**
 * @className DepartmentControl
 * @description 部门管理
 * @author ding
 * @date 2017年4月26日 下午5:15:41
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class UnitControl {

	@Autowired
	private UnitService unitService;
	@Autowired
	private PageConstants pageConstants;

	/** 
	 * @description 条件查询部门信息
	 * @param unitId
	 * @param unitName
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/unit/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getUnitListByCondition(@RequestParam(value = "unitId", required = false) String unitId, 
			@RequestParam(value = "unitName", required = false) String unitName, @PathVariable int currentPage){
		Response response = new Response();
		Map<Object,Object> condition = new HashMap<Object, Object>();
		List<Unit> unitList = null;
		int totalPage = 0;
		
		if (Objects.nonNull(unitId) && !unitId.equals("")) {
			condition.put("unitId", unitId);
		}
		if (Objects.nonNull(unitName) && !unitName.equals("")){
			condition.put("unitName", unitName);
		}
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			unitList = unitService.getUnitByPageCondition(condition);
			totalPage = unitService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(unitList)) {
			return response.failure("查询部门失败，请重试").toSimpleResult();
		}
		return response.success().put("total", totalPage).put("unitList", unitList).toCombineResult();
	}
	
	/** 
	 * @description 添加部门
	 * @param unit
	 * @return 
	 */
	@RequestMapping(value = "/base/unit", method = RequestMethod.POST)
	public Map<Object, Object> addUnit(@RequestBody Unit unit) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(unit)) {
			return response.failure("添加部门失败，请重试").toSimpleResult();
		}
		try {
			result = unitService.insert(unit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			return response.failure("添加部门失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 删除部门
	 * @param unitId
	 * @return 
	 */
	@RequestMapping(value = "/base/unit", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteUnit(@RequestParam(value = "unitId") String unitId) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(unitId)) {
			return response.failure("删除部门失败，请重试").toSimpleResult();
		}
		try {
			result = unitService.deleteByPrimaryKey(unitId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			return response.failure("删除部门失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改部门
	 * @param unit
	 * @return 
	 */
	@RequestMapping(value = "/base/unit", method = RequestMethod.PUT)
	public Map<Object, Object> updateUnit(@RequestBody Unit unit) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(unit)) {
			return response.failure("修改部门失败，请重试").toSimpleResult();
		}
		try {
			result = unitService.updateByPrimaryKeySelective(unit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			return response.failure("修改部门失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
}
