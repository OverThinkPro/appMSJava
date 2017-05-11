package com.webleader.appms.controller.login;

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
	public Map<Object, Object> userLogin(@RequestBody Map<String, String> user) {
		Response response = new Response();
		String userName = user.get("userName");
		String password = user.get("password");
		User userInfo = null;
		
		if (Objects.isNull(userName) || Objects.isNull(password)) {
			return response.failure("用户名或密码不能为空").toSimpleResult();
		}
		
		try {
			userInfo = userService.getUserByUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(userInfo)) {
			return response.failure(ErrorMsg.USER_NOT_FOUND).toSimpleResult();
//			return response.failure("用户名错误，请重新输入").toSimpleResult();
		}
		if (!userInfo.getPassword().equals(password)) {
			return response.failure(ErrorMsg.USER_PASSWORD_ERROR).toSimpleResult();
		}
		userInfo.setPassword("");
		return response.success().put("user", userInfo).toCombineResult();
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
		
		try {
			urlList = tbUrlService.getUserUrl(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(urlList)) {
			return response.failure("查询菜单失败，请重试").toSimpleResult();
		}
		return response.success().put("menuList", urlList).toCombineResult();
	}
}
