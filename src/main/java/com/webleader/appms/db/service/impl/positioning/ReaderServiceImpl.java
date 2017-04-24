package com.webleader.appms.db.service.impl.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.positioning.Reader;
import com.webleader.appms.db.mapper.positioning.ReaderMapper;
import com.webleader.appms.db.service.positioning.ReaderService;

/**
 * @className ReaderServiceImpl
 * @description 分站 服务层
 * @author ding
 * @date 2017年4月24日 下午9:47:55
 * @version 1.0.0
 */
@Service("readerService")
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	private ReaderMapper readerMapper;
	
	/** 
	 * @description 组合条件分页查询分站信息(区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Reader> getReaderByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return readerMapper.getReaderByPageCondition(pageCondition);
	}

}
