package com.webleader.appms.db.service.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.TBUrl;

/**
 * @className MenuService
 * @description 菜单
 * @author HaoShaSha
 * @date 2017年5月2日 下午11:31:26
 * @version 1.0.0
 */
public interface TBUrlService {

	/** 
	 * @description 组合条件分页查询菜单信息(菜单编号，菜单名称，上级菜单编号，是否启用， 起始记录数，每页的记录数)
	 * @param pageCondition(moduleId,moduleName,upModuleId,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUrlByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的菜单数量(菜单编号，菜单名称，上级菜单编号，是否启用)
	 * @param condition(moduleId,moduleName,upModuleId,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 通过userID，查询该用户，的菜单列表
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUserUrl(String userId) throws SQLException;
	
	/** 
	 * @description 根据上级菜单下的子菜单的最大编号
	 * @param upModuleId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxTBUrlId(String upModuleId) throws SQLException;
	
	/** 
	 * @description 查询菜单树
	 * @return upModuleId
	 * @throws SQLException 
	 */
	public List<TBUrl> getTBUrlTree(String upModuleId) throws SQLException;
	
	/** 
	 * @description 添加菜单
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int insert(TBUrl tbUrl) throws SQLException;
	
	/** 
	 * @description 根据菜单编号删除菜单
	 * @param moduleId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String moduleId) throws SQLException;
	
	/** 
	 * @description 根据上级菜单编号删除菜单
	 * @param upModuleId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpTBUrlId(String upModuleId) throws SQLException;
	
	/** 
	 * @description 更新菜单信息
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(TBUrl tbUrl) throws SQLException;
}
