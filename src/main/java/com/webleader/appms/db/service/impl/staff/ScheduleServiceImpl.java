package com.webleader.appms.db.service.impl.staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.staff.Schedule;
import com.webleader.appms.db.mapper.staff.ScheduleMapper;
import com.webleader.appms.db.service.staff.ScheduleService;

/**
 * @className ScheduleServiceImpl
 * @description 班次管理服务层
 * @author ding
 * @date 2017年5月8日 下午8:56:56
 * @version 1.0.0
 */

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	/** 
	 * @description 根据班次编号查询班次信息
	 * @param dutyId 
	 * @return
	 * @throws SQLException 
	 */
	public Schedule selectByPrimaryKey(String dutyId) throws SQLException {
		if (Objects.isNull(dutyId)) {
			return null;
		}
		return scheduleMapper.selectByPrimaryKey(dutyId);
	}
	
	/** 
	 * @description 组合条件分页查询班次信息(班次编号，班次名称， 起始记录数，每页的记录数)
	 * @param pageCondition(dutyId,dutyName,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> getScheduleByPageCondition(Map<Object,Object> pageCondition) throws SQLException {
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return scheduleMapper.getScheduleByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的班次数量(班次编号，班次名称)
	 * @param pageCondition(dutyId,scheduleName)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException {
		if (Objects.isNull(condition)) {
			return 0;
		}
		return scheduleMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 查询当前班次树
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> getScheduleTree() throws SQLException {
		return scheduleMapper.getScheduleTree();
	}
	
	/** 
	 * @description 通过上级班组ID，查询下级班组列表
	 * @return
	 * @throws SQLException 
	 */
	public List<Schedule> selectSchedule(String upDutyId) throws SQLException {
		if (Objects.isNull(upDutyId)) {
			return null;
		}
		return scheduleMapper.selectSchedule(upDutyId);
	}
	
	/** 
	 * @description 通过上级班次Id,查询要插入的下级班次ID
	 * @param upDutyId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxDutyId(String upDutyId) throws SQLException {
		if (Objects.isNull(upDutyId)) {
			return null;
		}
		String maxId = scheduleMapper.getMaxDutyId(upDutyId);
		if (Objects.isNull(maxId)){
			return upDutyId + "001";
		} else {
			return Integer.valueOf(maxId) + 1 + "";
		}
	}
	
	/** 
	 * @description 添加班次
	 * @param schedule
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Schedule schedule) throws SQLException {
		if (Objects.isNull(schedule)) {
			return 0;
		}
		return scheduleMapper.insert(schedule);
	}
	
	/** 
	 * @description 根据班次编号删除班次
	 * @param dutyId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String dutyId) throws SQLException {
		if (Objects.isNull(dutyId)) {
			return 0;
		}
		return scheduleMapper.deleteByPrimaryKey(dutyId);
	}

	/** 
	 * @description 更新班次信息
	 * @param schedule
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Schedule schedule) throws SQLException {
		if (Objects.isNull(schedule)) {
			return 0;
		}
		return scheduleMapper.updateByPrimaryKeySelective(schedule);
	}
	
}
