package com.webleader.appms.db.service.impl.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.staff.Staff;
import com.webleader.appms.db.mapper.staff.StaffMapper;
import com.webleader.appms.db.service.staff.StaffService;

/**
 * @className StaffServiceImpl
 * @description 员工服务层实现
 * @author ding
 * @date 2017年5月1日 下午4:43:07
 * @version 1.0.0
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffMapper staffMapper;
	
	/** 
	 * @description 根据员工编号查询员工信息
	 * @param staffId 
	 * @return
	 * @throws SQLException 
	 */
	public Staff selectByPrimaryKey(String staffId) throws SQLException{
		if (Objects.isNull(staffId)) {
			return null;
		}
		return staffMapper.selectByPrimaryKey(staffId);
	}
	
	/** 
	 * @description 组合条件分页查询员工信息(员工编号，员工名称，员工简称，工种编号，部门编号， 起始记录数，每页的记录数)
	 * @param pageCondition(staffId,staffName,staffAbbr,unitId,jobId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Staff> getStaffByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return staffMapper.getStaffByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的员工数量(员工编号，员工名称，员工简称，工种编号，部门编号)
	 * @param pageCondition(staffId,staffName,staffAbbr,unitId,jobId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return staffMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 添加员工
	 * @param staff
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Staff staff) throws SQLException{
		if (Objects.isNull(staff)) {
			return 0;
		}
		return staffMapper.insert(staff);
	}
	
	/** 
	 * @description 根据员工编号删除员工
	 * @param staffId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String staffId) throws SQLException{
		if (Objects.isNull(staffId)) {
			return 0;
		}
		return staffMapper.deleteByPrimaryKey(staffId);
	}
	
	/** 
	 * @description 更新员工信息
	 * @param staff
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Staff staff) throws SQLException{
		if (Objects.isNull(staff)) {
			return 0;
		}
		return staffMapper.updateByPrimaryKeySelective(staff);
	}

}
