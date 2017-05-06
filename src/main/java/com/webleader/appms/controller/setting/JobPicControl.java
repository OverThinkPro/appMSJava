package com.webleader.appms.controller.setting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.staff.JobType;
import com.webleader.appms.db.service.staff.JobTypeService;
import com.webleader.appms.util.Response;


/**
 * @className JobPicControl
 * @description 设置工种图例
 * @author HaoShaSha
 * @date 2017年5月3日 上午10:23:53
 * @version 1.0.0
 */
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class JobPicControl {
	
	@Autowired
	private JobTypeService jobTypeService;

	/** 
	 * @description 查询全部工种
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype/", method = RequestMethod.GET)
	public Map<Object, Object> getAllJobTypeList() {
		Response response = new Response();
		Map<Object, Object> pageCondition = new HashMap<Object, Object>();
		List<JobType> jobTypeList = null;
		pageCondition.put("pageBegin", null);
		pageCondition.put("pageSize", null);
		try {
			jobTypeList = jobTypeService.getJobTypeByPageCondition(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(jobTypeList)) {
			return response.failure("查询工种失败，请重试").toSimpleResult();
		}
		return response.success().put("jobTypeList", jobTypeList).toCombineResult();
	}
	
}