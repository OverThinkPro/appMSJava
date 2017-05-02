package com.webleader.appms.db.mapper.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.Unit;

/**
 * @className UnitMapper
 * @description 数据库关于Unit的接口
 * @author HaoShaSha
 * @date 2017年4月14日 下午11:24:17
 * @version 1.0.0
 */
public interface UnitMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据部门编号查询部门信息
	 * @param unitId 
	 * @return
	 * @throws SQLException 
	 */
	public Unit selectByPrimaryKey(String unitId) throws SQLException;
	
	/** 
	 * @description 根据上级部门编号查询子部门
	 * @param upUnitId
	 * @return
	 * @throws SQLException 
	 */
	public List<Unit> getUnitByUpUnitId(String upUnitId) throws SQLException;
	
	/** 
	 * @description 查询部门树
	 * @return
	 * @throws SQLException 
	 */
	public List<Unit> getUnitTree() throws SQLException;
	
	/** 
	 * @description 组合条件分页查询部门信息(部门编号，部门名称，上级部门编号， 起始记录数，每页的记录数)
	 * @param pageCondition(unitId,unitName,upUnitId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Unit> getUnitByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的部门数量(部门编号，部门名称 或者上级部门编号)
	 * @param condition(unitId,unitName,upUnitId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 根据上级部门下的子部门的最大编号
	 * @param upUnitId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxUnitId(String upUnitId) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加部门
	 * @param unit
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Unit unit) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据部门编号删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String unitId) throws SQLException;
	
	/** 
	 * @description 根据上级部门编号删除部门
	 * @param upUnitId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpUnitId(String upUnitId) throws SQLException;
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新部门信息
	 * @param unit
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Unit unit) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}