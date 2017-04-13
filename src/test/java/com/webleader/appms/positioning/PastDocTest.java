package com.webleader.appms.positioning;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.positioning.PastDoc;
import com.webleader.appms.db.mapper.positioning.PastDocMapper;

/**
 * @className PastDocTest
 * @description 测试数据库接口PastDocMapper
 * @author HaoShaSha
 * @date 2017年4月12日 下午11:58:59
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PastDocTest {
	
	@Autowired
	private PastDocMapper pastDocMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 组合条件分页查询历史轨迹信息
	 */
	@Test
	public void listPastDocByPageCondition(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp startTime = Timestamp.valueOf("2011-05-09 11:49:45");
		//Timestamp endTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("unitId", "1");
		pageCondition.put("staffName", "hss");
		pageCondition.put("cardId", "1");
		//pageCondition.put("startTime", startTime);
		//pageCondition.put("endTime", endTime);
		pageCondition.put("startTime", "");
		pageCondition.put("endTime", "");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 2);	//必须是bigint
		try {
			List<PastDoc> pastDocList = pastDocMapper.listPastDocByPageCondition(pageCondition);
			for (int i = 0; i < pastDocList.size(); i++) {
				System.out.println(pastDocList.get(i));
			}
			System.out.println(pastDocList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 统计符合条件的历史轨迹信息数量
	 */
	@Test
	public void countPastDocByConditon(){
		//注意此处的格式必须是 yyyy-mm-dd hh:mm:ss[.f...] 这样的格式，中括号表示可选，否则报错
		//Timestamp startTime = Timestamp.valueOf("2011-05-09 11:49:45");
		//Timestamp endTime = Timestamp.valueOf("2011-05-09 11:49:45"); 
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("unitId", "1");
		condition.put("staffName", "hss");
		condition.put("cardId", "1");
		//condition.put("startTime", startTime);
		//condition.put("endTime", endTime);
		condition.put("startTime", "");
		condition.put("endTime", "");
		try {
			int total = pastDocMapper.countPastDocByConditon(condition);
			System.out.println(total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	
	/*****************END BY HaoShaSha***********/
}