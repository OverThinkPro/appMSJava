package com.webleader.appms.controller.system;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.system.User;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.system.UserService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className UserControl
 * @description 查询出用户管理页面需要的信息
 * @author HaoShaSha
 * @date 2017年4月24日 上午10:44:29
 * @version 1.0.0
 */
@Controller
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class UserControl {

	@Autowired
	private UserService userService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 根据用户名查询用户是否存在（用于添加用户）
	 * @param userName
	 * @return false用户存在，true 用户不存在
	 */
	@RequestMapping(value = "/base/user/{userName}", method = RequestMethod.GET)
	public Map<Object, Object> getUserByUserName(@PathVariable String userName){
		Response response = new Response();
		boolean result = true;
		User user = null;
		try {
			user = userService.getUserByUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		if (Objects.isNull(user)) {
			result = true;
		}else{
			result = false;
		}
		return response.success().put("result", result).toCombineResult();
	}
	/**
	 * @description 查询用户基本信息
	 * @return List<User>
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/user/p/{currentPage}", method = RequestMethod.POST)
	@SystemLogController(opType="查询",opContent="查询用户列表信息")
	public Map<Object, Object> getUserListByCondition(@RequestBody Map<Object, Object> condition,@PathVariable int currentPage) {
		Response response = new Response();
		/* 查询条件 */
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		/* 查询用户基本信息 */
		List<User> userList = new ArrayList<User>();
		int totalCounts = 0;
		try {
			userList = userService.getUserByPageCondition(condition);
			totalCounts = userService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(userList)) {
			return response.failure("查询失败，请刷新界面").toSimpleResult();
		}
		return response.success().put("userList", userList).put("totalCounts", totalCounts)
				.toCombineResult();
	}
	
	/** 
	 * @description 添加用户
	 * @param user
	 * @return 
	 */
	@RequestMapping(value = "/base/user", method = RequestMethod.POST)
	@SystemLogController(opType="添加",opContent="添加了一个用户")   
	public Map<Object, Object> addUser (@RequestBody User user) {
		Response response = new Response();
		int result = 0;
		try {
			user.setUserId(uuidUtil.getUUID());
			System.out.println(user);
			result = userService.insert(user);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加用户失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过用户编号批量删除用户
	 * @param userId
	 * @return 
	 */
	
	@RequestMapping(value = "/base/user", method = RequestMethod.DELETE)
	@SystemLogController(opType="删除",opContent="删除单个/用户")  
	public Map<Object, Object> deleteUser (@RequestParam String userIds) {
		Response response = new Response();
		boolean result = true;
		List<String> userIdList = java.util.Arrays.asList(userIds.split(","));
		for(String userId:userIdList){
			try {
				result = result && userService.deleteByPrimaryKey(userId) >= 0 ? true : false;
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!result) {
			return response.failure("删除用户失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}

	/** 
	 * @description 更新用户信息
	 * @param user
	 * @return 
	 */
	@RequestMapping(value = "/base/user", method = RequestMethod.PUT)
	@SystemLogController(opType="更新",opContent="修改用户信息")  
	public Map<Object, Object> updateUser (@RequestBody User user) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = userService.updateByPrimaryKeySelective(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新用户失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 分配角色给用户
	 * @param user
	 * @return 
	 */
	@RequestMapping(value = "/base/user/role", method = RequestMethod.POST)
	@SystemLogController(opType="分配",opContent="为用户分配角色")
	public Map<Object, Object> addRoleToUser (@RequestBody Map<Object, Object> userAndRole) {
		Response response = new Response();
		boolean result = true;
		String userId = (String) userAndRole.get("userId");
		String roleIds = (String) userAndRole.get("roleIds");
		Map<Object, Object> condition = new HashMap<Object, Object>();
		condition.put("userId", userId);
		try {
			
			result = result && userService.deleteRoleFromUser(condition)>= 0 ? true : false;
			if(roleIds != ""){
				List<String> roleIdList = java.util.Arrays.asList(roleIds.split(","));
				for(String roleId:roleIdList){
					Map<Object, Object> data = new HashMap<Object, Object>();
					data.put("userId", userId);
					data.put("roleId", roleId);
					result = result && userService.addRoleToUser(data)> 0 ? true : false;
					
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if (!result) {
			return response.failure("用户分配角色失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
}