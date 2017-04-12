package com.webleader.appms.alarm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.alarm.Alarm;
import com.webleader.appms.db.mapper.alarm.AlarmMapper;


/**
 * @className AlarmTest
 * @description 测试数据库接口 AlarmMapper
 * @author HaoShaSha
 * @date 2017年4月12日 上午1:17:02
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AlarmTest {
	
	@Autowired
	private AlarmMapper alarmMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据报警编号查询报警信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String alarmId = "1";
		try {
			Alarm alarm = alarmMapper.selectByPrimaryKey(alarmId);
			System.out.println(alarm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 统计未被处理的各个类型的报警信息的数量
	 */
	@Test
	public void countByAlarmType(){
		try {
			List<Map<Object,Object>> countInfo = alarmMapper.countByAlarmType();
			System.out.println(countInfo);
			System.out.println(countInfo.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************删除接口开始*******************/
    /** 
     * @description 根据条件删除报警信息or清空表
     */
    @Test
    public void deleteByCondition(){
    	Map<Object,Object> condition = new HashMap<Object,Object>();
    	//condition.put("alarm_inhandle", "1");
    	condition.put("alarmId", "1");
    	//condition.put("alarmTime", "2017-04-12 22:25:16");
		try {
			int count = alarmMapper.deleteByCondition(condition);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新报警信息的处理状态
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Alarm alarm = new Alarm();
		alarm.setAlarmInhandle("1");
		alarm.setAlarmId("1");
		try {
			int count = alarmMapper.updateByPrimaryKeySelective(alarm);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}