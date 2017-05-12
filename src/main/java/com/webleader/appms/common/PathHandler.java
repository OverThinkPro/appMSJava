package com.webleader.appms.common;

import org.springframework.stereotype.Component;

/**
 * @className PathHandler
 * @description 处理与路径相关的操作
 * @author HaoShaSha
 * @date 2017年5月10日 下午6:08:06
 * @version 1.0.0
 */
@Component
public class PathHandler {
	
	public static final String BASE_PATH ="D:/apache-tomcat-8.0.35/webapps/appMSJava/static";
	
	public static final String MAP_PIC_PATH ="/map/";
	
	public static final String JOB_TYPE_PIC_PATH ="/jobTypePics/";
	
	public static final String ALARM_TYPE_PATH ="/alarmTypeSounds/";
	
	/** 
	 * @description 将斜杠格式化为反斜杠
	 * @param path
	 * @return 
	 */
	public String formatToSlash(String path){
		
		return path.replace("\\", "/");
	} 
	
	/** 
	 * @description 将反斜杠格式化为斜杠
	 * @param path
	 * @return 
	 */
	public String formatToBackSlash(String path){
		
		return path.replace("/", "\\");
	} 
}
