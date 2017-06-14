package com.webleader.appms.controller.system;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.system.Role;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.system.RoleService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className RoleControl
 * @description 查询出角色管理页面需要的信息
 * @author HaoShaSha
 * @date 2017年4月24日 上午10:44:29
 * @version 1.0.0
 */
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class RoleControl {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private Response response;
	@Autowired
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 根据角色名称查询角色信息(用于增加角色)
	 * @param dictionaryName
	 * @return 
	 */
	@RequestMapping(value = "/base/role/{roleName}", method = RequestMethod.GET)
	public Map<Object, Object> getRoleByRoleName(@PathVariable String roleName){
		Response response = new Response();
		boolean result = true;
		Role role = null;
		try {
			role = roleService.selectRoleByRoleName(roleName);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		if (Objects.isNull(role)) {
			result = true;
		}else{
			result = false;
		}
		return response.success().put("result", result).toCombineResult();
		
	}
	
	/**
	 * @description 根据条件查询角色基本信息
	 * @return List<Role>
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/role/p/{currentPage}", method = RequestMethod.POST)
	@SystemLogController(opType="查询",opContent="查询角色列表信息")
	public Map<Object, Object> getRoleListByCondition(@RequestBody Map<Object, Object> condition,@PathVariable int currentPage) {
		/* 查询条件 */
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		/* 查询角色基本信息 */
		List<Role> roleList = new ArrayList<Role>();
		int totalCounts = 0;
		try {
			roleList = roleService.getRoleByPageCondition(condition);
			totalCounts = roleService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(roleList)) {
			return response.failure("查询失败，请刷新界面").toSimpleResult();
		}
		return response.success().put("roleList", roleList).put("totalCounts", totalCounts)
				.toCombineResult();
	}
	
	
	/** 
	 * @description 添加角色
	 * @param role
	 * @return 
	 */
	@RequestMapping(value = "/base/role", method = RequestMethod.POST)
	@SystemLogController(opType="添加",opContent="添加一个新的角色")
	public Map<Object, Object> addRole (@RequestBody Role role) {
		Response response = new Response();
		int result = 0;
		try {
			role.setRoleId(uuidUtil.getUUID());
			System.out.println(role);
			result = roleService.insert(role);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加角色失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过角色编号批量删除角色
	 * @param roleId
	 * @return 
	 */
	@RequestMapping(value = "/base/role", method = RequestMethod.DELETE)
	@SystemLogController(opType="删除",opContent="删除角色列表信息")
	public Map<Object, Object> deleteRole (@RequestParam String roleIds) {
		Response response = new Response();
		boolean result = true;
		List<String> roleIdList = java.util.Arrays.asList(roleIds.split(","));
		for(String roleId:roleIdList){
			try {
				result = result && roleService.deleteByPrimaryKey(roleId) >= 0 ? true : false;
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!result) {
			return response.failure("删除角色失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}

	/** 
	 * @description 更新角色信息
	 * @param role
	 * @return 
	 */
	@RequestMapping(value = "/base/role", method = RequestMethod.PUT)
	@SystemLogController(opType="修改",opContent="修改角色信息")
	public Map<Object, Object> updateRole (@RequestBody Role role) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = roleService.updateByPrimaryKeySelective(role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新角色失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 为角色分配权限
	 * @param role
	 * @return 
	 */
	@RequestMapping(value = "/base/role/module", method = RequestMethod.POST)
	@SystemLogController(opType="分配",opContent="为角色分配权限")
	public Map<Object, Object> addModuleToRole (@RequestBody Map<Object, Object> roleAndModule) {
		Response response = new Response();
		boolean result = true;
		String roleId = (String) roleAndModule.get("roleId");
		String moduleIds = (String) roleAndModule.get("moduleIds");
		Map<Object, Object> condition = new HashMap<Object, Object>();
		condition.put("roleId", roleId);
		try {
			
			result = result && roleService.deleteUrlFromRole(condition)>= 0 ? true : false;
			if(moduleIds != ""){
				List<String> moduleIdList = java.util.Arrays.asList(moduleIds.split(","));
				for(String moduleId:moduleIdList){
					Map<Object, Object> data = new HashMap<Object, Object>();
					data.put("roleId", roleId);
					data.put("moduleId", moduleId);
					result = result && roleService.addUrlToRole(data)> 0 ? true : false;
					
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if (!result) {
			return response.failure("角色分配角色失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	
	/** 
	 * @description 查询所有的角色，用于分配角色
	 * @return 
	 */
	@RequestMapping(value = "/base/role/", method = RequestMethod.GET)
	public Map<Object, Object> getAllRole() {
		List<Role> roleList = new ArrayList<Role>();
		int totalCounts = 0;
		try {
			roleList = roleService.getRoleByPageCondition(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(roleList)) {
			return response.failure("查询失败，请刷新界面").toSimpleResult();
		}
		return response.success().put("roleList", roleList).put("totalCounts", totalCounts)
				.toCombineResult();
	}
	
	/**
	 * @description 查询该角色拥有的权限
	 * @return List<Role>
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/role/module/{roleId}", method = RequestMethod.GET)
	public Map<Object, Object> getModulesByRoleId(@PathVariable String roleId) {
		List<Map<Object,Object>> modulesOfRole = new ArrayList<Map<Object,Object>>();
		try {
			modulesOfRole = roleService.selectModulesByRoleId(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(modulesOfRole)) {
			return response.failure("查询失败，请刷新界面").toSimpleResult();
		}
		return response.success().put("moduleListOfRole", modulesOfRole).toCombineResult();
	}
}