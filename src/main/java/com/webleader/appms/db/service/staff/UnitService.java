package com.webleader.appms.db.service.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.Unit;

/**
 * @className UnitService
 * @description 部门
 * @author ding
 * @date 2017年4月24日 下午9:12:23
 * @version 1.0.0
 */
public interface UnitService {

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
	
	/** 
	 * @description 添加部门
	 * @param unit
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Unit unit) throws SQLException;
	
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
	
	/** 
	 * @description 更新部门信息
	 * @param unit
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Unit unit) throws SQLException;
}
