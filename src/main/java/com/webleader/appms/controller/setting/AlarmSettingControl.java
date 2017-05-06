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

import com.webleader.appms.bean.alarm.AlarmSetting;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.setting.AlarmSettingService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className AlarmSettingControl
 * @description 报警类型管理
 * @author ding
 * @date 2017年4月26日 下午5:19:01
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class AlarmSettingControl {
	
	@Autowired
	private AlarmSettingService alarmSettingService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 查询所有的报警类型列表
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType/", method = RequestMethod.GET)
	public Map<Object, Object> getAlarmSettingListByCondition () {
		Response response = new Response();
		List<AlarmSetting> alarmSettingList = null;
		int result = 0;
		try {
			alarmSettingList = alarmSettingService.getAllAlarmTypes();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(alarmSettingList)) {
			return response.failure("查询报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("alarmSettingList", alarmSettingList).put("total", result).toCombineResult();
	}
	
	/** 
	 * @description 添加报警类型
	 * @param alarmSetting
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType", method = RequestMethod.POST)
	public Map<Object, Object> addAlarmSetting (@RequestBody AlarmSetting alarmSetting) {
		Response response = new Response();
		int result = 0;
		
		try {
			alarmSetting.setAlarmTypeId(uuidUtil.getUUID());
			result = alarmSettingService.insert(alarmSetting);
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
	 * @param alarmSettingId
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteAlarmSetting (@RequestParam String alarmTypeIds) {
		Response response = new Response();
		boolean result = true;
		List<String> alarmTypeIdList = java.util.Arrays.asList(alarmTypeIds.split(","));
		for(String alarmTypeId:alarmTypeIdList){
			try {
				result = result && alarmSettingService.deleteByPrimaryKey(alarmTypeId) >= 0 ? true : false;
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
	 * @param alarmSetting
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType", method = RequestMethod.PUT)
	public Map<Object, Object> updateAlarmSetting (@RequestBody AlarmSetting alarmSetting) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = alarmSettingService.updateByPrimaryKeySelective(alarmSetting);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
