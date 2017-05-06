package com.webleader.appms.db.service.setting;
/**
 * @className MapPicService
 * @description 地图底图
 * @author HaoShaSha
 * @date 2017年5月3日 上午10:17:20
 * @version 1.0.0
 */
public interface MapPicService {

	/** 
	 * @description 读取地图底图
	 * @return 
	 */
	public String getMap();
	
	/** 
	 * @description 修改地图底图
	 * @param map
	 * @return 
	 */
	public String upLoadMap(String map);
}
