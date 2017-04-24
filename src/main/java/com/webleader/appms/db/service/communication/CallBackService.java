package com.webleader.appms.db.service.communication;

import java.sql.SQLException;
import java.util.List;

import com.webleader.appms.bean.communication.CallStaff;

/**
 * @className CallBackService
 * @description 回电呼叫的服务层
 * @author ding
 * @date 2017年4月24日 下午4:04:40
 * @version 1.0.0
 */
public interface CallBackService {

	/** 
	 * @description 批量添加回电呼叫记录
	 * @param callStaff
	 * @return int
	 * @throws SQLException 
	 */
	public int insert(List<CallStaff> callStaffList) throws SQLException;
}
