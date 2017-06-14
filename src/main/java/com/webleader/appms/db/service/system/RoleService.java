package com.webleader.appms.db.service.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.Role;


/**
 * @className RoleService
 * @description 角色
 * @author HaoShaSha
 * @date 2017年5月3日 上午12:21:18
 * @version 1.0.0
 */
public interface RoleService {
	
		
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
	 * @description 组合条件分页查询角色信息(角色编号，角色名称，是否启用， 起始记录数，每页的记录数)
	 * @param pageCondition(roleId,roleName,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Role> getRoleByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的角色数量(角色编号，角色名称，是否启用)
	 * @param pageCondition(roleId,roleName,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;

	/** 
	 * @description 添加角色
	 * @param role
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Role role) throws SQLException;

	/** 
	 * @description 根据角色编号删除角色
	 * @param roleId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String roleId) throws SQLException;
	
	/** 
	 * @description 更新角色信息
	 * @param role
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Role role) throws SQLException;

	/*********关联表t_base_role_module操作开始**********/
	/** 
	 * @description 根据角色编号查询该角色拥有的权限
	 * @param roleId
	 * @return list(moduleId,roleId)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> selectModulesByRoleId(String roleId) throws SQLException;
	/** 
	 * @description 给角色分配权限
	 * @param data(roleId, moduleId)
	 * @return
	 * @throws SQLException 
	 */
	public int addUrlToRole(Map<Object, Object> data) throws SQLException;
	
	/** 
	 * @description 撤销分配给角色的权限(全部或者单个权限)
	 * @param condition(roleId, moduleId)
	 * @return
	 * @throws SQLException 
	 */
	public int deleteUrlFromRole(Map<Object, Object> condition)throws SQLException;
	
	/*******关联表t_base_role_module操作结束***********/
	
}
