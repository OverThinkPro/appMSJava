package com.webleader.appms.controller.setting;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.setting.PeriodSetting;
import com.webleader.appms.db.service.setting.PeriodService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className PeriodSettingControl
 * @description 周期管理
 * @author ding
 * @date 2017年4月26日 下午5:19:01
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class PeriodControl {
	
	@Autowired
	private PeriodService periodService;
	@Autowired
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 查询所有的周期列表
	 * @return 
	 */
	@RequestMapping(value = "/base/period/", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="条件查询所有的周期列表")
	public Map<Object, Object> getPeriodSettingListByCondition () {
		Response response = new Response();
		List<PeriodSetting> periodList = null;
		try {
			periodList = periodService.getAllPeriodTypes();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(periodList)) {
			return response.failure("查询周期失败，请重试").toSimpleResult();
		}
		return response.success().put("periodList", periodList).toCombineResult();
	}
	
	/** 
	 * @description 添加周期
	 * @param period
	 * @return 
	 */
	@RequestMapping(value = "/base/period", method = RequestMethod.POST)
	@SystemLogController(opType="添加",opContent="添加周期类型")
	public Map<Object, Object> addPeriodSetting (@RequestBody PeriodSetting period) {
		Response response = new Response();
		int result = 0;
		
		try {
			period.setPeriodId(uuidUtil.getUUID());
			result = periodService.insert(period);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加周期失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过周期ID，删除周期
	 * @param periodId
	 * @return 
	 */
	@RequestMapping(value = "/base/period", method = RequestMethod.DELETE)
	@SystemLogController(opType="删除",opContent="通过周期ID，删除周期")
	public Map<Object, Object> deletePeriodSetting (@RequestParam String periodIds) {
		Response response = new Response();
		boolean result = true;
		List<String> periodIdList = java.util.Arrays.asList(periodIds.split(","));
		for(String periodId:periodIdList){
			try {
				result = result && periodService.deleteByPrimaryKey(periodId) >= 0 ? true : false;
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!result) {
			return response.failure("删除周期失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}

	/** 
	 * @description 更新周期信息
	 * @param period
	 * @return 
	 */
	@RequestMapping(value = "/base/period", method = RequestMethod.PUT)
	@SystemLogController(opType="修改",opContent="更新周期信息")
	public Map<Object, Object> updatePeriodSetting (@RequestBody PeriodSetting period) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = periodService.updateByPrimaryKeySelective(period);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新周期失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
