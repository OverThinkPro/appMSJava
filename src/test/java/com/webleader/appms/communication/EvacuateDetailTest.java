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

import com.webleader.appms.bean.communication.EvacuateDetail;
import com.webleader.appms.db.mapper.communication.EvacuateDetailMapper;


/**
 * @className EvacuateDetailTest
 * @description 测试数据库接口EvacuateDetailMapper
 * @author HaoShaSha
 * @date 2017年4月14日 上午12:21:59
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EvacuateDetailTest {
	
	@Autowired
	private EvacuateDetailMapper evacuateDetailMapper;
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据总撤离编号[(某个区域最新的一条)]查找某一个呼叫状态[(已经被呼叫)]的用户数量
	 */
	@Test
	public void countCallStatusByCondition(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("evacuateId", "1");
		condition.put("callStatus", "2");
		try {
			int total = evacuateDetailMapper.countCallStatusByCondition(condition);
			System.out.println(total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 据总撤离编号[(某个区域最新的一条)]查找某一个呼叫状态[(正在被呼叫)]的详细呼叫信息
	 */
	@Test
	public void getCallStaffByCallStatus(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("evacuateId", "1");
		condition.put("callStatus", "1");
		try {
			List<EvacuateDetail> evacuateDetailList = evacuateDetailMapper.getCallStaffByCallStatus(condition);
			for (int i = 0; i < evacuateDetailList.size(); i++) {
				System.out.println(evacuateDetailList.get(i));
			}
			System.out.println(evacuateDetailList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 分页查询满足条件的撤离呼叫详情记录(总撤退编号，区域编号，开始时间，结束时间，起始记录数，每页的记录数)
	 */
	@Test
	public void listEvacuateDetailByPageCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp startTime = Timestamp.valueOf("2017-04-01 11:49:45");
		//Timestamp endTime = Timestamp.valueOf("2017-04-10 11:49:45"); 
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		//pageCondition.put("startTime", startTime);
		//pageCondition.put("endTime", endTime);
		pageCondition.put("startTime", "");
		pageCondition.put("endTime", "");
		pageCondition.put("regionId", "b");
		pageCondition.put("evacuateId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 10);	//必须是bigint
		try {
			List<EvacuateDetail> evacuateDetailList = evacuateDetailMapper.listEvacuateDetailByPageCondition(pageCondition);
			for (int i = 0; i < evacuateDetailList.size(); i++) {
				System.out.println(evacuateDetailList.get(i));
			}
			System.out.println(evacuateDetailList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 统计满足条件的撤离呼叫详情记录(总撤退编号，区域编号，开始时间，结束时间)
	 */
	@Test
	public void countEvacuateDetailByCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp startTime = Timestamp.valueOf("2017-04-01 11:49:45");
		//Timestamp endTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("startTime", alarmStartTime);
		//condition.put("endTime", alarmEndTime);
		condition.put("startTime", "");
		condition.put("endTime", "");
		condition.put("regionId", "");
		condition.put("evacuateId", "");
		try {
			int total = evacuateDetailMapper.countEvacuateDetailByCondition(condition);
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
		Timestamp enteringTime = Timestamp.valueOf("2017-05-09 11:49:45"); 
		EvacuateDetail evacuateDetail = new EvacuateDetail();
		evacuateDetail.setCallStatus("0");
		evacuateDetail.setDetailId("detail");
		evacuateDetail.setEvacuateId("1");
		evacuateDetail.setStaffId("1");
		evacuateDetail.setStaffName("hss");
		evacuateDetail.setJobName("掘进工");
		evacuateDetail.setUnitName("掘进队");
		evacuateDetail.setEnteringTime(enteringTime);
		try {
			int result = evacuateDetailMapper.insert(evacuateDetail);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 更新撤离呼叫详情记录
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		EvacuateDetail evacuateDetail = new EvacuateDetail();
		evacuateDetail.setCallStatus("2");
		evacuateDetail.setDetailId("detail");
		try {
			int result = evacuateDetailMapper.updateByPrimaryKeySelective(evacuateDetail);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*****************插入接口结束*******************/
	/*****************END BY HaoShaSha***********/
}