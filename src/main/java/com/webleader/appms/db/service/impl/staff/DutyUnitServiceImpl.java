package com.webleader.appms.db.service.impl.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.staff.DutyUnit;
import com.webleader.appms.db.mapper.staff.DutyUnitMapper;
import com.webleader.appms.db.service.staff.DutyUnitService;

/**
 * @className ScheduleServiceImpl
 * @description 每天，某个班次选择的班组
 * @author ding
 * @date 2017年5月8日 下午8:56:56
 * @version 1.0.0
 */

@Service("dutyUnitService")
public class DutyUnitServiceImpl implements DutyUnitService{
	
	@Autowired
	private DutyUnitMapper dutyUnitMapper;
	
	/** 
	 * @description 通过uid,删除一条记录
	 * @param uId
	 * @return 
	 */
	public DutyUnit selectByPrimaryKey(String uId) throws SQLException {
		if (Objects.isNull(uId)) {
			return null;
		}
		return dutyUnitMapper.selectByPrimaryKey(uId);
	}
	
	/** 
	 * @description 插入一条记录
	 * @param record
	 * @return 
	 */
	public int insert(DutyUnit record) throws SQLException {
		if (Objects.isNull(record)) {
			return 0;
		}
		return dutyUnitMapper.insert(record);
	}
	
	/** 
	 * @description 批量插入记录
	 * @param dutyUnitList
	 * @return 
	 */
	public int insertList(List<DutyUnit> dutyUnitList) throws SQLException {
		if (Objects.isNull(dutyUnitList)) {
			return 0;
		}
		return dutyUnitMapper.insertList(dutyUnitList);
	}
	
    /** 
     * @description 通过uid，删除一条记录
     * @param uId
     * @return 
     */
    public int deleteDutyUnitById(String uId) throws SQLException {
    	if (Objects.isNull(uId)) {
    		return 0;
    	}
    	return dutyUnitMapper.deleteDutyUnitById(uId);
    }

    /** 
     * @description 选择性更新记录
     * @param record
     * @return 
     */
    public int updateDutyUnit(DutyUnit record) throws SQLException {
    	if (Objects.isNull(record)) {
    		return 0;
    	}
    	return dutyUnitMapper.updateDutyUnit(record);
    }

}
