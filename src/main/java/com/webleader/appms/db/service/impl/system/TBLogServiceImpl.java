package com.webleader.appms.db.service.impl.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.system.TBLog;
import com.webleader.appms.db.mapper.system.TBLogMapper;
import com.webleader.appms.db.service.system.TBLogService;

/**
 * @className TBLogServiceImpl
 * @description 日志服务层
 * @author HaoShaSha
 * @date 2017年5月3日 上午9:39:34
 * @version 1.0.0
 */
@Service("tbTBLogService")
public class TBLogServiceImpl implements TBLogService{
	
	@Autowired
	private TBLogMapper tbTBLogMapper;
	
	/** 
	 * @description 组合条件分页查询日志信息(用户编号，用户姓名，操作类型，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(userId,userName,opType,beginTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<TBLog> getLogByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return tbTBLogMapper.getLogByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的日志数量(用户编号，用户姓名，操作类型，开始时间，结束时间)
	 * @param pageCondition(userId,userName,opType,beginTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return tbTBLogMapper.getCountByConditon(condition);
	}

	/** 
	 * @description 添加日志
	 * @param tbTBLog
	 * @return
	 * @throws SQLException 
	 */
	public int insert(TBLog tbTBLog) throws SQLException{
		if (Objects.isNull(tbTBLog)) {
			return 0;
		}
		return tbTBLogMapper.insert(tbTBLog);
	}

}
