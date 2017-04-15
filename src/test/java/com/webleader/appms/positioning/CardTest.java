package com.webleader.appms.positioning;

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

import com.webleader.appms.bean.positioning.Card;
import com.webleader.appms.db.mapper.positioning.CardMapper;

/**
 * @className CardTest
 * @description 测试数据库接口CardMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午10:38:05
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CardTest {
	
	@Autowired
	private CardMapper cardMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据定位卡编号查询定位卡信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String cardId = "1";
		try {
			Card card = cardMapper.selectByPrimaryKey(cardId);
			System.out.println(card);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询定位卡信息
	 */
	@Test
	public void getCardByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("cardStatus", "1");
		//pageCondition.put("staffId", "1");
		//pageCondition.put("staffName", "hss1");
		//pageCondition.put("cardId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Card> cards = cardMapper.getCardByPageCondition(pageCondition);
			for (int i = 0; i < cards.size(); i++) {
				System.out.println(cards.get(i));
			}
			System.out.println(cards.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的定位卡数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("staffId", "1");
		//condition.put("staffName", "hss1");
		//condition.put("cardId", "1");
		condition.put("cardStatus", "1");
		try {
			int totalCount = cardMapper.getCountByConditon(condition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加定位卡
	 */
	@Test
	public void insert(){
		Timestamp opTime = Timestamp.valueOf("2017-05-14 17:06:23");
		Card card = new Card();
		card.setCardId("cardId");
		card.setStaffId("1");
		card.setStaffName("hss1");
		card.setCardStatus("1");
		card.setOpTime(opTime);
		card.setOpName("hss");
		card.setBatteryV(8000.0);
		try {
			int count = cardMapper.insert(card);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据定位卡编号删除定位卡
	 */
	@Test
	public void deleteByPrimaryKey(){
		String cardId = "cardId";
		try {
			int count = cardMapper.deleteByPrimaryKey(cardId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新定位卡信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Timestamp opTime = Timestamp.valueOf("2017-05-15 17:06:23");
		Card card = new Card();
		card.setCardId("cardId");
		card.setStaffId("1");
		card.setStaffName("hss1");
		card.setCardStatus("3");
		card.setOpTime(opTime);
		card.setOpName("hss");
		card.setBatteryV(6000.0);
		try {
			int count = cardMapper.updateByPrimaryKeySelective(card);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}