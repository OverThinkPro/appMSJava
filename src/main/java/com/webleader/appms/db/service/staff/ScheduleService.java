package com.webleader.appms.db.service.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.staff.Schedule;

/**
 * @className ScheduleService
 * @description 班次管理
 * @author ding
 * @date 2017年5月8日 下午8:53:27
 * @version 1.0.0
 */
public interface ScheduleService {
	
	/** 
	 * @description 根据班次编号查询班次信息
	 * @param dutyId 
	 * @return
	 * @throws SQLException 
	 */
	public Schedule selectByPrimaryKey(String dutyId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询班次信息(班次编号，班次名称， 起始记录数，每页的记录数)
	 * @param pageCondition(dutyId,dutyName,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> getScheduleByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的班次数量(班次编号，班次名称)
	 * @param pageCondition(dutyId,scheduleName)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 查询当前班次树
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> getScheduleTree() throws SQLException;
	
	/** 
	 * @description 通过上级班组ID，查询下级班组列表
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> selectSchedule(String upDutyId) throws SQLException;
	
	/** 
	 * @description 通过上级班次Id,查询要插入的下级班次ID
	 * @param upDutyId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxDutyId(String upDutyId) throws SQLException;
	
	/** 
	 * @description 添加班次
	 * @param schedule
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Schedule schedule) throws SQLException;
	
	/** 
	 * @description 根据班次编号删除班次
	 * @param dutyId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String dutyId) throws SQLException;

	/** 
	 * @description 更新班次信息
	 * @param schedule
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Schedule schedule) throws SQLException;
	
}
