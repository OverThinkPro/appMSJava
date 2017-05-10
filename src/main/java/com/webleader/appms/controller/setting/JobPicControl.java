package com.webleader.appms.controller.setting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webleader.appms.bean.staff.JobType;
import com.webleader.appms.common.PathHandler;
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
	@Autowired
	private PathHandler pathHandler;

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
	
	
	/** 
	 * @description 上传图片
	 * @param file
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype/upload", method = RequestMethod.POST)
	public Map<Object, Object> uploadJobType(@RequestParam(value = "file", required = false) MultipartFile file, 
			@RequestParam(value = "jobId", required = false) String jobId, HttpServletRequest request) {
		Response response = new Response();
		if (file.isEmpty() || !Objects.nonNull(jobId) || jobId.equals("")) {
			return response.failure("工种图例上传失败，请重试").toSimpleResult();
		} 
		//String realPath = "/fileLibrary/jobTypePics/";
		//String filePath = request.getSession().getServletContext().getRealPath(filePath);
		String basePath = PathHandler.BASE_PATH;
		String realPath = PathHandler.JOB_TYPE_PIC_PATH;
		String filePath = pathHandler.formatToBackSlash(basePath + realPath);
		System.out.println(filePath);
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String fileNewName = jobId+ suffix;  
        //保存  
        try {  
        	//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
        	FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileNewName));
        } catch (Exception e) {  
            e.printStackTrace();
            return response.failure("上传工种图例失败，请重试").toSimpleResult();
        } 
        
        String fileUrl = pathHandler.formatToSlash(realPath + fileNewName);
        System.out.println(fileUrl);
        JobType jobType = new JobType();
        jobType.setJobId(jobId);
        jobType.setJobIconUrl(fileUrl);
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

	
	/** 
	 * @description 流的方式得到图片
	 * @param request
	 * @param httpResponse 
	 */
	@RequestMapping(value = "/base/jobType/getJobPicByStream", method = RequestMethod.GET)
	public void getJobPicByStream(@RequestParam(value = "jobIconUrl", required = false) String jobIconUrl,HttpServletRequest request,HttpServletResponse httpResponse) {
		if (!Objects.nonNull(jobIconUrl) || jobIconUrl.equals("")) {
			throw new RuntimeException("Download file not exists!");  
		} 
		//String realPath = request.getSession().getServletContext().getRealPath(jobIconUrl);
		//String filePath = realPath;
		//System.out.println("filePath:"+filePath);
		String basePath = PathHandler.BASE_PATH;
		String fileUrl = pathHandler.formatToBackSlash(basePath + jobIconUrl);
		File file = new File(fileUrl);
		if (file.exists()){ 
			FileInputStream fis = null;
	        try {
	        	
	    		httpResponse.setContentType("image/gif");
	    		OutputStream out = httpResponse.getOutputStream();
	            fis = new FileInputStream(file);
	            byte[] b = new byte[fis.available()];
	            
	            fis.read(b);
	            out.write(b);
	            out.flush();
	        } catch (Exception e) {
	             e.printStackTrace();
	        } finally {
	            if (fis != null) {
	                try {
	                   fis.close();
	                } catch (IOException e) {
	    	        e.printStackTrace();
	                }   
	             }
	        }
		}else{
			throw new RuntimeException("Download file not exists!");  
		}
	}
	
	/** 
	 * @description 绝对路径的方式得服务器端图片（暂时不用，可以删除）
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/jobType/getJobPicByURL", method = RequestMethod.GET)
	public Map<Object, Object> getJobPicByURL(@RequestParam(value = "jobIconUrl", required = false) String jobIconUrl,HttpServletRequest request,HttpServletResponse httpResponse) {
		if (!Objects.nonNull(jobIconUrl) || jobIconUrl.equals("")) {
			throw new RuntimeException("Download file not exists!");  
		} 
		Response response = new Response();
		String realPath = request.getSession().getServletContext().getRealPath(jobIconUrl);
		String filePath=realPath.replace("\\", "/");
		System.out.println(filePath);
		return response.success().put("picUrl",filePath).toCombineResult();
	}
	
}