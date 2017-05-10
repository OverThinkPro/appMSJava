package com.webleader.appms.controller.setting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

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

import com.webleader.appms.common.PathHandler;
import com.webleader.appms.util.Response;


/**
 * @className MapPicControl
 * @description 设置地图底图
 * @author HaoShaSha
 * @date 2017年5月3日 上午10:24:17
 * @version 1.0.0
 */
@RestController
@Scope("prototype")
@RequestMapping("/api/v1/main")
public class MapPicControl{
	@Autowired
	private PathHandler pathHandler;
	/** 
	 * @description 上传图片
	 * @param file
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/map/upload", method = RequestMethod.POST)
	public Map<Object, Object> uploadMap(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
		Response response = new Response();
		//String realPath = request.getSession().getServletContext().getRealPath("/fileLibrary/map/");
		if (file.isEmpty()) {
			return response.failure("文件上传失败，请重试").toSimpleResult();
		} 
		String basePath = PathHandler.BASE_PATH;
		String realPath = PathHandler.MAP_PIC_PATH;
		String filePath = pathHandler.formatToBackSlash(basePath + realPath);
		String fileNewName = "map.jpg"; 
		
        //保存  
        try {  
        	//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
        	FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileNewName));
             
        } catch (Exception e) {  
            e.printStackTrace();
        } 
        String picUrl = pathHandler.formatToSlash(realPath + fileNewName);
        return response.success().put("picUrl", picUrl).toCombineResult();
		
	}

	
	/** 
	 * @description 流的方式得到图片
	 * @param request
	 * @param httpResponse 
	 */
	@RequestMapping(value = "/base/map/getMapPicByStream", method = RequestMethod.GET)
	public void getMapPicByStream(HttpServletRequest request,HttpServletResponse httpResponse) {
		//String fileName = request.getSession().getServletContext().getRealPath("/fileLibrary/map/map.jpg");
		String basePath = PathHandler.BASE_PATH;
		String realPath = PathHandler.MAP_PIC_PATH;
		String filePath = pathHandler.formatToBackSlash(basePath + realPath);
		System.out.println(filePath);
		String fileNewName = "map.jpg"; 
		File file = new File(filePath + fileNewName);
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
	 * @description URL的方式得到图片
	 * @param request
	 * @return 
	 */
	@RequestMapping(value = "/base/map/getMapPicByURL", method = RequestMethod.GET)
	public Map<Object, Object> getMapPicByURL(HttpServletRequest request) {
		Response response = new Response();
		String realPath = request.getSession().getServletContext().getRealPath("/fileLibrary/map/");
		String fileNewName = "map.jpg"; 
		String picUrl = realPath + fileNewName;
		System.out.println(picUrl);
		picUrl=picUrl.replace("\\", "/");
		System.out.println(picUrl);
		return response.success().put("picUrl",picUrl).toCombineResult();
	}
}