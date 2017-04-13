package com.webleader.appms.db.mapper.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.PastDoc;

/**
 * @className PastDocMapper
 * @description 数据库关于PastDoc的接口
 * @author HaoShaSha
 * @date 2017年4月12日 下午11:50:47
 * @version 1.0.0
 */
public interface PastDocMapper {
/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/

	/** 
	 * @description 组合条件分页查询历史轨迹信息(部门编号，员工姓名，定位卡号，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(unitId,staffName,cardId,startTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<PastDoc> listPastDocByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	

	/** 
	 * @description 统计符合条件的历史轨迹信息数量(部门编号，员工姓名，定位卡号，开始时间，结束时间)
	 * @param condition(unitId,staffName,cardId,startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countPastDocByConditon(Map<Object,Object> condition) throws SQLException;
    
	 
	/*****************查询接口结束*******************/
   	/*****************END BY HaoShaSha***********/

}