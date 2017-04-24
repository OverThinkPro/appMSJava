package com.webleader.appms.db.mapper.communication;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.communication.EvacuateDetail;

/**
 * @className EvacuationMapper
 * @description 数据库关于EvacuateDetail的接口
 * @author HaoShaSha
 * @date 2017年4月13日 下午11:44:20
 * @version 1.0.0
 */
public interface EvacuateDetailMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据总撤离编号[(某个区域最新的一条)]查找某一个呼叫状态[(已经被呼叫)]的用户数量
	 * @param condition(evacuateId,callStatus)
	 * @return total总数量
	 * @throws SQLException 
	 */
	public int countCallStatusByCondition(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 根据总撤离编号[(某个区域最新的一条)]查找某一个呼叫状态[(正在被呼叫)]的详细呼叫信息
	 * @param condition(evacuateId,callStatus)
	 * @return List<EvacuateDetail>
	 * @throws SQLException 
	 */
	public List<EvacuateDetail> getCallStaffByCallStatus(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 分页查询满足条件的撤离呼叫详情记录(总撤退编号，区域编号，开始时间，结束时间，起始记录数，每页的记录数)
	 * @param pageCondition(regionId,evacuateId,startTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<EvacuateDetail> listEvacuateDetailByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计满足条件的撤离呼叫详情记录(总撤退编号，区域编号，开始时间，结束时间，呼叫状态)
	 * @param condition(regionId,evacuateId,startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countEvacuateDetailByCondition(Map<Object,Object> condition) throws SQLException;
    
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/

	/** 
	 * @description 添加撤离呼叫详情记录
	 * @param evacuateDetail
	 * @return
	 * @throws SQLException 
	 */
	public int insert(List<Map<Object, Object>> evacuateDetail) throws SQLException;
	/*****************插入接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新撤离呼叫详情记录（主要针对呼叫的状态）
	 * @param evacuateDetail
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(EvacuateDetail evacuateDetail) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}