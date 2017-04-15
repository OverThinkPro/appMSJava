package com.webleader.appms.staff;

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

import com.webleader.appms.bean.staff.Schedule;
import com.webleader.appms.db.mapper.staff.ScheduleMapper;

/**
 * @className ScheduleTest
 * @description 测试数据库接口ScheduleMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午5:58:32
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ScheduleTest {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据班次编号查询班次信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String scheduleId = "1";
		try {
			Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
			System.out.println(schedule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询班次信息
	 */
	@Test
	public void getScheduleByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("dutyId", "1");
		pageCondition.put("dutyName", "早班");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Schedule> schedules = scheduleMapper.getScheduleByPageCondition(pageCondition);
			for (int i = 0; i < schedules.size(); i++) {
				System.out.println(schedules.get(i));
			}
			System.out.println(schedules.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的班次数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("dutyId", "1");
		condition.put("dutyName", "早班");
		try {
			int totalCount = scheduleMapper.getCountByConditon(condition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加班次
	 */
	@Test
	public void insert(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp startTime = Timestamp.valueOf("2017-04-12 22:25:16");
		Timestamp endTime = Timestamp.valueOf("2017-04-12 23:25:16");
		Schedule schedule = new Schedule();
		schedule.setDutyId("scheduleId");
		schedule.setDutyName("添加班次");
		schedule.setStartTime(startTime);
		schedule.setEndTime(endTime);
		try {
			int count = scheduleMapper.insert(schedule);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据班次编号删除班次
	 */
	@Test
	public void deleteByPrimaryKey(){
		String scheduleId = "scheduleId";
		try {
			int count = scheduleMapper.deleteByPrimaryKey(scheduleId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新班次信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		Timestamp startTime = Timestamp.valueOf("2017-04-12 22:25:16");
		Timestamp endTime = Timestamp.valueOf("2017-04-12 23:25:16");
		Schedule schedule = new Schedule();
		schedule.setDutyId("scheduleId");
		schedule.setDutyName("修改班次");
		schedule.setStartTime(startTime);
		schedule.setEndTime(endTime);
		try {
			int count = scheduleMapper.updateByPrimaryKeySelective(schedule);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}