package com.webleader.appms.system;

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

import com.webleader.appms.bean.system.TBLog;
import com.webleader.appms.db.mapper.system.TBLogMapper;

/**
 * @className TBLogTest
 * @description 测试数据库接口 TBLogMapper
 * @author HaoShaSha
 * @date 2017年3月31日 下午10:10:40
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TBLogTest {
	
	@Autowired
	private TBLogMapper tbLogMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据日志编号查询日志信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String logId = "a";
		try {
			TBLog tbLog = tbLogMapper.selectByPrimaryKey(logId);
			System.out.println(tbLog);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @description 组合条件分页查询日志信息
	 */
	@Test
	public void getLogByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<TBLog> tbLogs = tbLogMapper.getLogByPageCondition(pageCondition);
			System.out.println(tbLogs.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的日志数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		try {
			int totalCount = tbLogMapper.getCountByConditon(pageCondition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加日志
	 */
	@Test
	public void insert(){
		String datetime = "2001-02-16 20:38:40";
		TBLog tbLog = new TBLog();
		tbLog.setLogId("2");
		tbLog.setUserId("a");;
		tbLog.setUserName("hss");
		tbLog.setOpType("添加");
		tbLog.setOpDate(Timestamp.valueOf(datetime));
		tbLog.setOpContent("添加了了一条日志");
		try {
			int count = tbLogMapper.insert(tbLog);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	/** 
	 * @description 选择性的添加日志（同insert）
	 */
	@Test
	public void insertSelective(){
		String datetime = "2001-02-16 20:38:40";
		TBLog tbLog = new TBLog();
		tbLog.setLogId("3");
		tbLog.setUserId("a");;
		tbLog.setUserName("hss");
		tbLog.setOpType("添加");
		tbLog.setOpDate(Timestamp.valueOf(datetime));
		tbLog.setOpContent("添加了了一条日志");
		try {
			int count = tbLogMapper.insert(tbLog);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据日志编号删除日志
	 */
	@Test
	public void deleteByPrimaryKey(){
		String logId = "3";
		try {
			int count = tbLogMapper.deleteByPrimaryKey(logId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新日志信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		String datetime = "2001-02-16 20:38:40";
		TBLog tbLog = new TBLog();
		tbLog.setLogId("1");
		tbLog.setUserId("a");;
		tbLog.setUserName("hss");
		tbLog.setOpType("删除");
		tbLog.setOpDate(Timestamp.valueOf(datetime));
		tbLog.setOpContent("删除了一条日志");
		try {
			int count = tbLogMapper.updateByPrimaryKeySelective(tbLog);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}