package com.webleader.appms.controller.system;

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

import com.webleader.appms.bean.system.TBUrl;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.system.TBUrlService;
import com.webleader.appms.util.Response;

/**
 * @className MenuControl
 * @description 菜单管理
 * @author HaoShaSha
 * @date 2017年5月2日 下午11:28:07
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class MenuControl {

	@Autowired
	private TBUrlService tbUrlService;
	@Autowired
	private PageConstants pageConstants;

	/** 
	 * @description 条件查询菜单信息
	 * @param moduleId
	 * @param moduleName
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/module/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getTBUrlListByCondition(@RequestBody Map<Object, Object> condition,@PathVariable int currentPage){
		Response response = new Response();
		List<TBUrl> urlList = null;
		int totalCounts = 0;
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		try {
			urlList = tbUrlService.getUrlByPageCondition(condition);
			totalCounts = tbUrlService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(urlList)) {
			return response.failure("查询菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("totalCounts", totalCounts).put("moduleList", urlList).toCombineResult();
	}
	
	/** 
	 * @description 通过点击菜单树，查询下级菜单
	 * @param upModuleId
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value= "/base/module/up/{upModuleId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getTBUrlByUpTBUrlId (@PathVariable String upModuleId, @PathVariable int currentPage) {
		Response response = new Response();
		Map<Object,Object> condition = new HashMap<Object, Object>();
		List<TBUrl> urlList = null;
		int totalCounts = 0;
		
		condition.put("upModuleId", upModuleId);
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			urlList = tbUrlService.getUrlByPageCondition(condition);
			totalCounts = tbUrlService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(urlList)) {
			return response.failure("查询菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("totalCounts", totalCounts).put("moduleList", urlList).toCombineResult();
	}
	
	/** 
	 * @description 点击添加时，查询得到下级菜单编号
	 * @param upModuleId
	 * @return 
	 */
	@RequestMapping(value = "/base/module/up/{upModuleId}", method = RequestMethod.GET)
	public Map<Object, Object> getNextId(@PathVariable String upModuleId){
		Response response = new Response();
		String currentTBUrlId = null;;
		try {
			currentTBUrlId = tbUrlService.getMaxTBUrlId(upModuleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(currentTBUrlId)) {
			return response.failure("不能得到下级菜单Id").toSimpleResult();
		}
		return response.success().put("currentModuleId", currentTBUrlId).toCombineResult();
	}
	
	/** 
	 * @description 查询菜单树
	 * @return 
	 */
	@RequestMapping(value = "/base/module/moduleTree", method = RequestMethod.GET)
	public Map<Object, Object> getTBUrlTree () {
		Response response = new Response();
		List<TBUrl> urlList = null;
		try {
			urlList = tbUrlService.getTBUrlTree(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(urlList)) {
			return response.failure("查询菜单树失败，请重试").toSimpleResult();
		}
		return response.success().put("moduleList", urlList).toCombineResult();
	}
	
	/** 
	 * @description 添加菜单
	 * @param tbUrl
	 * @return 
	 */
	@RequestMapping(value = "/base/module", method = RequestMethod.POST)
	public Map<Object, Object> addTBUrl(@RequestBody TBUrl tbUrl) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(tbUrl)) {
			return response.failure("添加菜单失败，请重试").toSimpleResult();
		}
		try {
			result = tbUrlService.insert(tbUrl);
		} catch (SQLException e) {
			e.printStackTrace();
			return response.failure("添加菜单失败，请重试").toSimpleResult();
		}
		
		if (result == 0) {
			return response.failure("添加菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过菜单编号批量删除菜单
	 * @param moduleId
	 * @return 
	 */
	@RequestMapping(value = "/base/module", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteTBUrl(@RequestParam(value = "moduleIds") String moduleIds) {
		Response response = new Response();
		boolean result = true;
		if (Objects.isNull(moduleIds)) {
			return response.failure("删除菜单失败，请重试").toSimpleResult();
		}
		List<String> moduleIdList = java.util.Arrays.asList(moduleIds.split(","));
		for(String moduleId:moduleIdList){
			try {
				result = result && tbUrlService.deleteByPrimaryKey(moduleId) >= 0 ? true : false;
				result = result && tbUrlService.deleteByUpTBUrlId(moduleId)>= 0 ? true : false;
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!result) {
			return response.failure("删除菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改菜单
	 * @param tbUrl
	 * @return 
	 */
	@RequestMapping(value = "/base/module", method = RequestMethod.PUT)
	public Map<Object, Object> updateTBUrl(@RequestBody TBUrl tbUrl) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(tbUrl)) {
			return response.failure("修改菜单失败，请重试").toSimpleResult();
		}
		try {
			result = tbUrlService.updateByPrimaryKeySelective(tbUrl);
			if(result!=0 && tbUrl.getInUse().equals("0")){
				Map<Object,Object> condition = new HashMap<Object,Object>();
				condition.put("inUse", tbUrl.getInUse());
				condition.put("upModuleId", tbUrl.getModuleId());
				result += tbUrlService.updateInUseByUpModuleId(condition);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 0) {
			return response.failure("修改菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
}
