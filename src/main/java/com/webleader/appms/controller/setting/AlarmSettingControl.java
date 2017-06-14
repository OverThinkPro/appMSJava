package com.webleader.appms.controller.setting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.alarm.AlarmSetting;
import com.webleader.appms.common.PathHandler;
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
	private UUIDUtil uuidUtil;
	
	/** 
	 * @description 查询所有的报警类型列表
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType/", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="查询所有的报警类型列表")
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
	@SystemLogController(opType="添加",opContent="添加报警类型")
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
		return response.success().put("result", result).put("alarmTypeId", alarmSetting.getAlarmTypeId()).toCombineResult();
	}
	
	/** 
	 * @description 更新报警类型信息
	 * @param alarmSetting
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType", method = RequestMethod.PUT)
	@SystemLogController(opType="修改",opContent="更新报警类型")
	public Map<Object, Object> updateAlarmSetting (@RequestBody AlarmSetting alarmSetting) {
		Response response = new Response();
		int result = 0;
		
		try {
			alarmSetting.setAlarmFile(null);
			result = alarmSettingService.updateByPrimaryKeySelective(alarmSetting);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("更新报警类型失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过报警类型ID，删除报警类型
	 * @param alarmSettingId
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType", method = RequestMethod.DELETE)
	@SystemLogController(opType="删除",opContent="删除报警类型")
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
	 * @description 修改报警类型并上传报警声音文件
	 * @param file
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType/upload", method = RequestMethod.POST)
	@SystemLogController(opType="上传",opContent="修改报警类型并上传报警声音文件")
	public Map<Object, Object> uploadAlarmType(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "alarmTypeId", required = false) String alarmTypeId, HttpServletRequest request) {
		Response response = new Response();
		if(alarmTypeId==""){
			return response.failure("上传报警类型声音文件失败，请重试").toSimpleResult();
		}
		AlarmSetting alarmSetting = new AlarmSetting();
		alarmSetting.setAlarmTypeId(alarmTypeId);
		String alarmFile = null;
		String basePath = null;
		String realPath = null;
		String filePath = null;
		String fileNewName = null;
		if(!file.isEmpty()){
			basePath = request.getSession().getServletContext().getRealPath("/");
			realPath = PathHandler.BASE_PATH + PathHandler.ALARM_TYPE_PATH;
			filePath = PathHandler.formatToBackSlash(basePath + realPath);
			System.out.println("============================");
			System.out.println(filePath);
			System.out.println("============================");
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			fileNewName = alarmTypeId + suffix;
	        //保存  
	        try {  
	        	//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
	        	FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileNewName));
	        } catch (Exception e) {  
	            e.printStackTrace();
	            return response.failure("上传报警类型声音文件失败，请重试").toSimpleResult();
	        } 
	        alarmFile = PathHandler.formatToSlash(realPath + fileNewName);
	        alarmSetting.setAlarmFile(alarmFile);
		}else{
			return response.failure("上传报警类型声音文件失败，请重试").toSimpleResult();
		}
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

	
	/** 
	 * @description 流的方式得到音频
	 * @param request
	 * @param httpResponse 
	 */
	@RequestMapping(value = "/base/alarmType/getAlarmSoundByStream", method = RequestMethod.GET)
	@SystemLogController(opType="查询",opContent="流的方式得到音频")
	public void getAlarmSoundByStream(@RequestParam(value = "alarmSoundUrl", required = false) String alarmSoundUrl,HttpServletRequest request,HttpServletResponse httpResponse) {
		if (!Objects.nonNull(alarmSoundUrl) || alarmSoundUrl.equals("")) {
			throw new RuntimeException("Download file not exists!");  
		} 
		//String realPath = request.getSession().getServletContext().getRealPath(alarmSoundUrl);
		//String filePath = realPath;
		String basePath =  request.getSession().getServletContext().getRealPath("/");;
		String filePath = basePath + alarmSoundUrl;
		String fileUrl = PathHandler.formatToBackSlash(filePath);
		File file = new File(fileUrl);
		if (file.exists()){ 
			FileInputStream fis = null;
	        try {
	    		httpResponse.setContentType("audio");
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
	 * @description 绝对路径的方式得到服务器声音文件（暂时没用，可删除）
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/alarmType/getAlarmSoundByURL", method = RequestMethod.GET)
	public Map<Object, Object> getAlarmSoundByURL(@RequestParam(value = "alarmSoundUrl", required = false) String alarmSoundUrl,HttpServletRequest request,HttpServletResponse httpResponse) {
		if (!Objects.nonNull(alarmSoundUrl) || alarmSoundUrl.equals("")) {
			throw new RuntimeException("Download file not exists!");  
		} 
		Response response = new Response();
		String realPath = request.getSession().getServletContext().getRealPath(alarmSoundUrl);
		String filePath=realPath.replace("\\", "/");
		System.out.println(filePath);
		return response.success().put("audioUrl",filePath).toCombineResult();
	}
}
