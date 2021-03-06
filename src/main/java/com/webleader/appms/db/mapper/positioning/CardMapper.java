package com.webleader.appms.db.mapper.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.Card;

/**
 * @className CardMapper
 * @description 数据库关于Card的接口
 * @author HaoShaSha
 * @date 2017年4月15日 下午10:31:32
 * @version 1.0.0
 */
public interface CardMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据定位卡编号查询定位卡信息
	 * @param cardId 
	 * @return
	 * @throws SQLException 
	 */
	public Card selectByPrimaryKey(String cardId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询定位卡信息(定位卡状态，员工名字，员工编号，定位卡号， 起始记录数，每页的记录数)
	 * @param pageCondition(cardStatus,staffName, staffId, cardId, pageSize, pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Card> getCardByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询 未使用的 定位卡信息(定位卡状态，定位卡号， 起始记录数，每页的记录数)
	 * @param pageCondition(cardStatus, cardId, pageSize, pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Card> getUnuseByCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的定位卡数量(定位卡状态，员工名字，员工编号，定位卡号)
	 * @param pageCondition(cardStatus,staffName, staffId, cardId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 通过 unitId，staffName，staffAbbr分页查询出，所有员工信息，及卡Id
	 * @param condition
	 * @return
	 * @throws SQLException 
	 * @author ding
	 */
	public List<Card> getStaffCardByCondition(Map<Object, Object> condition) throws SQLException;
	
	
	/** 
	 * @description 通过 unitId，staffName，staffAbbr分页查询出，所有员工信息记录数
	 * @param condition
	 * @return
	 * @throws SQLException 
	 * @author ding
	 */
	public int getStaffCardCount(Map<Object, Object> condition) throws SQLException;
	/** 
	 * @description 组合条件分页查询 未使用的 定位卡信息记录数(定位卡状态，定位卡号)
	 * @param pageCondition(cardStatus, cardId)
	 * @return
	 * @throws SQLException 
	 */
	public int getUnuseCountByCondition(Map<Object,Object> condition) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加定位卡
	 * @param card
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Card card) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据定位卡编号删除定位卡
	 * @param cardId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String cardId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新定位卡信息
	 * @param card
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Card card) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}