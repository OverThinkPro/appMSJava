package com.webleader.appms.db.mapper.staff;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.staff.DutyDate;

/**
 * @className DutyDateMapper
 * @description 一个班次，每一天的排班
 * @author ding
 * @date 2017年5月10日 上午10:27:11
 * @version 1.0.0
 */
public interface DutyDateMapper {
	
	/** 
	 * @description 通过did，查询一条记录
	 * @param dId
	 * @return 
	 */
	public DutyDate selectByPrimaryKey(String dId) throws SQLException;
	
	/** 
	 * @description 通过日期，班次，查询相关信息
	 * @param dutyDate
	 * @return 
	 */
	public List<DutyDate> selectDutyDateByCondition(DutyDate dutyDate) throws SQLException;
	
	/** 
	 * @description 添加一条记录
	 * @param record
	 * @return 
	 */
	public int insert(DutyDate record) throws SQLException;
	
    /** 
     * @description 
     * @param 通过did删除一条记录
     * @return 
     */
    public int deleteDutyDateById(String dId) throws SQLException;
    
    /** 
     * @description 删除当前时间之后的所有排班记录
     * @param workDate
     * @return 
     */
    public int deleteDutyDateListByDate(Date workDate) throws SQLException;

    /** 
     * @description 更新一条记录
     * @param record
     * @return 
     */
    public int updateDutyDate(DutyDate record) throws SQLException;

}