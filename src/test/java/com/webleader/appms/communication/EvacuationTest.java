package com.webleader.appms.communication;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.communication.Evacuation;
import com.webleader.appms.db.mapper.communication.EvacuationMapper;

/**
 * @className EvacuationTest
 * @description 测试数据库接口EvacuationMapper
 * @author HaoShaSha
 * @date 2017年4月13日 下午9:45:14
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EvacuationTest {
	
	@Autowired
	private EvacuationMapper evacuationMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 统计满足条件的总撤离呼叫记录(开始时间，结束时间)
	 */
	@Test
	public void getLatestEvacuationOfRegion(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp startTime = Timestamp.valueOf("2017-04-01 11:49:45");
		//Timestamp endTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("startTime", alarmStartTime);
		//condition.put("endTime", alarmEndTime);
		condition.put("startTime", "");
		condition.put("endTime", "");
		condition.put("regionId", "a");
		try {
			Evacuation evacuation = evacuationMapper.getLatestEvacuationOfRegion(condition);
			System.out.println(evacuation);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 分页查询满足条件的回电呼叫记录
	 */
	@Test
	public void listEvacuationByPageCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp startTime = Timestamp.valueOf("2017-04-01 11:49:45");
		Timestamp endTime = Timestamp.valueOf("2017-04-10 11:49:45"); 
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("startTime", startTime);
		pageCondition.put("endTime", endTime);
		//pageCondition.put("startTime", "");
		//pageCondition.put("endTime", "");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 10);	//必须是bigint
		try {
			List<Evacuation> evacuationList = evacuationMapper.listEvacuationByPageCondition(pageCondition);
			for (int i = 0; i < evacuationList.size(); i++) {
				System.out.println(evacuationList.get(i));
			}
			System.out.println(evacuationList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 统计满足条件的总撤离呼叫记录(开始时间，结束时间)
	 */
	@Test
	public void countEvacuationByCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp startTime = Timestamp.valueOf("2017-04-01 11:49:45");
		//Timestamp endTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("startTime", alarmStartTime);
		//condition.put("endTime", alarmEndTime);
		condition.put("startTime", "");
		condition.put("endTime", "");
		try {
			int total = evacuationMapper.countEvacuationByCondition(condition);
			System.out.println(total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 插入一条回电呼叫记录
	 */
	@Test
	public void insert(){
		Timestamp callTime = Timestamp.valueOf("2017-05-09 11:49:45"); 
		Evacuation evacuation = new Evacuation();
		evacuation.setEvacuateId("18");
		evacuation.setCallTime(callTime);
		evacuation.setRegionId("a");
		evacuation.setRegionName("A工作区");
		evacuation.setUserId("1");
		evacuation.setUserName("hss");
		try {
			int result = evacuationMapper.insert(evacuation);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*****************插入接口结束*******************/
	/*****************END BY HaoShaSha***********/
}