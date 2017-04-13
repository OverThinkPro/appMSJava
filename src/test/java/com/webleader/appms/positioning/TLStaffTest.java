package com.webleader.appms.positioning;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.positioning.TLStaff;
import com.webleader.appms.db.mapper.positioning.TLStaffMapper;


/**
 * @className TLStaffTest
 * @description 测试数据库接口TLStaffMapper
 * @author HaoShaSha
 * @date 2017年4月13日 下午6:28:12
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TLStaffTest {
	
	@Autowired
	private TLStaffMapper tlStaffMapper;
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 实时统计井下各个班组的员工数量
	 */
	@Test
	public void countRealStaffByUnit(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp endTime = Timestamp.valueOf("2017-04-14 18:32:14");
		Timestamp startTime = Timestamp.valueOf("2017-04-14 18:32:14"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("startTime", startTime);
		condition.put("endTime", endTime);
		try {
			List<Map<Object,Object>> totalTLStaffByUnit = tlStaffMapper.countRealStaffByUnit(condition);
			for (int i = 0; i < totalTLStaffByUnit.size(); i++) {
				System.out.println(totalTLStaffByUnit.get(i));
			}
			System.out.println(totalTLStaffByUnit.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据部门编号实时统计井下某一个部门的员工数量
	 */
	@Test
	public void countRealStaffByUnitId(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp endTime = Timestamp.valueOf("2017-04-14 18:32:14");
		Timestamp startTime = Timestamp.valueOf("2017-04-14 18:32:14"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("startTime", startTime);
		condition.put("endTime", endTime);
		condition.put("unitId", "11");
		try {
			Map<Object,Object> totalTLStaffByUnitId = tlStaffMapper.countRealStaffByUnitId(condition);
			System.out.println(totalTLStaffByUnitId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 实时统计井下各个区域的员工数量
	 */
	@Test
	public void countRealStaffByRegion(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp endTime = Timestamp.valueOf("2017-04-14 18:32:14");
		Timestamp startTime = Timestamp.valueOf("2017-04-14 18:32:14"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("startTime", startTime);
		condition.put("endTime", endTime);
		try {
			List<Map<Object,Object>> totalTLStaffByRegion = tlStaffMapper.countRealStaffByRegion(condition);
			for (int i = 0; i < totalTLStaffByRegion.size(); i++) {
				System.out.println(totalTLStaffByRegion.get(i));
			}
			System.out.println(totalTLStaffByRegion.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据区域编号实时统计井下某一个区域的员工数量
	 */
	@Test
	public void countRealStaffByRegionId(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp endTime = Timestamp.valueOf("2017-04-14 18:32:14");
		Timestamp startTime = Timestamp.valueOf("2017-04-14 18:32:14"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("startTime", startTime);
		condition.put("endTime", endTime);
		condition.put("regionId", "a");
		try {
			Map<Object,Object> totalTLStaffByRegionId = tlStaffMapper.countRealStaffByRegionId(condition);
			System.out.println(totalTLStaffByRegionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 组合条件分页查询实时员工位置信息
	 */
	@Test
	public void listTLStaffByPageCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp endTime = Timestamp.valueOf("2017-04-14 18:32:14");
		Timestamp startTime = Timestamp.valueOf("2017-04-14 18:32:14"); 
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("startTime", startTime);
		pageCondition.put("endTime", endTime);
		pageCondition.put("unitId", "16");
		pageCondition.put("regionId", "a");
		pageCondition.put("readerId", "1");
		pageCondition.put("staffId", "1");
		pageCondition.put("staffName", "hss");
		pageCondition.put("cardId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 2);	//必须是bigint
		try {
			List<TLStaff> tlStaff = tlStaffMapper.listRealStaffByPageCondition(pageCondition);
			for (int i = 0; i < tlStaff.size(); i++) {
				System.out.println(tlStaff.get(i));
			}
			System.out.println(tlStaff.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 实时统计符合条件的实时员工的数量
	 */
	@Test
	public void countTotalStaffByConditon(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp endTime = Timestamp.valueOf("2017-04-14 18:32:14");
		Timestamp startTime = Timestamp.valueOf("2017-04-14 18:32:14"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("startTime", startTime);
		condition.put("endTime", endTime);
		condition.put("unitId", "16");
		condition.put("regionId", "a");
		condition.put("readerId", "1");
		condition.put("staffId", "1");
		condition.put("staffName", "hss");
		condition.put("cardId", "1");
		try {
			int total = tlStaffMapper.countTotalStaffByConditon(condition);
			System.out.println(total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************END BY HaoShaSha***********/
}