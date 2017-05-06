package com.webleader.appms.controller.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.system.TBLog;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.system.TBLogService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className UserControl
 * @description 查询出用户管理页面需要的信息
 * @author HaoShaSha
 * @date 2017年4月24日 上午10:44:29
 * @version 1.0.0
 */
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class TBLogControl {
	@Autowired
	private TBLogService logService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private UUIDUtil uuidUtil;
	
	
	/** 
	 * @description 条件查询日志列表
	 * @param logId
	 * @param logName
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/log/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getTBLogListByCondition (@RequestBody Map<Object, Object> condition,@PathVariable int currentPage) {
		Response response = new Response();
		List<TBLog> logList = null;
		int totalCounts = 0;
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		try {
			logList = logService.getLogByPageCondition(condition);
			totalCounts = logService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(logList)) {
			return response.failure("查询日志失败，请重试").toSimpleResult();
		}
		return response.success().put("logList", logList).put("totalCounts", totalCounts).toCombineResult();
	}
	
	/** 
	 * @description 添加日志
	 * @param log
	 * @return 
	 */
	@RequestMapping(value = "/base/log", method = RequestMethod.POST)
	public Map<Object, Object> addTBLog (@RequestBody TBLog log) {
		Response response = new Response();
		int result = 0;
		
		try {
			log.setLogId(uuidUtil.getUUID());
			result = logService.insert(log);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加日志失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	
}