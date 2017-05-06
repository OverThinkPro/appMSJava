package com.webleader.appms.db.service.impl.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.positioning.Card;
import com.webleader.appms.db.mapper.positioning.CardMapper;
import com.webleader.appms.db.service.positioning.CardService;

/**
 * @className CardServiceImpl
 * @description 定位卡 服务层
 * @author ding
 * @date 2017年5月3日 上午9:58:18
 * @version 1.0.0
 */
@Service("cardService")
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardMapper cardMapper;
	
	/** 
	 * @description 根据定位卡编号查询定位卡信息
	 * @param cardId 
	 * @return
	 * @throws SQLException 
	 */
	public Card selectByPrimaryKey(String cardId) throws SQLException{
		if (Objects.isNull(cardId)) {
			return null;
		}
		return cardMapper.selectByPrimaryKey(cardId);
	}
	
	/** 
	 * @description 组合条件分页查询定位卡信息(定位卡状态，员工名字，员工编号，定位卡号， 起始记录数，每页的记录数)
	 * @param pageCondition(cardStatus,staffName, staffId, cardId, pageSize, pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Card> getCardByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return cardMapper.getCardByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 组合条件分页查询 未使用的 定位卡信息(定位卡状态，定位卡号， 起始记录数，每页的记录数)
	 * @param pageCondition(cardStatus, cardId, pageSize, pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Card> getUnuseByCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return cardMapper.getUnuseByCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的定位卡数量(定位卡状态，员工名字，员工编号，定位卡号)
	 * @param pageCondition(cardStatus,staffName, staffId, cardId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return cardMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 通过 unitId，staffName，staffAbbr分页查询出，所有员工信息，及卡Id
	 * @param condition
	 * @return
	 * @throws SQLException 
	 * @author ding
	 */
	public List<Card> getStaffCardByCondition(Map<Object, Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return null;
		}
		return cardMapper.getStaffCardByCondition(condition);
	}
	
	/** 
	 * @description 通过 unitId，staffName，staffAbbr分页查询出，所有员工信息记录数
	 * @param condition
	 * @return
	 * @throws SQLException 
	 * @author ding
	 */
	public int getStaffCardCount(Map<Object, Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return cardMapper.getStaffCardCount(condition);
	}
	
	/** 
	 * @description 组合条件分页查询 未使用的 定位卡信息记录数(定位卡状态，定位卡号)
	 * @param pageCondition(cardStatus, cardId)
	 * @return
	 * @throws SQLException 
	 */
	public int getUnuseCountByCondition(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return cardMapper.getUnuseCountByCondition(condition);
	}
	
	/** 
	 * @description 添加定位卡
	 * @param card
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Card card) throws SQLException{
		if (Objects.isNull(card)) {
			return 0;
		}
		return cardMapper.insert(card);
	}
	
	/** 
	 * @description 根据定位卡编号删除定位卡
	 * @param cardId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String cardId) throws SQLException{
		if (Objects.isNull(cardId)) {
			return 0;
		}
		return cardMapper.deleteByPrimaryKey(cardId);
	}
	
	/** 
	 * @description 更新定位卡信息
	 * @param card
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Card card) throws SQLException{
		if (Objects.isNull(card)) {
			return 0;
		}
		return cardMapper.updateByPrimaryKeySelective(card);
	}

}
