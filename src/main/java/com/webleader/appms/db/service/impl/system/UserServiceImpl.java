package com.webleader.appms.db.service.impl.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webleader.appms.bean.system.User;
import com.webleader.appms.db.mapper.system.UserMapper;
import com.webleader.appms.db.service.system.UserService;

/**
 * @className UserServiceImpl
 * @description 用户基本信息
 * @author HaoShaSha
 * @date 2017年4月24日 上午10:23:43
 * @version 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	/** 
	 * @description 查询出用户的信息(用户编号,用户名,密码,是否启用,创建时间,最近登录时间,备注,员工编号)
	 * @param map pageCondition(userId,userName,inUse,pageSize,pageBegin)
	 * @return List<User>
	 * @throws SQLException 
	 */
	@Override
	public List<User> getUserByPageCondition(Map<Object, Object> pageCondition)
			throws SQLException {
		if(Objects.isNull(pageCondition)){
			return null;
		}
		List<User> users = userMapper.getUserByPageCondition(pageCondition);
		return users;
	}

	/** 
	 * @description 统计符合条件的用户数量
	 * @param map pageCondition(userId,userName,inUse)
	 * @return int total
	 * @throws SQLException 
	 */
	@Override
	public int getCountByConditon(Map<Object, Object> condition)
			throws SQLException {
		return userMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 根据用户编号查询用户信息
	 * @param userId 
	 * @return
	 * @throws SQLException 
	 */
	public User selectByPrimaryKey(String userId) throws SQLException{
		if (Objects.isNull(userId)) {
			return null;
		}
		return userMapper.selectByPrimaryKey(userId);
	}
	
	/** 
	 * @description 通过用户名，查询用户是否存在
	 * @param condition
	 * @return
	 * @throws SQLException 
	 */
	public User getUserByUserName(String userName) throws SQLException {
		if (Objects.isNull(userName)) {
			return null;
		}
		return userMapper.getUserByUserName(userName);
	}
	
	/** 
	 * @description 添加用户
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int insert(User user) throws SQLException{
		if (Objects.isNull(user)) {
			return 0;
		}
		return userMapper.insert(user);
	}

	/** 
	 * @description 根据用户编号删除用户
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String userId) throws SQLException{
		if (Objects.isNull(userId)) {
			return 0;
		}
		return userMapper.deleteByPrimaryKey(userId);
	}
	
	/** 
	 * @description 更新用户信息
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(User user) throws SQLException{
		if (Objects.isNull(user)) {
			return 0;
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	/*********关联表t_base_user_role操作开始**********/
	/** 
	 * @description 根据用户编号查询该用户拥有的角色
	 * @param userId
	 * @return list(userId,roleId)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> selectRolesByUserId(String userId) throws SQLException {

		if (Objects.isNull(userId)) {
			return null;
		}
		return userMapper.selectRolesByUserId(userId);
	}
	/** 
	 * @description 给用户分配角色
	 * @param data(userId, roleId)
	 * @return
	 * @throws SQLException 
	 */
	public int addRoleToUser(Map<Object, Object> data) throws SQLException {
		if (Objects.isNull(data)) {
			return 0;
		}
		return userMapper.addRoleToUser(data);
	}
	
	/** 
	 * @description 撤销分配给用户的角色(全部或者单个角色)
	 * @param condition(userId, roleId)
	 * @return
	 * @throws SQLException 
	 */
	public int deleteRoleFromUser(Map<Object, Object> condition)throws SQLException {
		if (Objects.isNull(condition)) {
			return 0;
		}
		return userMapper.deleteRoleFromUser(condition);
	}
	
	/*****************删除接口结束*******************/
	/*******关联表t_base_user_role操作结束***********/
}
