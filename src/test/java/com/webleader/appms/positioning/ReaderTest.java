package com.webleader.appms.positioning;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.positioning.Reader;
import com.webleader.appms.db.mapper.positioning.ReaderMapper;

/**
 * @className ReaderTest
 * @description 测试数据库接口 ReaderMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午4:46:54
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ReaderTest {
	
	@Autowired
	private ReaderMapper readerMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据分站编号查询分站信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String readerId = "1";
		try {
			Reader reader = readerMapper.selectByPrimaryKey(readerId);
			System.out.println(reader);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * @description 组合条件分页查询分站信息
	 */
	@Test
	public void getReaderByPageCondition(){
		Map<Object,Object> pageCondition = new HashMap<Object,Object>();
		//pageCondition.put("readerId", "1");
		//pageCondition.put("readerName", "hss1");
		pageCondition.put("readerIp", "192.168.1.123");
		pageCondition.put("readerStatus", "1");
		pageCondition.put("regionId", "1");
		pageCondition.put("pageBegin", 0);	//必须是bigint
		pageCondition.put("pageSize", 3);	//必须是bigint
		try {
			List<Reader> readers = readerMapper.getReaderByPageCondition(pageCondition);
			for (int i = 0; i < readers.size(); i++) {
				System.out.println(readers.get(i));
			}
			System.out.println(readers.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @description 统计符合条件的分站数量
	 */
	@Test
	public void getCountByConditon(){
		Map<Object,Object> condition = new HashMap<Object,Object>();
		//condition.put("readerId", "1");
		//condition.put("readerName", "hss1");
		condition.put("readerIp", "192.168.1.123");
		condition.put("readerStatus", "1");
		condition.put("regionId", "1");
		try {
			int totalCount = readerMapper.getCountByConditon(condition);
			System.out.println(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加分站
	 */
	@Test
	public void insert(){
		Reader reader = new Reader();
		reader.setReaderId("readerId");
		reader.setReaderName("添加分站");
		reader.setBatteryCapacity(5000.0); //注意类型是DOUBLE
		reader.setDeviceId("1");
		//reader.setGeoPoint(geoPoint);		//这个不会
		//reader.setGeoPointRef(geoPointRef); //这个不会
		reader.setInstallDate(Date.valueOf("2017-08-14"));
		reader.setPowerSupplyMode("1");
		reader.setReaderIp("192.168.1.123");
		reader.setReaderStatus("1");
		reader.setReaderType("1");
		reader.setRefCos(20.0);
		reader.setRefSin(30.0);
		reader.setRegionId("a");
		reader.setRfNumber(1);
		try {
			int count = readerMapper.insert(reader);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据分站编号删除分站
	 */
	@Test
	public void deleteByPrimaryKey(){
		String readerId = "readerId";
		try {
			int count = readerMapper.deleteByPrimaryKey(readerId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新分站信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		Reader reader = new Reader();
		reader.setReaderId("readerId");
		reader.setReaderName("修改分站");
		reader.setBatteryCapacity(5000.0); //注意类型是DOUBLE
		reader.setDeviceId("1");
		//reader.setGeoPoint(geoPoint);		//这个不会
		//reader.setGeoPointRef(geoPointRef); //这个不会
		reader.setInstallDate(Date.valueOf("2017-08-14"));
		reader.setPowerSupplyMode("1");
		reader.setReaderIp("192.168.1.123");
		reader.setReaderStatus("1");
		reader.setReaderType("1");
		reader.setRefCos(20.0);
		reader.setRefSin(30.0);
		reader.setRegionId("a");
		reader.setRfNumber(1);
		try {
			int count = readerMapper.updateByPrimaryKeySelective(reader);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}