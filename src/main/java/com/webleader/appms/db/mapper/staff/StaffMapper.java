package com.webleader.appms.db.mapper.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.Staff;

/**
 * @className StaffMapper
 * @description 数据库关于Staff的接口
 * @author HaoShaSha
 * @date 2017年4月15日 上午1:48:58
 * @version 1.0.0
 */
public interface StaffMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据员工编号查询员工信息
	 * @param staffId 
	 * @return
	 * @throws SQLException 
	 */
	public Staff selectByPrimaryKey(String staffId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询员工信息(员工编号，员工名称，员工简称，工种编号，部门编号， 起始记录数，每页的记录数)
	 * @param pageCondition(staffId,staffName,staffAbbr,unitId,jobId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Staff> getStaffByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的员工数量(员工编号，员工名称，员工简称，工种编号，部门编号)
	 * @param pageCondition(staffId,staffName,staffAbbr,unitId,jobId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加员工
	 * @param staff
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Staff staff) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据员工编号删除员工
	 * @param staffId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String staffId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新员工信息
	 * @param staff
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Staff staff) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}