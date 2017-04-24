package com.webleader.appms.controller.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.system.User;
import com.webleader.appms.common.ModalPageConstants;
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
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class UserControl {

	@Autowired
	private UserService userService;
	@Autowired
	private ModalPageConstants modalPageConstants;
	@Autowired
	private Response response;
	@Autowired
	private UUIDUtil uuidUtil;

	/**
	 * @description 查询用户基本信息
	 * @return List<User>
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/user/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getUserInfo(@PathVariable int currentPage) {
		/* 查询条件 */
		Map<Object, Object> condition = new HashMap<Object, Object>();
		condition.put("pageBegin", modalPageConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalPageConstants.getPageSize());
		/* 查询用户基本信息 */
		List<User> userList = new ArrayList<User>();
		int countTotalPages = 0;
		try {
			userList = userService.getUserByPageCondition(condition);
			countTotalPages = modalPageConstants.getPages(userService.getCountByConditon(condition));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(userList)) {
			return response.failure("查询失败，请刷新界面").toSimpleResult();
		}
		return response.success().put("userList", userList).put("countTotalPages", countTotalPages)
				.toCombineResult();
	}

}