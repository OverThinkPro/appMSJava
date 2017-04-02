package com.webleader.appms.system;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.system.User;
import com.webleader.appms.db.mapper.system.UserMapper;

/**
 * @className UserTest
 * @description 测试数据库接口 UserMapper
 * @author HaoShaSha
 * @date 2017年4月1日 下午8:53:03
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
	
	@Autowired
	private UserMapper userMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 验证用户是否存在(用于登陆)
	 */
	@Test
	public void getUserForLogin(){
		String userName = "hss";
		String password = "12345";
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("userName", userName);
		condition.put("password", password);
		try {
			User user = userMapper.getUserForLogin(condition);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 验证用户是否存在(用于修改密码)
	 */
	@Test
	public void getUserForOldPwd(){
		String userId = "a";
		String password = "12345";
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("userId", userId);
		condition.put("password", password);
		try {
			User user = userMapper.getUserForOldPwd(condition);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 主键userId查询用户信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String userId = "a";
		try {
			User user = userMapper.selectByPrimaryKey(userId);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @description 组合条件分页查询用户信息
	 */
	@Test
	public void getUserByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("userName", "hss");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<User> users = userMapper.getUserByPageCondition(pageCondition);
			System.out.println(users.size());
			System.out.println(users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的用户数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("inUse", "1");
		try {
			int totalCount = userMapper.getCountByConditon(pageCondition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加用户
	 */
	@Test
	public void insert(){
		User user = new User();
		user.setUserId("1000001");
		user.setUserName("hss");
		user.setPassword("1212121");
		user.setInUse("1");
		user.setCreateTime(Timestamp.valueOf("2014-09-09 12:11:11"));
		user.setLastLoginTime(Timestamp.valueOf("2014-09-09 12:11:11"));
		try {
			int count = userMapper.insert(user);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	/** 
	 * @description 选择性的添加用户（同insert）
	 */
	@Test
	public void insertSelective(){
		User user = new User();
		user.setUserId("1000003");
		user.setUserName("hss");
		user.setPassword("1212121");
		user.setInUse("1");
		user.setCreateTime(Timestamp.valueOf("2014-09-09 12:11:11"));
		user.setLastLoginTime(Timestamp.valueOf("2014-09-09 12:11:11"));
		try {
			int count = userMapper.insert(user);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据用户编号删除用户
	 */
	@Test
	public void deleteByPrimaryKey(){
		String userId = "1000003";
		try {
			int count = userMapper.deleteByPrimaryKey(userId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新用户信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		User user = new User();
		user.setUserId("1000002");
		user.setUserName("hss");
		user.setPassword("12121211");
		user.setInUse("1");
		user.setCreateTime(Timestamp.valueOf("2014-09-12 12:11:11"));
		user.setLastLoginTime(Timestamp.valueOf("2014-09-12 12:11:11"));
		try {
			int count = userMapper.updateByPrimaryKeySelective(user);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 修改用户密码(批量或者单个)
	 */
	@Test
	public void updateUserPassword(){
		Map<Object, Object> condition = new HashMap<Object, Object>();
		condition.put("userId", "");
		condition.put("password", "hss");
		try {
			int count = userMapper.updateUserPassword(condition);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*****************更新接口结束*******************/
	
	/*********关联表t_base_user_role操作开始**********/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 给用户分配角色
	 */
	@Test
	public void addRoleToUser(){
		Map<Object, Object> data = new HashMap<Object, Object>();
		data.put("userId", "1000002");
		data.put("roleId", "10001");
		try {
			int count = userMapper.addRoleToUser(data);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 撤销分配给用户的角色(全部或者单个角色)
	 */
	@Test
	public void deleteRoleFromUser(){
		Map<Object, Object> condition = new HashMap<Object, Object>();
		condition.put("userId", "1000002");
		condition.put("roleId", "10001");
		try {
			int count = userMapper.deleteRoleFromUser(condition);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*****************删除接口结束*******************/
	/*******关联表t_base_user_role操作结束***********/
	
	/*****************END BY HaoShaSha***********/
}