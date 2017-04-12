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

import com.webleader.appms.bean.alarm.SpecialRegionAlarm;
import com.webleader.appms.db.mapper.alarm.SpecialRegionAlarmMapper;


/**
 * @className SpecialRegionAlarmTest
 * @description 测试数据库接口SpecialRegionAlarmMapper
 * @author HaoShaSha
 * @date 2017年4月12日 下午9:43:47
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpecialRegionAlarmTest {
	
	@Autowired
	private SpecialRegionAlarmMapper specialRegionAlarmMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 组合条件分页查询限制区域报警信息
	 */
	@Test
	public void listRegionAlarmByPageCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp alarmEndTime = Timestamp.valueOf("2011-05-09 11:49:45");
		//Timestamp alarmStartTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("alarmInhandle", "0");
		pageCondition.put("regionName", "");
		//pageCondition.put("alarmStartTime", alarmStartTime);
		//pageCondition.put("alarmEndTime", alarmEndTime);
		pageCondition.put("alarmStartTime", "");
		pageCondition.put("alarmEndTime", "");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 2);	//必须是bigint
		try {
			List<SpecialRegionAlarm> specialRegionAlarmList = specialRegionAlarmMapper.listRegionAlarmByPageCondition(pageCondition);
			for (int i = 0; i < specialRegionAlarmList.size(); i++) {
				System.out.println(specialRegionAlarmList.get(i));
			}
			System.out.println(specialRegionAlarmList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 统计符合条件的限制区域报警信息数量
	 */
	@Test
	public void countSpecialRegionAlarmByConditon(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp alarmEndTime = Timestamp.valueOf("2011-05-09 11:49:45");
		//Timestamp alarmStartTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("alarmInhandle", "0");
		condition.put("regionName", "");
		//condition.put("alarmStartTime", alarmStartTime);
		//condition.put("alarmEndTime", alarmEndTime);
		condition.put("alarmStartTime", "");
		condition.put("alarmEndTime", "");
		try {
			int total = specialRegionAlarmMapper.countSpecialRegionAlarmByConditon(condition);
			System.out.println(total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	
	/*****************END BY HaoShaSha***********/
}