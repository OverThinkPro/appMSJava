package com.webleader.appms.positioning;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.positioning.Region;
import com.webleader.appms.db.mapper.positioning.RegionMapper;

/**
 * @className RegionTest
 * @description 测试数据库接口 RegionMapper
 * @author HaoShaSha
 * @date 2017年4月14日 下午6:00:21
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RegionTest {
	
	@Autowired
	private RegionMapper regionMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	
	/** 
	 * @description 主键查询区域信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String regionId = "a";
		try {
			Region region = regionMapper.selectByPrimaryKey(regionId);
			System.out.println(region);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询区域信息(区域名称，区域类型， 起始记录数，每页的记录数)
	 */
	@Test
	public void getRegionByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		pageCondition.put("regionType", "井口区域");
		//pageCondition.put("regionName", "a工作区");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Region> regions = regionMapper.getRegionByPageCondition(pageCondition);
			System.out.println(regions.size());
			System.out.println(regions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的区域数量(区域名称，区域类型)
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		condition.put("regionType", "井口区域");
		//pageCondition.put("regionName", "a工作区");
		try {
			int totalCount = regionMapper.getCountByConditon(condition);
			System.out.println(totalCount);
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
		Region region = new Region();
		region.setRegionId("region");
		region.setRegionName("region");
		region.setRegionMaxPeople(12);
		region.setRegionType("井口区域");
		region.setDescription("测试区域insert");
		//region.setGeoPolygon("");   //这个不会
		region.setRemark("");
		try {
			int count = regionMapper.insert(region);
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
		String regionId = "region";
		try {
			int count = regionMapper.deleteByPrimaryKey(regionId);
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
		Region region = new Region();
		region.setRegionId("region");
		region.setRegionName("region");
		region.setRegionMaxPeople(12);
		region.setRegionType("井口区域");
		region.setDescription("测试区域update");
		//region.setGeoPolygon("");//这个不会
		region.setRemark("");
		try {
			int count = regionMapper.updateByPrimaryKeySelective(region);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}