package com.webleader.appms.db.mapper.communication;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.communication.Evacuation;

/**
 * @className EvacuationMapper
 * @description 数据库关于Evacuation的接口
 * @author HaoShaSha
 * @date 2017年4月13日 下午11:44:20
 * @version 1.0.0
 */
public interface EvacuationMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据区域编号查询本区域的最新的一条撤离记录
	 * @param condition(regionId,startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public Evacuation getLatestEvacuationOfRegion(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 分页查询满足条件的总撤离呼叫记录(开始时间，结束时间，起始记录数，每页的记录数)
	 * @param pageCondition(startTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Evacuation> listEvacuationByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计满足条件的总撤离呼叫记录(开始时间，结束时间)
	 * @param condition(startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countEvacuationByCondition(Map<Object,Object> condition) throws SQLException;
    
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/

	/** 
	 * @description 添加撤退呼叫总记录
	 * @param evacuation
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Evacuation evacuation) throws SQLException;
	/*****************插入接口结束*******************/
   	/*****************END BY HaoShaSha***********/

}