package com.webleader.appms.staff;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.staff.Staff;
import com.webleader.appms.db.mapper.staff.StaffMapper;

/**
 * @className StaffTest
 * @description 测试数据库接口 StaffMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午4:19:51
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StaffTest {
	
	@Autowired
	private StaffMapper staffMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据员工编号查询员工信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String staffId = "1";
		try {
			Staff staff = staffMapper.selectByPrimaryKey(staffId);
			System.out.println(staff);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @description 组合条件分页查询员工信息
	 */
	@Test
	public void getStaffByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		//pageCondition.put("staffId", "1");
		//pageCondition.put("staffName", "hss1");
		pageCondition.put("unitId", "1");
		pageCondition.put("jobId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Staff> staffs = staffMapper.getStaffByPageCondition(pageCondition);
			for (int i = 0; i < staffs.size(); i++) {
				System.out.println(staffs.get(i));
			}
			System.out.println(staffs.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的员工数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("staffId", "1");
		//condition.put("staffName", "hss1");
		condition.put("unitId", "1");
		condition.put("jobId", "1");
		try {
			int totalCount = staffMapper.getCountByConditon(condition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加员工
	 */
	@Test
	public void insert(){
		Staff staff = new Staff();
		staff.setStaffId("staffId");
		staff.setStaffName("添加系统管理员");
		staff.setJobId("1");
		staff.setStaffAbbr("hss");
		staff.setStaffBirthday(Date.valueOf("1992-08-14"));
		staff.setStaffGender("女");
		staff.setStaffIdCard("1");
		staff.setStaffPicPath("/");
		staff.setStaffTelephone("14584545555");
		staff.setStaffWorkDate(Date.valueOf("2017-08-14"));
		staff.setUnitId("1");
		try {
			int count = staffMapper.insert(staff);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据员工编号删除员工
	 */
	@Test
	public void deleteByPrimaryKey(){
		String staffId = "staffId";
		try {
			int count = staffMapper.deleteByPrimaryKey(staffId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新员工信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Staff staff = new Staff();
		staff.setStaffId("staffId");
		staff.setStaffName("修改系统管理员");
		staff.setJobId("1");
		staff.setStaffAbbr("hss");
		staff.setStaffBirthday(Date.valueOf("1992-08-14"));
		staff.setStaffGender("女");
		staff.setStaffIdCard("1");
		staff.setStaffPicPath("/");
		staff.setStaffTelephone("14584545555");
		staff.setStaffWorkDate(Date.valueOf("2017-08-14"));
		staff.setUnitId("1");
		try {
			int count = staffMapper.updateByPrimaryKeySelective(staff);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}