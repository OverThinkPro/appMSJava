package com.webleader.appms.db.mapper.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.Dictionary;


/**
 * @className DictionaryMapper
 * @description 数据库关于Dictionary的接口
 * @author HaoShaSha
 * @date 2017年4月1日 下午5:02:17
 * @version 1.0.0
 */
public interface DictionaryMapper {
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据字典编码查询字典名称
	 * @param dictionaryName
	 * @return
	 * @throws SQLException 
	 */
	public String getNameByCode(String dictionaryId) throws SQLException;
	
	/** 
	 * @description 根据字典名称查询字典编码
	 * @param dictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public String getCodeByName(String dictionaryName) throws SQLException;

	/** 
	 * @description 根据数字字典编号查询数字字典信息
	 * @param dictionaryId 
	 * @return
	 * @throws SQLException 
	 */
	public Dictionary selectByPrimaryKey(String dictionaryId) throws SQLException;
	
	/** 
	 * @description 根据上级数字字典编号查询子数字字典
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> getDicByUpDicId(String upDictionaryId) throws SQLException;
	
	/** 
	 * @description 查询一级数字字典
	 * @return upDictionaryId
	 * @throws SQLException 
	 */
	public List<Dictionary> getDicTree(String upDictionaryId) throws SQLException;
	
	/** 
	 * @description 组合条件分页查询数字字典信息
	 * @param pageCondition(dictionaryId,dictionaryName,upDictionaryId,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> getDicByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的数字字典数量
	 * @param pageCondition(dictionaryId,dictionaryName,upDictionaryId,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 根据上级数字字典下的子数字字典的最大编号
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxDicId(String upDictionaryId) throws SQLException;
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	
	/** 
	 * @description 添加数字字典
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Dictionary dictionary) throws SQLException;
	
	/** 
	 * @description 选择性的添加数字字典（同insert）
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int insertSelective(Dictionary dictionary) throws SQLException;
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	
	/** 
	 * @description 根据数字字典编号删除数字字典
	 * @param dictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String dictionaryId) throws SQLException;
	
	/** 
	 * @description 根据上级数字字典编号删除数字字典
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpDicId(String upDictionaryId) throws SQLException;
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	
	/** 
	 * @description 更新数字字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Dictionary dictionary) throws SQLException;
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/

}