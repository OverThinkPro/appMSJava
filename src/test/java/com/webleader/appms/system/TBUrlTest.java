package com.webleader.appms.system;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.system.TBUrl;
import com.webleader.appms.db.mapper.system.TBUrlMapper;

/**
 * @className TBUrlTest
 * @description 测试数据库接口 TBUrlMapper
 * @author HaoShaSha
 * @date 2017年3月31日 下午10:10:40
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TBUrlTest {
	
	@Autowired
	private TBUrlMapper tbUrlMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据菜单编号查询菜单信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String moduleId = "a";
		try {
			TBUrl tbUrl = tbUrlMapper.selectByPrimaryKey(moduleId);
			System.out.println(tbUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据上级菜单编号查询子菜单
	 */
	@Test
	public void getUrlByUpModuleId(){
		String upModuleId = "1";
		try {
			List<TBUrl> tbUrl = tbUrlMapper.getUrlByUpModuleId(upModuleId);
			System.out.println(tbUrl.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 查询一级菜单
	 */
	@Test
	public void getUrlTree(){
		try {
			List<TBUrl> urlTree = tbUrlMapper.getUrlTree(null);
			System.out.println(urlTree);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询菜单信息
	 */
	@Test
	public void getUrlByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("upModuleId", "1");
		pageCondition.put("pageBegin", 1);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<TBUrl> tbUrls = tbUrlMapper.getUrlByPageCondition(pageCondition);
			System.out.println(tbUrls.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的菜单数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("upModuleId", "1");
		try {
			int totalCount = tbUrlMapper.getCountByConditon(pageCondition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * @description 根据上级菜单下的子菜单的最大编号
	 */
	@Test
	public void getMaxUrlId(){
		String upModuleId = "1";
		try {
			String maxId = tbUrlMapper.getMaxUrlId(upModuleId);
			System.out.println(maxId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加菜单
	 */
	@Test
	public void insert(){
		TBUrl tbUrl = new TBUrl();
		tbUrl.setModuleId("1000001");
		tbUrl.setModuleName("1000001");
		tbUrl.setUpModuleId("1");
		tbUrl.setModuleUrl("http://localhost:8080/test");
		tbUrl.setDescription("测试添加菜单");
		tbUrl.setInUse("1");
		try {
			int count = tbUrlMapper.insert(tbUrl);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	/** 
	 * @description 选择性的添加菜单（同insert）
	 */
	@Test
	public void insertSelective(){
		TBUrl tbUrl = new TBUrl();
		tbUrl.setModuleId("1000002");
		tbUrl.setModuleName("1000002");
		tbUrl.setUpModuleId("2");
		tbUrl.setModuleUrl("http://localhost:8080/test");
		tbUrl.setDescription("测试添加菜单");
		tbUrl.setInUse("1");
		try {
			int count = tbUrlMapper.insert(tbUrl);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据菜单编号删除菜单
	 */
	@Test
	public void deleteByPrimaryKey(){
		String moduleId = "1000001";
		try {
			int count = tbUrlMapper.deleteByPrimaryKey(moduleId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据上级菜单编号删除菜单 
	 */
	@Test
	public void deleteByUpModuleId() {
		String upModuleId="1";
		try {
			int count = tbUrlMapper.deleteByUpModuleId(upModuleId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新菜单信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		TBUrl tbUrl = new TBUrl();
		tbUrl.setModuleId("1000002");
		tbUrl.setModuleName("1000002");
		tbUrl.setModuleUrl("http://localhost:8080/test");
		tbUrl.setDescription("测试添加菜单");
		tbUrl.setInUse("1");
		try {
			int count = tbUrlMapper.updateByPrimaryKeySelective(tbUrl);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}