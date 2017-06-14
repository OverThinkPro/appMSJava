package com.webleader.appms.controller.login;

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
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.annotation.SystemLogAspect;
import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.system.TBUrl;
import com.webleader.appms.bean.system.User;
import com.webleader.appms.db.service.system.TBUrlService;
import com.webleader.appms.db.service.system.UserService;
import com.webleader.appms.util.ErrorMsg;
import com.webleader.appms.util.Response;

/**
 * @className UserLoginControl
 * @description 用户登陆
 * @author ding
 * @date 2017年5月11日 上午10:05:58
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class UserLoginControl {

	@Autowired
	private UserService userService;
	@Autowired
	private TBUrlService tbUrlService;
	
	/** 
	 * @description 用户登陆
	 * @param user
	 * @return 
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@SystemLogController(opType="登录",opContent="用户登录系统")
	public Map<Object, Object> userLogin(@RequestBody Map<String, String> user) {
		Response response = new Response();
		String userName = user.get("userName");
		String password = user.get("password");
		User userInfo = null;
		int isConstantsHome = 0;
		
		if (Objects.isNull(userName) || Objects.isNull(password)) {
			return response.failure("用户名或密码不能为空").toSimpleResult();
		}
		
		try {
			userInfo = userService.getUserByUserName(userName);
			if (Objects.nonNull(userInfo)) {
				isConstantsHome = tbUrlService.isContainsHomePage(userInfo.getUserId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(userInfo)) {
			return response.failure(ErrorMsg.USER_NOT_FOUND).toSimpleResult();
		}
		if (!userInfo.getPassword().equals(password)) {
			return response.failure(ErrorMsg.USER_PASSWORD_ERROR).toSimpleResult();
		}
		userInfo.setPassword("");
		
		SystemLogAspect.user = userInfo;
		
		return response.success().put("user", userInfo).put("isHome", isConstantsHome).toCombineResult();
	}
	
	/** 
	 * @description 通过userId，查询用户可见的菜单列表
	 * @param userId
	 * @return 
	 */
	@RequestMapping(value = "/user/url/{userId}", method = RequestMethod.GET)
	public Map<Object, Object> getUserUrlList(@PathVariable String userId) {
		Response response = new Response();
		List<TBUrl> urlList = null;
		List<String> urlOnly = null;
		Map<String, Object> convert = null;
		
		try {
			urlList = tbUrlService.getUserUrl(userId);
			urlOnly = tbUrlService.getUserURLOnly(userId);
			
			convert = convertMenuList(urlOnly);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(urlList) || Objects.isNull(urlOnly)) {
			return response.failure("查询菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("menuList", urlList).put("urlOnly", convert).toCombineResult();
	}
	
	private Map<String, Object> convertMenuList(List<String> urlOnly) {
		Map<String, Object> convert = new HashMap<String, Object>();
		
		for (int i = 0; i < urlOnly.size(); i++) {
			String url = urlOnly.get(i);
			
			if (!"/".equals(url)) {
				convert.put(urlOnly.get(i), true);
			}
		}
		return convert;
	}
}
