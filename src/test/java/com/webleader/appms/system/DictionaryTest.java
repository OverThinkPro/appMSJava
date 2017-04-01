package com.webleader.appms.system;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.system.Dictionary;
import com.webleader.appms.db.mapper.system.DictionaryMapper;


/**
 * @className DictionaryTest
 * @description 测试数据库接口 DictionaryMapper
 * @author HaoShaSha
 * @date 2017年4月1日 下午5:10:03
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DictionaryTest {
	
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	
	/*****************START BY HaoShaSha*********/
	
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据字典编码查询字典名称 
	 */
	@Test
	public void getNameByCode(){
		String dictionaryId = "10";
		try {
			String dictioanryName = dictionaryMapper.getNameByCode(dictionaryId);
			System.out.println(dictioanryName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 根据字典名称查询字典编码
	 */
	@Test
	public void getCodeByName(){
		String dictioanryName = "dictioanryNames";
		try {
			String dictionaryId = dictionaryMapper.getCodeByName(dictioanryName);
			System.out.println(dictionaryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @description 根据数字字典编号查询数字字典信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String dictionaryId = "10";
		try {
			Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(dictionaryId);
			System.out.println(dictionary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据上级数字字典编号查询子数字字典
	 */
	@Test
	public void getDicByUpDicId(){
		String upDictionaryId = "1";
		try {
			List<Dictionary> dictionary = dictionaryMapper.getDicByUpDicId(upDictionaryId);
			System.out.println(dictionary.size());
			System.out.println(dictionary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 查询一级数字字典
	 */
	@Test
	public void getDicTree(){
		try {
			List<Dictionary> urlTree = dictionaryMapper.getDicTree();
			System.out.println(urlTree);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询数字字典信息
	 */
	@Test
	public void getDicByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("upDictionaryId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Dictionary> dictionarys = dictionaryMapper.getDicByPageCondition(pageCondition);
			System.out.println(dictionarys.size());
			System.out.println(dictionarys);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的数字字典数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("upDictionaryId", "1");
		try {
			int totalCount = dictionaryMapper.getCountByConditon(pageCondition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * @description 根据上级数字字典下的子数字字典的最大编号
	 */
	@Test
	public void getMaxDicId(){
		String upDictionaryId = "1";
		try {
			String maxId = dictionaryMapper.getMaxDicId(upDictionaryId);
			System.out.println(maxId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加数字字典
	 */
	@Test
	public void insert(){
		Dictionary dictionary = new Dictionary();
		dictionary.setDictionaryId("1000001");
		dictionary.setDictionaryName("添加数字字典");
		dictionary.setUpDictionaryId("1");
		dictionary.setEnglistName("EnglishName");
		dictionary.setInUse("1");
		try {
			int count = dictionaryMapper.insert(dictionary);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	/** 
	 * @description 选择性的添加数字字典（同insert）
	 */
	@Test
	public void insertSelective(){
		Dictionary dictionary = new Dictionary();
		dictionary.setDictionaryId("1000002");
		dictionary.setDictionaryName("添加数字字典2");
		dictionary.setUpDictionaryId("1");
		dictionary.setEnglistName("EnglishName");
		dictionary.setInUse("1");
		try {
			int count = dictionaryMapper.insert(dictionary);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据数字字典编号删除数字字典
	 */
	@Test
	public void deleteByPrimaryKey(){
		String dictionaryId = "1000001";
		try {
			int count = dictionaryMapper.deleteByPrimaryKey(dictionaryId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 根据上级数字字典编号删除数字字典 
	 */
	@Test
	public void deleteByUpDicId() {
		String upDictionaryId="1";
		try {
			int count = dictionaryMapper.deleteByUpDicId(upDictionaryId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新数字字典信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Dictionary dictionary = new Dictionary();
		dictionary.setDictionaryId("1000002");
		dictionary.setDictionaryName("修改数字字典2");
		dictionary.setUpDictionaryId("1");
		dictionary.setEnglistName("English");
		dictionary.setInUse("1");
		try {
			int count = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}