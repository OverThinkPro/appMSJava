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
}
