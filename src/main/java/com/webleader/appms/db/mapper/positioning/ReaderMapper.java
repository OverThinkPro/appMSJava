package com.webleader.appms.db.mapper.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.Reader;

/**
 * @className ReaderMapper
 * @description 数据库关于Reader的接口
 * @author HaoShaSha
 * @date 2017年4月15日 上午2:02:11
 * @version 1.0.0
 */
/**
 * @className ReaderMapper
 * @description TODO
 * @author ding
 * @date 2017年5月5日 下午1:26:09
 * @version 1.0.0
 */
public interface ReaderMapper {
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 根据分站编号查询分站信息
	 * @param readerId 
	 * @return
	 * @throws SQLException 
	 */
	public Reader selectByPrimaryKey(String readerId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询分站信息(区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Reader> getReaderByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询分站信息(区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId,pageSize,pageBegin)
	 * @return 返回Map
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getReaderByPageCondition2(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的分站数量(区域类型，分站名称，分站IP，分站状态，区域编号)
	 * @param pageCondition(readerId,readerName,readerIp,readerStatus,regionId)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 判断该点是否在现有区域内
	 * @param geoPoint
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getIsInRegion (String geoPoint) throws SQLException;
	
	/** 
	 * @description 查询所有的分站信息
	 * @param condition，分站是否正常 （readerStatus）
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> getReaderMapList (Map<Object, Object> condition) throws SQLException; 
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加分站
	 * @param reader
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Reader reader) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据分站编号删除分站
	 * @param readerId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String readerId) throws SQLException;
	

	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新分站信息
	 * @param reader
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Reader reader) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}