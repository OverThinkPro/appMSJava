package com.webleader.appms.db.mapper.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.TLStaff;

/**
 * @className TLStaffMapper
 * @description 数据库关于TLStaff的接口
 * @author HaoShaSha
 * @date 2017年4月13日 下午6:12:12
 * @version 1.0.0
 */
public interface TLStaffMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 实时统计井下各个班组的员工数量
	 * @param condition(startTime,endTime)
	 * @return(total,unitId,unitName)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> countRealStaffByUnit(Map<Object,Object> condition)throws SQLException;
	
	/** 
	 * @description 根据部门编号实时统计井下某一个部门的员工数量
	 * @param condition(unitId,startTime,endTime)
	 * @return(total,unitId,unitName)
	 * @throws SQLException 
	 */
	public Map<Object,Object> countRealStaffByUnitId(Map<Object,Object> condition)throws SQLException;

	/** 
	 * @description 实时统计井下各个区域的员工数量
	 * @param condition(startTime,endTime)
	 * @return(total,regionId,regionName)
	 * @throws SQLException 
	 */
	public List<Map<Object,Object>> countRealStaffByRegion(Map<Object,Object> condition)throws SQLException;
	
	/** 
	 * @description 查询出当前的所有区域总数
	 * @return int
	 * @throws SQLException
	 * @author ding 
	 */
	public int countAllRegion(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 根据区域编号实时统计井下某一个区域的员工数量
	 * @param condition(regionId,startTime,endTime)
	 * @return(total,regionId,regionName)
	 * @throws SQLException 
	 */
	public Map<Object,Object> countRealStaffByRegionId(Map<Object,Object> condition)throws SQLException;

	/** 
	 * @description 组合条件分页查询实时员工位置信息(部门编号，区域编号，分站编号，员工编号，员工姓名，定位卡号，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param condition(unitId,regionId,readerId,staffId,staffName,cardId,startTime,endTime,pageSize,pageBegin)
	 * @return List<TLStaff>
	 * @throws SQLException 
	 */
	public List<TLStaff> listRealStaffByPageCondition(Map<Object,Object> condition) throws SQLException;
    
	/** 
	 * @description 实时统计符合条件的实时员工的数量(部门编号，区域编号，分站编号，员工编号，员工姓名，定位卡号，开始时间，结束时间)
	 * @param condition(unitId,regionId,readerId,staffId,staffName,cardId,startTime,endTime)
	 * @return List<TLStaff>
	 * @throws SQLException 
	 */
	public int countTotalStaffByConditon(Map<Object,Object> condition) throws SQLException;
    
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/

}