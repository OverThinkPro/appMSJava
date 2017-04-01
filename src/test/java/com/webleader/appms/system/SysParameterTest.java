package com.webleader.appms.system;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.system.SysParameter;
import com.webleader.appms.db.mapper.system.SysParameterMapper;


/**
 * @className SysParameterTest
 * @description 测试数据库接口 SysParameterMapper
 * @author HaoShaSha
 * @date 2017年4月1日 下午3:25:03
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysParameterTest {
	
	@Autowired
	private SysParameterMapper sysParameterMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据系统参数编号查询系统参数信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String id = "a";
		try {
			SysParameter sysParameter = sysParameterMapper.selectByPrimaryKey(id);
			System.out.println(sysParameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加系统参数
	 */
	@Test
	public void insert(){
		String datetime = "2001-02-16 20:38:40";
		String id = "1";
		String initUserName = "haoshasha";
		String initPassword = "12345";
		SysParameter sysParameter = new SysParameter();
		sysParameter.setId(id);
		sysParameter.setDataBackPar(Timestamp.valueOf(datetime));
		sysParameter.setSysInitUsername(initUserName);
		sysParameter.setSysInitPwd(initPassword);
		try {
			int count = sysParameterMapper.insert(sysParameter);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据系统参数编号删除系统参数
	 */
	@Test
	public void deleteByPrimaryKey(){
		String id = "1";
		try {
			int count = sysParameterMapper.deleteByPrimaryKey(id);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新系统参数信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		String datetime = "2001-02-16 20:38:40";
		String id = "2";
		String initUserName = "haoshasha";
		String initPassword = "123456";
		SysParameter sysParameter = new SysParameter();
		sysParameter.setId(id);
		sysParameter.setDataBackPar(Timestamp.valueOf(datetime));
		sysParameter.setSysInitUsername(initUserName);
		sysParameter.setSysInitPwd(initPassword);
		try {
			int count = sysParameterMapper.updateByPrimaryKeySelective(sysParameter);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}