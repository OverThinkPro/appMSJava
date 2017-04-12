package com.webleader.appms.alarm;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.alarm.AlarmSetting;
import com.webleader.appms.db.mapper.alarm.AlarmSettingMapper;

/**
 * @className AlarmSettingTest
 * @description 测试数据库接口 AlarmSettingMapper
 * @author HaoShaSha
 * @date 2017年4月11日 下午8:12:18
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AlarmSettingTest {
	
	@Autowired
	private AlarmSettingMapper alarmSettingMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据报警类型编号查询报警类型信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String alarmSettingId = "1";
		try {
			AlarmSetting alarmSetting = alarmSettingMapper.selectByPrimaryKey(alarmSettingId);
			System.out.println(alarmSetting);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 获得所有的报警类型
	 */
	@Test
	public void getAllAlarmTypes(){
		try {
			List<AlarmSetting> alarmSettingList = alarmSettingMapper.getAllAlarmTypes();
			System.out.println(alarmSettingList);
			System.out.println(alarmSettingList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加报警类型
	 */
	@Test
	public void insert(){
		AlarmSetting alarmSetting = new AlarmSetting();
		alarmSetting.setAlarmTypeId("5");
		alarmSetting.setAlarmName("报警");
		alarmSetting.setAlarmInUse(false); //注意此处是bool类型
		alarmSetting.setAlarmFile("");
		alarmSetting.setRemark("测试");
		try {
			int count = alarmSettingMapper.insert(alarmSetting);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/** 
	 * @description 添加报警类型(选择属性的添加)
	 */
	@Test
	public void insertSelective(){
		AlarmSetting alarmSetting = new AlarmSetting();
		alarmSetting.setAlarmTypeId("6");
		alarmSetting.setAlarmName("报警");
		alarmSetting.setAlarmInUse(false); //注意此处是bool类型
		alarmSetting.setAlarmFile("");
		alarmSetting.setRemark("测试");
		try {
			int count = alarmSettingMapper.insertSelective(alarmSetting);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
    /** 
     * @description 根据报警类型编号删除报警类型
     */
    @Test
    public void deleteByPrimaryKey(){
    	String alarmSettingId = "6";
		try {
			int count = alarmSettingMapper.deleteByPrimaryKey(alarmSettingId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新报警类型信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		AlarmSetting alarmSetting = new AlarmSetting();
		alarmSetting.setAlarmTypeId("5");
		alarmSetting.setAlarmName("报警类型");
		alarmSetting.setAlarmInUse(false); //注意此处是bool类型
		alarmSetting.setAlarmFile("");
		alarmSetting.setRemark("测试");
		try {
			int count = alarmSettingMapper.updateByPrimaryKeySelective(alarmSetting);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}