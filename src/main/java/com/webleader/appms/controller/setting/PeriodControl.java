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

import com.webleader.appms.bean.setting.PeriodSetting;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.setting.PeriodService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className PeriodSettingControl
 * @description 报警类型管理
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
	private PageConstants pageConstants;
	@Autowired
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 查询所有的报警类型列表
	 * @return 
	 */
	@RequestMapping(value = "/base/period/", method = RequestMethod.GET)
	public Map<Object, Object> getPeriodSettingListByCondition () {
		Response response = new Response();
		List<PeriodSetting> periodList = null;
		try {
			periodList = periodService.getAllPeriodTypes();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(periodList)) {
			return response.failure("查询报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("periodList", periodList).toCombineResult();
	}
	
	/** 
	 * @description 添加报警类型
	 * @param period
	 * @return 
	 */
	@RequestMapping(value = "/base/period", method = RequestMethod.POST)
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
			return response.failure("添加报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过报警类型ID，删除报警类型
	 * @param periodId
	 * @return 
	 */
	@RequestMapping(value = "/base/period", method = RequestMethod.DELETE)
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
			return response.failure("删除报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}

	/** 
	 * @description 更新报警类型信息
	 * @param period
	 * @return 
	 */
	@RequestMapping(value = "/base/period", method = RequestMethod.PUT)
	public Map<Object, Object> updatePeriodSetting (@RequestBody PeriodSetting period) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = periodService.updateByPrimaryKeySelective(period);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
