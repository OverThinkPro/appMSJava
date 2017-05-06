package com.webleader.appms.db.service.setting;

import java.sql.SQLException;
import java.util.Map;

import com.webleader.appms.bean.setting.Coalmine;

/**
 * @className CoalmineService
 * @description 煤矿基本信息
 * @author ding
 * @date 2017年4月21日 上午9:15:54
 * @version 1.0.0
 */
public interface CoalmineService {

	/** 
	 * @description 查询出该煤矿的信息，核定产能，核定人数，当前人数，当班领导
	 * @param startTime,endTime,currentCoalmineId
	 * @return map coalmineOutput,coalmineNum,currentTotalStaff,currentLeader
	 * @throws SQLException 
	 */
	public Map<Object, Object> getCoalmineInfo(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 查询出该煤矿所有信息
	 * @param coalmineId
	 * @return
	 * @throws SQLException 
	 */
	public Coalmine getCoalmineBaseInfo(String coalmineId) throws SQLException;
	
	/** 
	 * @description 更新煤矿信息
	 * @param coalmine
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Coalmine coalmine) throws SQLException;


}
