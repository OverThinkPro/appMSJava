package com.webleader.appms.setting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.setting.Coalmine;
import com.webleader.appms.db.mapper.setting.CoalmineMapper;


/**
 * @className CoalmineTest
 * @description 测试数据库接口 CoalmineMapper
 * @author HaoShaSha
 * @date 2017年4月11日 下午6:37:50
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CoalmineTest {
	
	@Autowired
	private CoalmineMapper coalmineMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据煤矿编号查询煤矿信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String coalmineId = "1";
		try {
			Coalmine coalmine = coalmineMapper.selectByPrimaryKey(coalmineId);
			System.out.println(coalmine);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新煤矿信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Coalmine coalmine = new Coalmine();
		coalmine.setCoalmineId("1");
		coalmine.setCoalmineName("山西省第一矿井");
		coalmine.setCoalmineAbbr("一矿井");
		coalmine.setCoalmineNum(200);		//注意此处是int
		coalmine.setCoalmineOutput(200.00);	//注意此处是double
		coalmine.setCoalmineType("生产矿井");	//此处是字符串
		coalmine.setGasGrade("低浓度");
		coalmine.setRemark("一矿井");
		try {
			int count = coalmineMapper.updateByPrimaryKeySelective(coalmine);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}