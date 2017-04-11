package com.webleader.appms.setting;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.setting.PeriodSetting;
import com.webleader.appms.db.mapper.setting.PeriodSettingMapper;


/**
 * @className PeriodSettingTest
 * @description 测试数据库接口 PeriodSettingMapper
 * @author HaoShaSha
 * @date 2017年4月11日 下午7:56:48
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PeriodSettingTest {
	
	@Autowired
	private PeriodSettingMapper periodSettingMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据周期类型编号查询周期类型信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String periodSettingId = "1";
		try {
			PeriodSetting periodSetting = periodSettingMapper.selectByPrimaryKey(periodSettingId);
			System.out.println(periodSetting);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 根据所有的周期类型
	 */
	@Test
	public void getAllPeriodTypes(){
		try {
			List<PeriodSetting> periodSettingList = periodSettingMapper.getAllPeriodTypes();
			System.out.println(periodSettingList);
			System.out.println(periodSettingList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加周期类型
	 */
	@Test
	public void insert(){
		PeriodSetting periodSetting = new PeriodSetting();
		periodSetting.setPeriodId("4");
		periodSetting.setPeriodName("位置数据采集周期");
		periodSetting.setDescription("设置井下分站以多长周期采集人员位置信息");
		periodSetting.setPeriodNum(10000);  //注意此处是整型
		periodSetting.setRemark("位置数据采集周期");
		try {
			int count = periodSettingMapper.insert(periodSetting);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/** 
	 * @description 添加周期类型(选择属性的添加)
	 */
	@Test
	public void insertSelective(){
		PeriodSetting periodSetting = new PeriodSetting();
		periodSetting.setPeriodId("5");
		periodSetting.setPeriodName("位置数据采集周期");
		periodSetting.setDescription("设置井下分站以多长周期采集人员位置信息");
		periodSetting.setPeriodNum(10000);  //注意此处是整型
		periodSetting.setRemark("位置数据采集周期");
		try {
			int count = periodSettingMapper.insertSelective(periodSetting);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
    /** 
     * @description 根据周期类型编号删除周期类型
     */
    @Test
    public void deleteByPrimaryKey(){
    	String periodSettingId = "5";
		try {
			int count = periodSettingMapper.deleteByPrimaryKey(periodSettingId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新周期类型信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		PeriodSetting periodSetting = new PeriodSetting();
		periodSetting.setPeriodId("4");
		periodSetting.setPeriodName("位置数据采集周期");
		periodSetting.setDescription("设置井下分站以多长周期采集人员位置信息");
		periodSetting.setPeriodNum(10000);  //注意此处是整型
		periodSetting.setRemark("位置数据采集周期");
		try {
			int count = periodSettingMapper.updateByPrimaryKeySelective(periodSetting);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}