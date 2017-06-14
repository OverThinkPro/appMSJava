package com.webleader.appms.controller.card;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.positioning.Card;
import com.webleader.appms.common.ModalPageConstants;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.positioning.CardService;
import com.webleader.appms.util.Response;

/**
 * @className CardControl
 * @description 定位卡管理
 * @author ding
 * @date 2017年5月3日 上午10:06:22
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class CardControl {

	@Autowired
	private CardService cardService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private ModalPageConstants modalConstants;
	
	/** 
	 * @description 条件分页查询定位卡信息
	 * @param currentPage
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/base/card/p/{currentPage}", method = RequestMethod.POST)
	@SystemLogController(opType="查询",opContent="条件分页查询定位卡信息")
	public Map<Object, Object> getCardListByCondition(@PathVariable int currentPage, 
			@RequestBody Map<Object,Object> condition) {
		Response response = new Response();
		List<Card> cardList = null;
		int total = 0;
		
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			if (Objects.nonNull(condition.get("cardStatus")) && condition.get("cardStatus").equals("未使用")){
				cardList = cardService.getUnuseByCondition(condition);
				total = cardService.getUnuseCountByCondition(condition);
			} else {
				cardList = cardService.getCardByPageCondition(condition);
				total = cardService.getCountByConditon(condition);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(cardList)) {
			return response.failure("查询定位卡信息失败，请重试").toSimpleResult();
		}
		return response.success().put("total", total).put("cardList", cardList).toCombineResult();
	}
	
	/** 
	 * @description 通过 unitId，staffName，staffAbbr分页查询出，所有员工及其卡的信息
	 * @param currentPage
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/base/staffcard/p/{currentPage}", method = RequestMethod.POST)
	@SystemLogController(opType="查询",opContent="通过 unitId，staffName，staffAbbr分页查询出，所有员工及其卡的信息")
	public Map<Object, Object> getStaffCardInfo(@PathVariable int currentPage, 
			@RequestBody Map<Object, Object> condition){
		Response response = new Response();
		List<Card> cardList = null;
		int total = 0;
		condition.put("pageBegin", modalConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalConstants.getPageSize());
		
		try {
			cardList = cardService.getStaffCardByCondition(condition);
			total = cardService.getStaffCardCount(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(cardList)) {
			return response.failure("查询员工信息失败，请重试").toSimpleResult();
		}
		return response.success().put("total", total).put("cardList", cardList).toCombineResult();
	}
	
	/** 
	 * @description 通过cardID 查询卡的信息
	 * @param cardId
	 * @return 
	 */
	@RequestMapping(value = "/base/card/{cardId}", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="通过cardID 查询卡的信息")
	public Map<Object, Object> getCardInfoById(@PathVariable String cardId) {
		Response response = new Response();
		Card card = null;
		
		try {
			card = cardService.selectByPrimaryKey(cardId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(card)) {
			response.failure("查询卡信息失败，请重试").toSimpleResult();
		}
		return response.success().put("card", card).toCombineResult();
	}
	
	/** 
	 * @description 发卡
	 * @param card
	 * @return 
	 */
	@RequestMapping(value = "/base/card", method = RequestMethod.PUT)
	@SystemLogController(opType="发卡",opContent="发卡")
	public Map<Object, Object> addStaffCard (@RequestBody Card card) {
		Response response = new Response();
		int result = 0;
		
		try {
			card.setCardStatus("正常");
			result = cardService.updateByPrimaryKeySelective(card);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result <= 0) {
			return response.failure("发卡失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 收卡
	 * @param cardId
	 * @return 
	 */
	@RequestMapping(value = "/base/card/{cardId}", method = RequestMethod.PUT)
	@SystemLogController(opType="收卡",opContent="收卡")
	public Map<Object, Object> addStaffCard (@PathVariable String cardId) {
		Response response = new Response();
		Card card = new Card();
		int result = 0;
		
		try {
			card.setCardStatus("未使用");
			card.setCardId(cardId);
			card.setStaffId(null);
			card.setStaffName(null);
			result = cardService.updateByPrimaryKeySelective(card);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result <= 0) {
			return response.failure("收卡失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 换卡模态框，查询所有未使用的卡信息
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/card/p/{currentPage}", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="换卡模态框，查询所有未使用的卡信息")
	public Map<Object, Object> getUnuseCardList(@PathVariable int currentPage, @RequestParam(value = "cardId", required = false) String cardId) {
		Response response = new Response();
		Map<Object, Object> condition = new HashMap<Object, Object>();
		List<Card> cardList = null;
		int total = 0;
		
		condition.put("pageBegin", modalConstants.getRecordNums(currentPage));
		condition.put("pageSize", modalConstants.getPageSize());
		condition.put("cardStatus", "未使用");
		if (Objects.nonNull(cardId)) {
			condition.put("cardId", cardId);
		}
		try {
			cardList = cardService.getUnuseByCondition(condition);
			total = cardService.getUnuseCountByCondition(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(cardList)) {
			return response.failure("查询失败，请重试").toSimpleResult();
		}
		return response.success().put("total", total).put("cardList", cardList).toCombineResult();
	}
	
	/** 
	 * @description 进行换卡操作
	 * @param condition
	 * @return 
	 */
	@RequestMapping(value = "/base/newcard", method = RequestMethod.PUT)
	@SystemLogController(opType="换卡",opContent="进行换卡操作")
	public Map<Object, Object> updateCard(@RequestBody Map<Object, Object> condition) {
		Response response = new Response();
		Card card = new Card();
		int result = 0;
		String cardStatus = condition.get("cardStatus").toString();
		String cardId = condition.get("cardId").toString();
		String opName = condition.get("opName").toString();
		Date opTime = Timestamp.valueOf(condition.get("opTime").toString());
		String staffId = condition.get("staffId").toString();
		String staffName = condition.get("staffName").toString();
		String newCardId = condition.get("newCardId").toString();
		
		if (Objects.isNull(cardStatus) || Objects.isNull(cardId) || Objects.isNull(opName) || Objects.isNull(opTime)) {
			return response.failure("换卡失败，请重试").toSimpleResult();
		} else {
			card.setOpName(opName);
			card.setOpTime(opTime);
			card.setCardId(cardId);
		}
			
		/*针对老卡的操作*/
		if (cardStatus.equals("正常")) {
			card.setCardStatus("未使用");
			card.setStaffId(null);
			card.setStaffName(null);
		} else {
			card.setCardStatus(cardStatus);
			card.setStaffId(staffId);
			card.setStaffName(staffName);
		}

		try {
			result = cardService.updateByPrimaryKeySelective(card);
			if (result <= 0) {
				return response.failure("换卡失败，请重试").toSimpleResult();
			}
			
			card.setCardStatus("正常");
			card.setStaffId(staffId);
			card.setStaffName(staffName);
			card.setCardId(newCardId);
			result = cardService.updateByPrimaryKeySelective(card);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result <= 0) {
			return response.failure("换卡失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
