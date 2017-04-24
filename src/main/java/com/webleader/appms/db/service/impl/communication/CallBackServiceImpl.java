package com.webleader.appms.db.service.impl.communication;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.communication.CallStaff;
import com.webleader.appms.db.mapper.communication.CallStaffMapper;
import com.webleader.appms.db.service.communication.CallBackService;

/**
 * @className CallBackServiceImpl
 * @description 回电呼叫服务层实现
 * @author ding
 * @date 2017年4月24日 下午4:05:18
 * @version 1.0.0
 */
@Service("callBackService")
public class CallBackServiceImpl implements CallBackService{

	@Autowired
	private CallStaffMapper callStaffMapper;
	
	/** 
	 * @description 批量添加回电呼叫记录
	 * @param callStaff
	 * @return int
	 * @throws SQLException 
	 */
	public int insert(List<CallStaff> callStaffList) throws SQLException{
		if (Objects.isNull(callStaffList)) {
			return 0;
		}
		return callStaffMapper.insert(callStaffList);
	}
}
