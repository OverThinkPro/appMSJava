package com.webleader.appms.controller.setting;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.staff.JobType;
import com.webleader.appms.common.PathHandler;
import com.webleader.appms.db.service.staff.JobTypeService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.image.ImageCut;
import com.webleader.appms.util.image.ImageUtils;


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
	
	public static final int FIXED_WIDTH = 200;
	public static final int FIXED_HEIGHT= 200;
	
	/** 
	 * @description 查询全部工种
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype/", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="查询全部工种信息")
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
	 * @description 上传图片方法一：使用java类实现
	 * @param file
	 * @param request
	 * @return 
	 */
	/*@RequestMapping(value = "/base/jobtype/upload1", method = RequestMethod.POST)
	@SystemLogController(opType="上传",opContent="上传工种图片")
	public Map<Object, Object> uploadJobType1(@RequestParam(value = "file", required = false) MultipartFile file, 
			@RequestParam(value = "jobId", required = false) String jobId, HttpServletRequest request) {
		Response response = new Response();
		if (file.isEmpty() || !Objects.nonNull(jobId) || jobId.equals("")) {
			return response.failure("工种图例上传失败，请重试").toSimpleResult();
		} 
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String realPath = PathHandler.BASE_PATH + PathHandler.JOB_TYPE_PIC_PATH;
		String filePath = PathHandler.formatToBackSlash(basePath + realPath);
		System.out.println(filePath);
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String fileNewName = jobId+ suffix;  
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileNewName));
		} catch (IOException e1) {
			 e1.printStackTrace();
	         return response.failure("上传工种图例失败，请重试").toSimpleResult();
		}
        
        //使用java类按各种条件保存图片  
        try { 
        	ImageUtils.fromFile(new File(filePath, fileNewName))
			.size(200, 200)
			.rotate(34)		//旋转角度
			.quality(0.6f)
			.fixedGivenSize(true)
			.keepRatio(true)
			.bgcolor(Color.blue)	//透明背景			
			.toFile(new File(filePath, fileNewName));
        	//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
        	//FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileNewName));
        } catch (Exception e) {  
            e.printStackTrace();
            return response.failure("上传工种图例失败，请重试").toSimpleResult();
        } 
        
        String fileUrl = PathHandler.formatToSlash(realPath + fileNewName);
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
		
	}*/

	/** 
	 * @description 上传图片：使用java类实现
	 * @param file
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/jobtype/upload", method = RequestMethod.POST)
	@SystemLogController(opType="上传",opContent="上传工种图片")
	public Map<Object, Object> uploadJobType(@RequestParam(value = "avatar_file", required = false) MultipartFile avatarFile, 
			@RequestParam(value = "avatar_src", required = false) String avatar_src,
			@RequestParam(value = "avatar_data", required = false) String avatar_data, HttpServletRequest request) {
		
		Response response = new Response();
		System.out.println("upload");
		System.out.println(avatar_data);
		JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
		String jobId = joData.getString("jobId");
		
		//判断文件是否存在
		if (avatarFile.isEmpty() || !Objects.nonNull(jobId) || jobId.equals("")) {
			return response.failure("工种图例上传失败，请重试").toSimpleResult();
		} 
        
		//判断文件的MIMEtype
        String type = avatarFile.getContentType();
        System.out.println(type);
        if(type==null || !type.toLowerCase().startsWith("image/")){
        	return response.failure("不支持的文件类型，仅支持图片！").toSimpleResult();
        } 
        
        //获得源文件信息
      	String originalFilename = avatarFile.getOriginalFilename();
      		
        //获得目标文件名
        String basePath = request.getSession().getServletContext().getRealPath("/");
		String realPath = PathHandler.BASE_PATH + PathHandler.JOB_TYPE_PIC_PATH;
		String filePath = PathHandler.formatToBackSlash(basePath + realPath);
		System.out.println(filePath);
		String suffix = avatarFile.getOriginalFilename().substring(originalFilename.lastIndexOf("."));
		String fileNewName = jobId+ suffix;  
		
		// 用户经过剪辑后的图片的大小  
        float x = joData.getFloatValue("x");
        float y = joData.getFloatValue("y");
        float w =  joData.getFloatValue("width");
        float h =  joData.getFloatValue("height");
        float rotate = joData.getFloatValue("rotate");
       
        //开始上传
        File targetDocument = new File(filePath);
        File targetFile = new File(filePath, fileNewName);
        
        //先创建/覆盖一个图片
    	try {
			FileUtils.copyInputStreamToFile(avatarFile.getInputStream(), new File(filePath, fileNewName));
		} catch (IOException e1) {
			 e1.printStackTrace();
	         return response.failure("上传工种图例失败，请重试").toSimpleResult();
		}
        
        //保存裁剪后的文件
        if(!(x<0 || y<0)){
	        try {  
	            InputStream is = avatarFile.getInputStream();
	            ImageCut.cut(is, targetFile, (int)x,(int)y,(int)w,(int)h); 
	            is.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return response.failure("上传工种图例失败，请重试").toSimpleResult();
	        }  
        }
        
        //格式化图片
        ImageUtils.fromFile(new File(filePath, fileNewName))
		.size(FIXED_WIDTH, FIXED_HEIGHT)
		.rotate(rotate)		//旋转角度		
		.quality(0.6f)
		.fixedGivenSize(true)
		.keepRatio(false)
		.bgcolor(Color.WHITE )	//透明背景		
		.toFile(new File(filePath, fileNewName));
    	//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
    	//FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileNewName));
        
        //更新数据库
        String fileUrl = PathHandler.formatToSlash(PathHandler.JOB_TYPE_PIC_PATH + fileNewName);
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
		return response.success().put("result", result).put("fileUrl",fileUrl).toCombineResult();
        
    }

	
	
	/** 
	 * @description 流的方式得到图片
	 * @param request
	 * @param httpResponse 
	 */
	@RequestMapping(value = "/base/jobType/getJobPicByStream", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="流的方式得到图片")
	public void getJobPicByStream(@RequestParam(value = "jobIconUrl", required = false) String jobIconUrl,HttpServletRequest request,HttpServletResponse httpResponse) {
		if (!Objects.nonNull(jobIconUrl) || jobIconUrl.equals("")) {
			throw new RuntimeException("Download file not exists!");  
		} 
		//String realPath = request.getSession().getServletContext().getRealPath(jobIconUrl);
		//String filePath = realPath;
		//System.out.println("filePath:"+filePath);
		String basePath =  request.getSession().getServletContext().getRealPath("/");;
		String fileUrl = PathHandler.formatToBackSlash(basePath + jobIconUrl);
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
	@SystemLogController(opType="查询",opContent="绝对路径的方式得服务器端图片")
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