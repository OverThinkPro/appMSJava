package com.webleader.appms.controller.setting;

import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.setting.Coalmine;
import com.webleader.appms.db.service.setting.CoalmineService;
import com.webleader.appms.util.Response;

/**
 * @className CoalmineControl
 * @description 查询出煤矿设置页面需要的信息
 * @author HaoShaSha
 * @date 2017年5月3日 上午12:36:16
 * @version 1.0.0
 */
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class CoalmineControl {
	@Autowired
	private CoalmineService coalmineService;
	
	/**
	 * @description 查询煤矿基本信息
	 * @return Map
	 * @exception SQLException
	 */
	@RequestMapping(value = "/base/setting/coalmine", method = RequestMethod.GET)
	public Map<Object, Object> getCoalmineBaseInfo() {
		Coalmine coalmineInfo = new Coalmine();
		String coalmineId = "1";
		Response response = new Response();
		try {
			coalmineInfo = coalmineService.getCoalmineBaseInfo(coalmineId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(coalmineInfo)) {
			return response.failure("查询失败，请重新查询").toSimpleResult();
		}
		return response.success().put("coalmineInfo", coalmineInfo).toCombineResult();
	}
	
	/** 
	 * @description 更新煤矿信息
	 * @param coalmine
	 * @return 
	 */
	@RequestMapping(value = "/base/coalmine", method = RequestMethod.PUT)
	public Map<Object, Object> updateCoalmine (@RequestBody Coalmine coalmine) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = coalmineService.updateByPrimaryKeySelective(coalmine);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新煤矿失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}

}