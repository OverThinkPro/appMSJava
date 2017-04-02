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

import com.webleader.appms.bean.system.Role;
import com.webleader.appms.db.mapper.system.RoleMapper;


/**
 * @className RoleTest
 * @description 测试数据库接口 RoleMapper
 * @author HaoShaSha
 * @date 2017年4月1日 下午10:44:27
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RoleTest {
	
	@Autowired
	private RoleMapper roleMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据角色编号查询角色信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String roleId = "a";
		try {
			Role role = roleMapper.selectByPrimaryKey(roleId);
			System.out.println(role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @description 组合条件分页查询角色信息
	 */
	@Test
	public void getRoleByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("inUse", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Role> roles = roleMapper.getRoleByPageCondition(pageCondition);
			System.out.println(roles.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的角色数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("inUse", "1");
		try {
			int totalCount = roleMapper.getCountByConditon(pageCondition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加角色
	 */
	@Test
	public void insert(){
		Role role = new Role();
		role.setRoleId("10002");
		role.setRoleName("系统管理员");
		role.setInUse("1");
		role.setDescription("系统管理员");
		try {
			int count = roleMapper.insert(role);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据角色编号删除角色
	 */
	@Test
	public void deleteByPrimaryKey(){
		String roleId = "a";
		try {
			int count = roleMapper.deleteByPrimaryKey(roleId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新角色信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Role role = new Role();
		role.setRoleId("10001");
		role.setRoleName("管理员");
		role.setInUse("1");
		role.setDescription("管理员");
		try {
			int count = roleMapper.updateByPrimaryKeySelective(role);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}