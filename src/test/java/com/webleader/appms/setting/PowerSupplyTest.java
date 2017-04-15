package com.webleader.appms.setting;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.setting.PowerSupply;
import com.webleader.appms.db.mapper.setting.PowerSupplyMapper;


/**
 * @className PowerSupplyTest
 * @description 测试数据库接口 PowerSupplyMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午7:13:03
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PowerSupplyTest {
	
	@Autowired
	private PowerSupplyMapper powerSupplyMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据电源供应编号查询电源供应信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String powerSupplyId = "powerSupplyId";
		try {
			PowerSupply powerSupply = powerSupplyMapper.selectByPrimaryKey(powerSupplyId);
			System.out.println(powerSupply);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加电源供应
	 */
	@Test
	public void insert(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp powerSupplyStart = Timestamp.valueOf("2017-04-12 22:25:16");
		PowerSupply powerSupply = new PowerSupply();
		powerSupply.setPowerSupplyId("powerSupplyId");
		powerSupply.setPowerSupplyMode("1");
		powerSupply.setPowerSupplyStart(powerSupplyStart);
		powerSupply.setReaderId("1");
		try {
			int count = powerSupplyMapper.insert(powerSupply);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据电源供应编号删除电源供应
	 */
	@Test
	public void deleteByPrimaryKey(){
		String powerSupplyId = "powerSupplyId";
		try {
			int count = powerSupplyMapper.deleteByPrimaryKey(powerSupplyId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新电源供应信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp powerSupplyStart = Timestamp.valueOf("2017-04-12 22:25:16");
		PowerSupply powerSupply = new PowerSupply();
		powerSupply.setPowerSupplyId("powerSupplyId");
		powerSupply.setPowerSupplyMode("3");
		powerSupply.setPowerSupplyStart(powerSupplyStart);
		powerSupply.setReaderId("1");
		try {
			int count = powerSupplyMapper.updateByPrimaryKeySelective(powerSupply);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}