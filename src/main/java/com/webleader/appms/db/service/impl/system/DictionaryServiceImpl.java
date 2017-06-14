package com.webleader.appms.db.service.impl.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.system.Dictionary;
import com.webleader.appms.db.mapper.system.DictionaryMapper;
import com.webleader.appms.db.service.system.DictionaryService;


/**
 * @className DictionaryServiceImpl
 * @description 字典服务层
 * @author ding
 * @date 2017年4月24日 下午9:12:38
 * @version 1.0.0
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	/** 
	 * @description 根据字典名称查询字典信息
	 * @param dictionaryName
	 * @return
	 * @throws SQLException 
	 */
	public Dictionary getDicByDictionaryName(String dictionaryName) throws SQLException {
		if (Objects.isNull(dictionaryName)){
			return null;
		}
		return dictionaryMapper.getDicByDictionaryName(dictionaryName);
	}

	/** 
	 * @description 组合条件分页查询字典信息(字典编号，字典名称，上级字典编号，是否启用， 起始记录数，每页的记录数)
	 * @param pageCondition(dictionaryId,dictionaryName,upDictionaryId,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> getDicByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return dictionaryMapper.getDicByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的字典数量(字典编号，字典名称，上级字典编号，是否启用)
	 * @param condition(dictionaryId,dictionaryName,upDictionaryId,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return 0;
		}
		return dictionaryMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 根据上级字典下的子字典的最大编号
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxDictionaryId(String upDictionaryId) throws SQLException{
		if (Objects.isNull(upDictionaryId)) {
			return null;
		}
		String maxId = dictionaryMapper.getMaxDicId(upDictionaryId);
		if (Objects.isNull(maxId)){
			return upDictionaryId + "01";
		} else {
			return Integer.valueOf(maxId) + 1 + "";
		}
	}
	
	/** 
	 * @description 查询字典树
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> getDictionaryTree(String upDictionaryId) throws SQLException{
		return dictionaryMapper.getDicTree(upDictionaryId);
	}
	
	/** 
	 * @description 添加字典
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int insert(Dictionary dictionary) throws SQLException{
		if (Objects.isNull(dictionary)) {
			return 0;
		}
		return dictionaryMapper.insert(dictionary);
	}
	
	/** 
	 * @description 根据字典编号删除字典
	 * @param dictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String dictionaryId) throws SQLException{
		if (Objects.isNull(dictionaryId)) {
			return 0;
		}
		return dictionaryMapper.deleteByPrimaryKey(dictionaryId);
	}
	
	/** 
	 * @description 根据上级字典编号删除字典
	 * @param upDictionaryId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpDictionaryId(String upDictionaryId) throws SQLException{
		if (Objects.isNull(upDictionaryId)) {
			return 0;
		}
		return dictionaryMapper.deleteByUpDicId(upDictionaryId);
	}
	
	/** 
	 * @description 更新字典信息
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(Dictionary dictionary) throws SQLException{
		if (Objects.isNull(dictionary)) {
			return 0;
		}
		return dictionaryMapper.updateByPrimaryKeySelective(dictionary);
	}
	
	/** 
	 * @description 根据上级数据字典编号修改数据字典的启用和禁用 
	 * @param condition(inUse, upDictionaryId)
	 * @return 是否启用，上级数据字典编号
	 * @throws SQLException 
	 */
	public int updateInUseByUpDicId(Map<Object,Object> condition) throws SQLException {
		if (Objects.isNull(condition)) {
			return 0;
		}
		return dictionaryMapper.updateInUseByUpDicId(condition);
	
	}
}
