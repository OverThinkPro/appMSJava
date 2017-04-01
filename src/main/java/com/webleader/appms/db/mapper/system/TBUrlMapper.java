package com.webleader.appms.db.mapper.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.TBUrl;

/**
 * @className TBUrlMapper
 * @description 数据库关于TBUrl的接口
 * @author HaoShaSha
 * @date 2017年3月31日 下午10:03:29
 * @version 1.0.0
 */
public interface TBUrlMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据菜单编号查询菜单信息
	 * @param moduleId 
	 * @return
	 * @throws SQLException 
	 */
	public TBUrl selectByPrimaryKey(String moduleId) throws SQLException;
	
	/** 
	 * @description 根据上级菜单编号查询子菜单
	 * @param upModuleId
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUrlByUpModuleId(String upModuleId) throws SQLException;
	
	/** 
	 * @description 查询一级菜单
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUrlTree() throws SQLException;
	
	/** 
	 * @description 组合条件分页查询菜单信息
	 * @param pageCondition(moduleId,moduleName,upModuleId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUrlByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的菜单数量
	 * @param pageCondition(moduleId,moduleName,upModuleId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 根据上级菜单下的子菜单的最大编号
	 * @param upModuleId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxUrlId(String upModuleId) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加菜单
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int insert(TBUrl tbUrl) throws SQLException;
	
	/** 
	 * @description 选择性的添加菜单（同insert）
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int insertSelective(TBUrl tbUrl) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
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
	public int deleteByUpModuleId(String upModuleId) throws SQLException;
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新菜单信息
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(TBUrl tbUrl) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}