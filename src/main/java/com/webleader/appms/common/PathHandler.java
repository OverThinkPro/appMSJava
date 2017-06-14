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
	
	public static String BASE_PATH ="/static/";
	
	public static String MAP_PIC_PATH ="/map/";
	
	public static String JOB_TYPE_PIC_PATH ="/jobTypePics/";
	
	public static String ALARM_TYPE_PATH ="/alarmTypeSounds/";
	
	/** 
	 * @description 将斜杠格式化为反斜杠
	 * @param path
	 * @return 
	 */
	public static String formatToSlash(String path){
		
		return path.replace("\\", "/");
	} 
	
	/** 
	 * @description 将反斜杠格式化为斜杠
	 * @param path
	 * @return 
	 */
	public static String formatToBackSlash(String path){
		
		return path.replace("/", "\\");
	} 
}
