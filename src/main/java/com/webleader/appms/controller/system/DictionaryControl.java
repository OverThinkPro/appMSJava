package com.webleader.appms.controller.system;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.bean.system.Dictionary;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.system.DictionaryService;
import com.webleader.appms.util.Response;

/**
 * @className MenuControl
 * @description 字典管理
 * @author HaoShaSha
 * @date 2017年5月2日 下午11:28:07
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class DictionaryControl {

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private PageConstants pageConstants;

	/** 
	 * @description 条件查询字典信息
	 * @param dictionaryId
	 * @param dictionaryName
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/dictionary/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getDictionaryListByCondition(@RequestBody Map<Object, Object> condition,@PathVariable int currentPage){
		Response response = new Response();
		List<Dictionary> dictionaryList = null;
		int totalCounts = 0;
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		try {
			dictionaryList = dictionaryService.getDicByPageCondition(condition);
			totalCounts = dictionaryService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(dictionaryList)) {
			return response.failure("查询字典失败，请重试").toSimpleResult();
		}
		return response.success().put("totalCounts", totalCounts).put("dictionaryList", dictionaryList).toCombineResult();
	}
	
	/** 
	 * @description 通过点击字典树，查询下级字典
	 * @param upDictionaryId
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value= "/base/dictionary/up/{upDictionaryId}/p/{currentPage}", method = RequestMethod.GET)
	public Map<Object, Object> getDictionaryByUpDictionaryId (@PathVariable String upDictionaryId, @PathVariable int currentPage) {
		Response response = new Response();
		Map<Object,Object> condition = new HashMap<Object, Object>();
		List<Dictionary> dictionaryList = null;
		int totalPage = 0;
		
		condition.put("upDictionaryId", upDictionaryId);
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			dictionaryList = dictionaryService.getDicByPageCondition(condition);
			totalPage = dictionaryService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(dictionaryList)) {
			return response.failure("查询字典失败，请重试").toSimpleResult();
		}
		return response.success().put("total", totalPage).put("dictionaryList", dictionaryList).toCombineResult();
	}
	
	/** 
	 * @description 点击添加时，查询得到下级字典编号
	 * @param upDictionaryId
	 * @return 
	 */
	@RequestMapping(value = "/base/dictionary/up/{upDictionaryId}", method = RequestMethod.GET)
	public Map<Object, Object> getNextId(@PathVariable String upDictionaryId){
		Response response = new Response();
		String currentDictionaryId = null;;
		try {
			currentDictionaryId = dictionaryService.getMaxDictionaryId(upDictionaryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(currentDictionaryId)) {
			return response.failure("不能得到下级字典Id").toSimpleResult();
		}
		return response.success().put("currentDictionaryId", currentDictionaryId).toCombineResult();
	}
	
	/** 
	 * @description 查询字典数
	 * @return 
	 */
	@RequestMapping(value = "/base/dictionary/dictionaryTree", method = RequestMethod.GET)
	public Map<Object, Object> getDictionaryTree () {
		Response response = new Response();
		List<Dictionary> dictionaryList = null;
		try {
			dictionaryList = dictionaryService.getDictionaryTree(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Objects.isNull(dictionaryList)) {
			return response.failure("查询字典树失败，请重试").toSimpleResult();
		}
		return response.success().put("dictionaryList", dictionaryList).toCombineResult();
	}
	
	/** 
	 * @description 添加字典
	 * @param dictionary
	 * @return 
	 */
	@RequestMapping(value = "/base/dictionary", method = RequestMethod.POST)
	public Map<Object, Object> addDictionary(@RequestBody Dictionary dictionary) {
		Response response = new Response();
		int result = 0;
		if (Objects.isNull(dictionary)) {
			return response.failure("添加字典失败，请重试").toSimpleResult();
		}
		try {
			result = dictionaryService.insert(dictionary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 0) {
			return response.failure("添加字典失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 删除字典
	 * @param dictionaryId
	 * @return 
	 */
	@RequestMapping(value = "/base/dictionary", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteDictionary(@RequestParam(value = "dictionaryIds") String dictionaryIds) {
		Response response = new Response();
		boolean result = true;
		if (Objects.isNull(dictionaryIds)) {
			return response.failure("删除菜单失败，请重试").toSimpleResult();
		}
		List<String> dictionaryIdList = java.util.Arrays.asList(dictionaryIds.split(","));
		for(String dictionaryId:dictionaryIdList){
			try {
				result = result && dictionaryService.deleteByPrimaryKey(dictionaryId) >= 0 ? true : false;
				result = result && dictionaryService.deleteByUpDictionaryId(dictionaryId)>= 0 ? true : false;
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(!result){
			return response.failure("删除字典失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改字典
	 * @param dictionary
	 * @return 
	 */
	@RequestMapping(value = "/base/dictionary", method = RequestMethod.PUT)
	public Map<Object, Object> updateDictionary(@RequestBody Dictionary dictionary) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.isNull(dictionary)) {
			return response.failure("修改字典失败，请重试").toSimpleResult();
		}
		try {
			result = dictionaryService.updateByPrimaryKeySelective(dictionary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			return response.failure("修改字典失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
}
