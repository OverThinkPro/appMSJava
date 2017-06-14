package com.webleader.appms.db.mapper.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.Role;

/**
 * @className RoleMapper
 * @description 数据库关于Role的接口
 * @author HaoShaSha
 * @date 2017年4月1日 下午10:35:02
 * @version 1.0.0
 */
public interface RoleMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据角色编号查询角色信息
	 * @param roleId 
	 * @return
	 * @throws SQLException 
	 */
	public Role selectByPrimaryKey(String roleId) throws SQLException;
	
	/** 
	 * @description 根据角色名称查询角色信息
	 * @param roleName 
	 * @return
	 * @throws SQLException 
	 */
	public Role selectRoleByRoleName(String roleName) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询角色信息
	 * @param pageCondition(roleId,roleName,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Role> getRoleByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的角色数量
	 * @param condition(roleId,roleName,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加角色
	 * @param role
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Role role) throws SQLException;
	
	/** 
	 * @description 选择性的添加角色（同insert）
	 * @param role
	 * @return
	 * @throws SQLException 
	 */
	public int insertSelective(Role role) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据角色编号删除角色
	 * @param roleId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String roleId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新角色信息
	 * @param role
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Role role) throws SQLException;
	
	/*****************更新接口结束*******************/
	
	/*********关联表t_base_role_module操作开始**********/

	/*****************查询接口开始*******************/
	/** 
	 * @description 根据角色编号查询该角色拥有的权限
	 * @param roleId
	 * @return list(moduleId,roleId)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> selectModulesByRoleId(String roleId) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 给角色分配权限
	 * @param data(roleId, moduleId)
	 * @return
	 * @throws SQLException 
	 */
	public int addUrlToRole(Map<Object, Object> data) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 撤销分配给角色的权限(全部或者单个权限)
	 * @param condition(roleId, moduleId)
	 * @return
	 * @throws SQLException 
	 */
	public int deleteUrlFromRole(Map<Object, Object> condition)throws SQLException;
	
	/*****************删除接口结束*******************/
	/*******关联表t_base_role_module操作结束***********/
	
	/*****************END BY HaoShaSha***********/
}