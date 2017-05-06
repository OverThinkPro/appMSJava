package com.webleader.appms.db.service.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.system.Dictionary;

/**
 * @className MenuService
 * @description 字典
 * @author HaoShaSha
 * @date 2017年5月2日 下午11:31:26
 * @version 1.0.0
 */
public interface DictionaryService {

	/** 
	 * @description 组合条件分页查询字典信息(数字字典编号，数字字典名称，上级数字字典编号，是否启用， 起始记录数，每页的记录数)
	 * @param pageCondition(dictionaryId,dictionaryName,upDictionaryId,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> getDicByPageCondition(Map<Object,Object> pageCondition) throws SQLException;
	
	/** 
	 * @description 统计符合条件的字典数量(数字字典编号，数字字典名称，上级数字字典编号，是否启用)
	 * @param condition(dictionaryId,dictionaryName,upDictionaryId,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 根据上级字典下的子字典的最大编号
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxDictionaryId(String upDictionaryId) throws SQLException;
	
	/** 
	 * @description 查询字典树
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> getDictionaryTree(String upDictionaryId) throws SQLException;
	
	/** 
	 * @description 添加字典
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Dictionary dictionary) throws SQLException;
	
	/** 
	 * @description 根据字典编号删除字典
	 * @param dictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String dictionaryId) throws SQLException;
	
	/** 
	 * @description 根据上级字典编号删除字典
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpDictionaryId(String upDictionaryId) throws SQLException;
	
	/** 
	 * @description 更新字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Dictionary dictionary) throws SQLException;
}
