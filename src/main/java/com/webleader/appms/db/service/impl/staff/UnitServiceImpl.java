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
	
	/** 
	 * @description 统计符合条件的部门数量(部门编号，部门名称 或者上级部门编号)
	 * @param condition(unitId,unitName,upUnitId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return 0;
		}
		return unitMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 根据上级部门下的子部门的最大编号
	 * @param upUnitId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxUnitId(String upUnitId) throws SQLException{
		if (Objects.isNull(upUnitId)) {
			return null;
		}
		String maxId = unitMapper.getMaxUnitId(upUnitId);
		if (Objects.isNull(maxId)){
			return upUnitId + "001";
		} else {
			return Integer.valueOf(maxId) + 1 + "";
		}
	}
	
	/** 
	 * @description 查询部门树
	 * @return
	 * @throws SQLException 
	 */
	public List<Unit> getUnitTree() throws SQLException{
		return unitMapper.getUnitTree();
	}
	
	/** 
	 * @description 添加部门
	 * @param unit
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Unit unit) throws SQLException{
		if (Objects.isNull(unit)) {
			return 0;
		}
		return unitMapper.insert(unit);
	}
	
	/** 
	 * @description 根据部门编号删除部门
	 * @param unitId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String unitId) throws SQLException{
		if (Objects.isNull(unitId)) {
			return 0;
		}
		return unitMapper.deleteByPrimaryKey(unitId);
	}
	
	/** 
	 * @description 根据上级部门编号删除部门
	 * @param upUnitId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpUnitId(String upUnitId) throws SQLException{
		if (Objects.isNull(upUnitId)) {
			return 0;
		}
		return unitMapper.deleteByUpUnitId(upUnitId);
	}
	
	/** 
	 * @description 更新部门信息
	 * @param unit
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Unit unit) throws SQLException{
		if (Objects.isNull(unit)) {
			return 0;
		}
		return unitMapper.updateByPrimaryKeySelective(unit);
	}
}
