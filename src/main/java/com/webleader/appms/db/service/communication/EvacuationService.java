package com.webleader.appms.db.service.communication;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.communication.EvacuateDetail;

/**
 * @className EvacuationService
 * @description 撤离呼叫信息查询
 * @author ding
 * @date 2017年4月22日 上午10:57:18
 * @version 1.0.0
 */
public interface EvacuationService {

	/**
	 * @description 通过区域ID，evacuateId，查询详细的撤离呼叫信息
	 * @param condition：regionId，evacuateId，startTime，endTime，pageSize，pageBegin
	 * @return List<EvacuateDetail>
	 * @throws SQLException
	 */
	public List<EvacuateDetail> listEvacuateDetailByPageCondition(Map<Object, Object> condition) throws SQLException;

	/** 
	 * @description 通过条件，查询符合的报警记录条件数
	 * @param condition：regionId，evacuateId，startTime，endTime，pageSize，pageBegin
	 * @return int
	 * @throws SQLException 
	 */
	public int countEvacuateDetailByCondition(Map<Object, Object> condition) throws SQLException;
	
	/** 
	 * @description 通过userId,regionId,startTime,endTime 查询得到所有符合需求的员工基本信息，为了插入到撤离表中
	 * @param condition
	 * @return
	 * @throws SQLException 
	 * @author ding
	 */
	public List<Map<Object, Object>> getInsertEvacuation(Map<Object, Object> condition) throws SQLException;
	
	/** 
	 * @description 添加撤退呼叫总记录
	 * @param evacuation
	 * @return int
	 * @throws SQLException 
	 */
	public int insertEvacuation(List<Map<Object, Object>> evacuation) throws SQLException;
	
	/** 
	 * @description 添加撤离呼叫详情记录
	 * @param evacuateDetail
	 * @return
	 * @throws SQLException 
	 */
	public int insertEvacuateDetail(EvacuateDetail evacuateDetail) throws SQLException;
}
