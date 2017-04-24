package com.webleader.appms.db.service.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.User;

/**
 * @className UserService
 * @description 用户基本信息
 * @author HaoShaSha
 * @date 2017年4月24日 上午10:24:10
 * @version 1.0.0
 */
public interface UserService {

	/** 
	 * @description 查询出用户的信息(用户编号,用户名,密码,是否启用,创建时间,最近登录时间,备注,员工编号)
	 * @param map pageCondition(userId,userName,inUse,pageSize,pageBegin)
	 * @return List<User>
	 * @throws SQLException 
	 */
	public List<User> getUserByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的用户数量
	 * @param map pageCondition(userId,userName,inUse)
	 * @return int total
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	
}
