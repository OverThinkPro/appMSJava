package com.webleader.appms.db.service.impl.setting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webleader.appms.bean.setting.Coalmine;
import com.webleader.appms.db.mapper.positioning.TLStaffMapper;
import com.webleader.appms.db.mapper.setting.CoalmineMapper;
import com.webleader.appms.db.service.setting.CoalmineService;

/**
 * @className CoalmineServiceImpl
 * @description 煤矿基本信息
 * @author ding
 * @date 2017年4月21日 上午9:18:02
 * @version 1.0.0
 */
@Service("coalmineService")
public class CoalmineServiceImpl implements CoalmineService{
	
	@Resource
	private CoalmineMapper coalmineMapper;
	@Resource
	private TLStaffMapper tlStaffMapper;

	/** 
	 * @description 查询出该煤矿的信息，核定产能，核定人数，当前人数，当班领导
	 * @param startTime,endTime,currentCoalmineId
	 * @return map coalmineOutput,coalmineNum,currentTotalStaff,currentLeader
	 * @throws SQLException 
	 */
	@Override
	public Map<Object, Object> getCoalmineInfo(Map<Object,Object> condition) throws SQLException {
		if(Objects.isNull(condition)){
			return null;
		}
		Map<Object, Object> coalmineInfo = new HashMap<Object, Object>();
		
		Coalmine coalmine = coalmineMapper.selectByPrimaryKey(condition.get("currentCoalmineId").toString());
		int currentTotalStaff = tlStaffMapper.countTotalStaffByConditon(condition);
		
		/*将查出的值放入map中*/
		coalmineInfo.put("coalmineOutput", coalmine.getCoalmineOutput());
		coalmineInfo.put("coalmineNum", coalmine.getCoalmineNum());
		coalmineInfo.put("currentTotalStaff", currentTotalStaff);
		/*伪数据*/
		coalmineInfo.put("currentLeader", "泰迪熊");
		
		return coalmineInfo;
	}
	
	
	/** 
	 * @description 查询出该煤矿所有信息
	 * @param coalmineId
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public Coalmine getCoalmineBaseInfo(String coalmineId) throws SQLException {
		if(Objects.isNull(coalmineId)){
			return null;
		}
		return coalmineMapper.selectByPrimaryKey(coalmineId);
		
	}
	
	
	/** 
	 * @description 更新煤矿信息
	 * @param coalmine
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Coalmine coalmine) throws SQLException{
		if (Objects.isNull(coalmine)) {
			return 0;
		}
		return coalmineMapper.updateByPrimaryKeySelective(coalmine);
	}
}
