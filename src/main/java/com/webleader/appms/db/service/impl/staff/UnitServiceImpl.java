package com.webleader.appms.db.service.impl.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.staff.Unit;
import com.webleader.appms.db.mapper.staff.UnitMapper;
import com.webleader.appms.db.service.staff.UnitService;

/**
 * @className UnitServiceImpl
 * @description 部门服务层
 * @author ding
 * @date 2017年4月24日 下午9:12:38
 * @version 1.0.0
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitMapper unitMapper;
	
	/** 
	 * @description 组合条件分页查询部门信息(部门编号，部门名称，上级部门编号， 起始记录数，每页的记录数)
	 * @param pageCondition(unitId,unitName,upUnitId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Unit> getUnitByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return unitMapper.getUnitByPageCondition(pageCondition);
	}
}
