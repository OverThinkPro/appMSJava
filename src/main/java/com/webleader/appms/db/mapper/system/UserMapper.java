package com.webleader.appms.db.mapper.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.User;

/**
 * @className UserMapper
 * @description 数据库关于User的接口
 * @author HaoShaSha
 * @date 2017年4月1日 下午8:40:16
 * @version 1.0.0
 */
public interface UserMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 验证用户是否存在(用于登陆)
	 * @param condition (userName, password)
	 * @return
	 * @throws SQLException 
	 */
	public User getUserForLogin(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 验证用户是否存在(用于修改密码)
	 * @param condition(userId, password)
	 * @return
	 * @throws SQLException 
	 */
	public User getUserForOldPwd(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 主键userId查询用户信息
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public User selectByPrimaryKey(String userId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询用户信息
	 * @param pageCondition(userId,userName,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<User> getUserByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的用户数量
	 * @param condition(userId,userName,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加用户
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int insert(User user) throws SQLException;
	
	/** 
	 * @description 选择性的添加用户（同insert）
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int insertSelective(User user) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据主键删除用户
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String userId) throws SQLException;
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新用户信息
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(User user) throws SQLException;
	
	
	/** 
	 * @description 修改用户密码(批量或者单个)
	 * @param condition(userId, password)
	 * @return
	 * @throws SQLException 
	 */
	public int updateUserPassword(Map<Object,Object> condition) throws SQLException;
	/*****************更新接口结束*******************/
	/************基本表数据库操作结束*******************/
	
	
	/*********关联表t_base_user_role操作开始**********/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 给用户分配角色
	 * @param data(userId, roleId)
	 * @return
	 * @throws SQLException 
	 */
	public int addRoleToUser(Map<Object, Object> data) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 撤销分配给用户的角色(全部或者单个角色)
	 * @param condition(userId, roleId)
	 * @return
	 * @throws SQLException 
	 */
	public int deleteRoleFromUser(Map<Object, Object> condition)throws SQLException;
	
	/*****************删除接口结束*******************/
	/*******关联表t_base_user_role操作结束***********/
	
						
	/*****************END BY HaoShaSha***********/
}