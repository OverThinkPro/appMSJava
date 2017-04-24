package com.webleader.appms.db.service.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.Reader;

/**
 * @className ReaderService
 * @description 分站
 * @author ding
 * @date 2017年4月24日 下午9:47:05
 * @version 1.0.0
 */
public interface ReaderService {
	
	/** 
	 * @description 组合条件分页查询分站信息(区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Reader> getReaderByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
}
