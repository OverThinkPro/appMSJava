package com.webleader.appms.db.mapper.staff;

import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.staff.DutyUnit;

/**
 * @className DutyUnitMapper
 * @description 每天，某个班次选择的班组
 * @author ding
 * @date 2017年5月10日 上午10:22:43
 * @version 1.0.0
 */
public interface DutyUnitMapper {
	
	/** 
	 * @description 通过uid,删除一条记录
	 * @param uId
	 * @return 
	 */
	public DutyUnit selectByPrimaryKey(String uId) throws SQLException;
	
	/** 
	 * @description 插入一条记录
	 * @param record
	 * @return 
	 */
	public int insert(DutyUnit record) throws SQLException;
	
	/** 
	 * @description 批量插入记录
	 * @param dutyUnitList
	 * @return 
	 */
	public int insertList(List<DutyUnit> dutyUnitList) throws SQLException;
	
    /** 
     * @description 通过uid，删除一条记录
     * @param uId
     * @return 
     */
    public int deleteDutyUnitById(String uId) throws SQLException;

    /** 
     * @description 选择性更新记录
     * @param record
     * @return 
     */
    public int updateDutyUnit(DutyUnit record) throws SQLException;

}