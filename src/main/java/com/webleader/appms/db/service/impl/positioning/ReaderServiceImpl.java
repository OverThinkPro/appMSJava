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
	 * @description 根据分站编号查询分站信息
	 * @param readerId 
	 * @return
	 * @throws SQLException 
	 */
	public Reader selectByPrimaryKey(String readerId) throws SQLException {
		if (Objects.isNull(readerId)) {
			return null;
		}
		return readerMapper.selectByPrimaryKey(readerId);
	}
	
	/** 
	 * @description 组合条件分页查询分站信息(区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Reader> getReaderByPageCondition(Map<Object,Object> pageCondition) throws SQLException {
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return readerMapper.getReaderByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 组合条件分页查询分站信息(区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId,pageSize,pageBegin)
	 * @return 返回Map
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getReaderByPageCondition2(Map<Object,Object> pageCondition) throws SQLException {
		if (Objects.isNull(pageCondition)) {
			return null;
		}
		return readerMapper.getReaderByPageCondition2(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的分站数量(区域类型，分站名称，分站IP，分站状态，区域编号)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException {
		if (Objects.isNull(condition)) {
			return 0;
		}
		return readerMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 判断该点是否在现有区域内
	 * @param geoPoint
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getIsInRegion (String geoPoint) throws SQLException{
		if (Objects.isNull(geoPoint)) {
			return null;
		}
		return readerMapper.getIsInRegion(geoPoint);
	}
	
	/** 
	 * @description 查询所有的分站坐标信息
	 * @param condition，分站是否正常 （readerStatus）
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getReaderMapList (Map<Object, Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return null;
		}
		return readerMapper.getReaderMapList(condition);
	}
	
	/** 
	 * @description 添加分站
	 * @param reader
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Reader reader) throws SQLException {
		if (Objects.isNull(reader)) {
			return 0;
		}
		return readerMapper.insert(reader);
	}
	
	/** 
	 * @description 根据分站编号删除分站
	 * @param readerId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String readerId) throws SQLException {
		if (Objects.isNull(readerId)) {
			return 0;
		}
		return readerMapper.deleteByPrimaryKey(readerId);
	}
	
	/** 
	 * @description 更新分站信息
	 * @param reader
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Reader reader) throws SQLException {
		if (Objects.isNull(reader)) {
			return 0;
		}
		return readerMapper.updateByPrimaryKeySelective(reader);
	}



}
