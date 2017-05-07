package com.webleader.appms.controller.reader;

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

import com.webleader.appms.bean.positioning.Reader;
import com.webleader.appms.common.PageConstants;
import com.webleader.appms.db.service.positioning.ReaderService;
import com.webleader.appms.util.PointSinCos;
import com.webleader.appms.util.Response;

/**
 * @className ReaderControl
 * @description 分站管理
 * @author ding
 * @date 2017年5月3日 下午3:59:39
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/main")
public class ReaderControl {
	
	@Autowired
	private ReaderService readerService;
	@Autowired
	private PageConstants pageConstants;
	@Autowired
	private PointSinCos pointSincos;
	
	/** 
	 * @description 组合条件分页查询，分站信息（区域类型，分站名称，分站IP，分站状态，区域编号， 起始记录数，每页的记录数）
	 * @param condition
	 * @param currentPage
	 * @return 
	 */
	@RequestMapping(value = "/base/reader/p/{currentPage}", method = RequestMethod.POST)
	public Map<Object, Object> getReaderListByCondition(@RequestBody Map<Object, Object> condition, 
			@PathVariable int currentPage) {
		Response response = new Response();
		List<Map<Object, Object>> readerList = null;
		int total = 0;
		
		condition.put("pageBegin", pageConstants.getRecordNums(currentPage));
		condition.put("pageSize", pageConstants.getPageSize());
		
		try {
			readerList = readerService.getReaderByPageCondition2(condition);
			total = readerService.getCountByConditon(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Objects.isNull(readerList)) {
			return response.failure("查询分站失败，请重试").toSimpleResult();
		}
		return response.success().put("total", total).put("readerList", readerList).toCombineResult();
	}
	
	/** 
	 * @description 添加分站信息
	 * @param reader
	 * @return 
	 */
	@RequestMapping(value = "/base/reader", method = RequestMethod.POST)
	public Map<Object, Object> insertReader(@RequestBody Reader reader) {
		Response response = new Response();
		int result = 0;
		Map<String, Double> sinCos = null;
		sinCos = pointSincos.getSinCos(reader.getGeoPoint().toString(), reader.getGeoPointRef().toString());
		reader.setRefSin(sinCos.get("sin"));
		reader.setRefCos(sinCos.get("cos"));
		
		try {
			result = readerService.insert(reader);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("添加分站失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 修改分站信息
	 * @param reader
	 * @return 
	 */
	@RequestMapping(value = "/base/reader", method = RequestMethod.PUT)
	public Map<Object, Object> updateReader(@RequestBody Reader reader) {
		Response response = new Response();
		int result = 0;
		
		if (Objects.nonNull(reader.getGeoPoint()) && Objects.nonNull(reader.getGeoPointRef())) {
			Map<String, Double> sinCos = null;
			sinCos = pointSincos.getSinCos(reader.getGeoPoint().toString(), reader.getGeoPointRef().toString());
			reader.setRefSin(sinCos.get("sin"));
			reader.setRefCos(sinCos.get("cos"));
		}
		
		try {
			result = readerService.updateByPrimaryKeySelective(reader);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result <= 0) {
			return response.failure("修改分站失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 通过readerID，删除分站
	 * @param readerId
	 * @return 
	 */
	@RequestMapping(value = "/base/reader/{readerId}", method = RequestMethod.DELETE)
	public Map<Object, Object> deleteReader(@PathVariable String readerId) {
		Response response = new Response();
		int result = 0;
		
		try {
			result = readerService.deleteByPrimaryKey(readerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result <= 0) {
			return response.failure("删除分站失败，请重试").toSimpleResult();
		}
		return response.success().put("result", result).toCombineResult();
	}
	
	/** 
	 * @description 查询所有的分站坐标信息
	 * @return 
	 */
	@RequestMapping(value = "/base/map/reader", method = RequestMethod.GET)
	public Map<Object, Object> getReaderMapList() {
		Response response = new Response();
		List<Map<Object, Object>> readerList = null;
		
		try {
			readerList = readerService.getReaderMapList(new HashMap<Object, Object>());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Objects.isNull(readerList)) {
			return response.failure("查询分站列表失败，请重试").toSimpleResult();
		}
		return response.success().put("readerList", readerList).toCombineResult();
	}
	
	/** 
	 * @description 通过geoPoint， 判断该点，是否在区域内
	 * @param geoPoint
	 * @return 
	 */
	@RequestMapping(value = "/base/reader/range", method = RequestMethod.GET)
	public Map<Object, Object> getRegionId(@RequestParam String geoPoint) {
		Response response = new Response();
		List<Map<Object, Object>> resultList = null;
		
		try {
			resultList = readerService.getIsInRegion(geoPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < resultList.size(); i++) {
			if ((boolean) resultList.get(i).get("inRegion")){
				return response.success().put("regionId", resultList.get(i).get("regionId").toString()).toCombineResult();
			}
		}
		return response.failure("查询所属区域失败，请重试").toSimpleResult();
	}
}
