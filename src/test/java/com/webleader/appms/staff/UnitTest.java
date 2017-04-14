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

import com.webleader.appms.bean.staff.Unit;
import com.webleader.appms.db.mapper.staff.UnitMapper;

/**
 * @className UnitTest
 * @description 测试数据库接口 UnitMapper
 * @author HaoShaSha
 * @date 2017年4月14日 下午11:29:57
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UnitTest {
	
	@Autowired
	private UnitMapper unitMapper;
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据部门编号查询部门信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String unitId = "11";
		try {
			Unit unit = unitMapper.selectByPrimaryKey(unitId);
			System.out.println(unit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据上级部门编号查询子部门
	 */
	@Test
	public void getUnitByUpUnitId(){
		String upUnitId = "1";
		try {
			List<Unit> units = unitMapper.getUnitByUpUnitId(upUnitId);
			for (int i = 0; i < units.size(); i++) {
				System.out.println(units.get(i));
			}
			System.out.println(units.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 查询一级部门
	 */
	@Test
	public void getUnitTree(){
		try {
			List<Unit> urlTree = unitMapper.getUnitTree();
			for (int i = 0; i < urlTree.size(); i++) {
				System.out.println(urlTree.get(i));
			}
			System.out.println(urlTree.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询部门信息
	 */
	@Test
	public void getUnitByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		//pageCondition.put("unitId", "16");
		//pageCondition.put("unitName", "采矿一队");
		pageCondition.put("upUnitId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Unit> units = unitMapper.getUnitByPageCondition(pageCondition);
			for (int i = 0; i < units.size(); i++) {
				System.out.println(units.get(i));
			}
			System.out.println(units.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的部门数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("unitId", "16");
		//condition.put("unitName", "采矿一队");
		condition.put("upUnitId", "1");
		try {
			int totalCount = unitMapper.getCountByConditon(condition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * @description 根据上级部门下的子部门的最大编号
	 */
	@Test
	public void getMaxUnitId(){
		String upUnitId = "1";
		try {
			String maxId = unitMapper.getMaxUnitId(upUnitId);
			System.out.println(maxId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加部门
	 */
	@Test
	public void insert(){
		Unit unit = new Unit();
		unit.setUnitId("unitId");
		unit.setUnitName("测试插入部门");
		unit.setUpUnitId("1");
		unit.setTelephone("18435455555");
		unit.setHeader("hss");
		//注意此处是date类型,而不是datetime
		unit.setCreateDate(Date.valueOf("2017-08-14"));
		unit.setContactPerson("hss");
		unit.setDescription("测试添加部门");
		unit.setRemark("");
		try {
			int count = unitMapper.insert(unit);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据部门编号删除部门
	 */
	@Test
	public void deleteByPrimaryKey(){
		String unitId = "unitId";
		try {
			int count = unitMapper.deleteByPrimaryKey(unitId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据上级部门编号删除部门 
	 */
	@Test
	public void deleteByUpUnitId() {
		String upUnitId="1";
		try {
			int count = unitMapper.deleteByUpUnitId(upUnitId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新部门信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Unit unit = new Unit();
		unit.setUnitId("unitId");
		unit.setUnitName("测试修改部门");
		unit.setTelephone("18435455555");
		unit.setHeader("hss");
		//注意此处是date类型,而不是datetime
		unit.setCreateDate(Date.valueOf("2017-08-15"));
		unit.setContactPerson("hss");
		unit.setDescription("测试修改部门");
		unit.setRemark("");
		try {
			int count = unitMapper.updateByPrimaryKeySelective(unit);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}