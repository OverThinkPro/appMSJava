package com.webleader.appms.controller.staff;

import java.sql.SQLException;
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
import com.webleader.appms.bean.staff.JobType;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.staff.JobTypeService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className JobTypeControl
 * @description 工种管理
 * @author ding
 * @date 2017年4月26日 下午5:19:01
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class JobTypeControl {
	
	@Autowired
	private JobTypeService jobTypeService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private UUIDUtil uuidUtil;
	
	
	/** 
	 * @description 条件查询工种列表
	 * @param jobId
	 * @param jobName
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype/p/{currentPage}", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="条件查询工种列表信息")
	public Map<Object, Object> getJobTypeListByCondition (@RequestParam(value = "jobId", required = false) String jobId,
			@RequestParam(value = "jobName", required = false) String jobName, @PathVariable int currentPage) {
		Response response = new Response();
		Map<Object, Object> pageCondition = new HashMap<Object, Object>();
		List<JobType> jobTypeList = null;
		int result = 0;
		
		if (Objects.nonNull(jobName) && !jobName.equals("")) {
			pageCondition.put("jobName", jobName);
		}
		if (Objects.nonNull(jobId) && !jobId.equals("")) {
			pageCondition.put("jobId", jobId);
		}
		pageCondition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		pageCondition.put("pageSize", pageConstants.getPageSize());
		
		try {
			jobTypeList = jobTypeService.getJobTypeByPageCondition(pageCondition);
			result = jobTypeService.getCountByConditon(pageCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(jobTypeList)) {
			return response.failure("查询工种失败，请重试").toSimpleResult();
		}
		return response.success().put("jobTypeList", jobTypeList).put("total", result).toCombineResult();
	}
	
	/** 
	 * @description 添加工种
	 * @param jobType
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype", method = RequestMethod.POST)
	@SystemLogController(opType="添加",opContent="添加一个新的工种")
	public Map<Object, Object> addJobType (@RequestBody JobType jobType) {
		Response response = new Response();
		int result = 0;
		
		try {
			jobType.setJobId(uuidUtil.getUUID());
			result = jobTypeService.insert(jobType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加工种失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过工种ID，删除工种
	 * @param jobTypeId
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype", method = RequestMethod.DELETE)
	@SystemLogController(opType="查询",opContent="通过工种ID，删除工种")
	public Map<Object, Object> deleteJobType (@RequestParam String jobId) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = jobTypeService.deleteByPrimaryKey(jobId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("删除工种失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}

	/** 
	 * @description 更新工种信息
	 * @param jobType
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype", method = RequestMethod.PUT)
	@SystemLogController(opType="修改",opContent="更新工种信息")
	public Map<Object, Object> updateJobType (@RequestBody JobType jobType) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = jobTypeService.updateByPrimaryKeySelective(jobType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新工种失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
}
