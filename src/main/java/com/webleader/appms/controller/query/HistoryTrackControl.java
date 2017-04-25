package com.webleader.appms.controller.query;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.positioning.PastDoc;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.positioning.PastDocService;
import com.webleader.appms.util.Response;

/**
 * @className HistoryTrackControl
 * @description 历史轨迹回放
 * @author ding
 * @date 2017年4月25日 上午10:29:04
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class HistoryTrackControl {

	@Autowired
	private PastDocService pastDocService;
	@Autowired
	private PageConstants pageConstants;

	/** 
	 * @description 条件查询历史轨迹的列表
	 * @param hisCondition
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/history/staff/count/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getHistoryTrackList(@RequestBody Map<Object, Object> hisCondition,
			@PathVariable int currentPage) {
		List<PastDoc> pastdocList = null;
		int pastdocNum = 0;
		Response response = new Response();
		
		hisCondition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		hisCondition.put("pageSize", pageConstants.getPageSize());
		
		try {
			pastdocList = pastDocService.listPastDocByPageCondition(hisCondition);
			pastdocNum = pastDocService.countPastDocByConditon(hisCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(pastdocList)){
			return response.failure("查询历史轨迹失败，请重试").toSimpleResult();
		}
		return response.success().put("pastdocList", pastdocList).put("total", pastdocNum).toCombineResult();
	}

	/** 
	 * @description 条件查询历史轨迹的地图
	 * @param hisCondition
	 * @return 
	 */
	@RequestMapping (value = "/map/history/staff/count", method = RequestMethod.POST)
	public Map<Object, Object> getHisStaffPoint (@RequestBody Map<Object, Object> hisCondition){
		List<Map<Object, Object>> listMapPoint = null;
		Response response = new Response();
		
		try {
			listMapPoint = pastDocService.listMapPoint(hisCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(listMapPoint)){
			return response.failure("查询历史轨迹失败，请重试").toSimpleResult();
		}
		return response.success().put("listMapPoint", listMapPoint).toCombineResult();
	}
	
}
