package com.webleader.appms.db.service.impl.communication;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.communication.EvacuateDetail;
import com.webleader.appms.db.mapper.communication.EvacuateDetailMapper;
import com.webleader.appms.db.mapper.communication.EvacuationMapper;
import com.webleader.appms.db.service.communication.EvacuationService;

/**
 * @className EvacuationServiceImpl
 * @description 撤离呼叫信息查询
 * @author ding
 * @date 2017年4月22日 上午10:57:42
 * @version 1.0.0
 */

@Service("evacuationService")
public class EvacuationServiceImpl implements EvacuationService {

	@Autowired
	private EvacuationMapper evacuationMapper;
	@Autowired
	private EvacuateDetailMapper evacuateDetailMapper;
	
	/**
	 * @description 通过区域ID，evacuateId，查询详细的撤离呼叫信息
	 * @param condition：regionId，evacuateId，startTime，endTime，pageSize，pageBegin
	 * @return List<EvacuateDetail>
	 * @throws SQLException
	 */
	public List<EvacuateDetail> listEvacuateDetailByPageCondition(Map<Object, Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return null;
		}
		return evacuateDetailMapper.listEvacuateDetailByPageCondition(condition);
	}
	
	/** 
	 * @description 通过条件，查询符合的报警记录条件数
	 * @param condition：regionId，evacuateId，startTime，endTime，pageSize，pageBegin
	 * @return int
	 * @throws SQLException 
	 */
	public int countEvacuateDetailByCondition(Map<Object, Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return evacuateDetailMapper.countEvacuateDetailByCondition(condition);
	}
	
	/** 
	 * @description 通过userId,regionId,startTime,endTime 查询得到所有符合需求的员工基本信息，为了插入到撤离表中
	 * @param condition
	 * @return
	 * @throws SQLException 
	 * @author ding
	 */
	public List<Map<Object, Object>> getInsertEvacuation(Map<Object, Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return null;
		}
		return evacuationMapper.getInsertEvacuation(condition);
	}
	
	/** 
	 * @description 添加撤退呼叫总记录
	 * @param evacuation
	 * @return int
	 * @throws SQLException 
	 */
	public int insertEvacuation(List<Map<Object, Object>> evacuation) throws SQLException{
		if (Objects.isNull(evacuation)) {
			return 0;
		}
		return evacuationMapper.insert(evacuation);
	}
	
	/** 
	 * @description 添加撤离呼叫详情记录
	 * @param evacuateDetail
	 * @return int
	 * @throws SQLException 
	 */
	public int insertEvacuateDetail(List<Map<Object, Object>> evacuateDetail) throws SQLException{
		if (Objects.isNull(evacuateDetail)) {
			return 0;
		}
		return evacuateDetailMapper.insert(evacuateDetail);
	}
}
