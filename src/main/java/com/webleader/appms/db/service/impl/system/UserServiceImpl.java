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
}
