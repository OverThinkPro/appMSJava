package com.webleader.appms.db.service.impl.staff;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.staff.DutyDate;
import com.webleader.appms.db.mapper.staff.DutyDateMapper;
import com.webleader.appms.db.service.staff.DutyDateService;

/**
 * @className DutyDateServiceImpl
 * @description 一个班次，每一天的排班
 * @author ding
 * @date 2017年6月3日 下午6:19:44
 * @version 1.0.0
 */
@Service("dutyDateService")
public class DutyDateServiceImpl implements DutyDateService{
	
	@Autowired
	private DutyDateMapper dutyDateMapper;
	
	/** 
	 * @description 通过did，查询一条记录
	 * @param dId
	 * @return 
	 * @throws SQLException 
	 */
	public DutyDate selectByPrimaryKey(String dId) throws SQLException {
		if (Objects.isNull(dId)) {
			return null;
		}
		return dutyDateMapper.selectByPrimaryKey(dId);
	}
	
	/** 
	 * @description 通过日期，班次，查询相关信息
	 * @param dutyDate
	 * @return 
	 */
	public List<DutyDate> selectDutyDateByCondition(DutyDate dutyDate) throws SQLException {
		if (Objects.isNull(dutyDate)) {
			return null;
		}
		return dutyDateMapper.selectDutyDateByCondition(dutyDate);
	}
	
	/** 
	 * @description 添加一条记录
	 * @param record
	 * @return 
	 */
	public int insert(DutyDate record) throws SQLException {
		if (Objects.isNull(record)) {
			return 0;
		}
		return dutyDateMapper.insert(record);
	}
	
    /** 
     * @description 
     * @param 通过did删除一条记录
     * @return 
     */
    public int deleteDutyDateById(String dId) throws SQLException {
    	if (Objects.isNull(dId)) {
    		return 0;
    	}
    	return dutyDateMapper.deleteDutyDateById(dId);
    }
    
    /** 
     * @description 删除当前时间之后的所有排班记录
     * @param workDate
     * @return 
     */
    public int deleteDutyDateListByDate(Date workDate) throws SQLException {
    	if (Objects.isNull(workDate)) {
    		return 0;
    	}
    	return dutyDateMapper.deleteDutyDateListByDate(workDate);
    }

    /** 
     * @description 更新一条记录
     * @param record
     * @return 
     */
    public int updateDutyDate(DutyDate record) throws SQLException {
    	if (Objects.isNull(record)) {
    		return 0;
    	}
    	return dutyDateMapper.updateDutyDate(record);
    }

}
