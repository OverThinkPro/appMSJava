package com.webleader.appms.setting;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.setting.DeviceParameter;
import com.webleader.appms.db.mapper.setting.DeviceParameterMapper;

/**
 * @className DeviceParameterTest
 * @description 测试数据库接口 DeviceParameterMapper
 * @author HaoShaSha
 * @date 2017年4月15日 下午6:37:52
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DeviceParameterTest {
	
	@Autowired
	private DeviceParameterMapper deviceParameterMapper;
	
	
	/*****************START BY HaoShaSha*********/
	/*****************查询接口开始*******************/
	/** 
	 * @description 根据设备参数编号查询设备参数信息
	 */
	@Test
	public void selectByPrimaryKey(){
		String deviceParameterId = "deviceParameterId";
		try {
			DeviceParameter deviceParameter = deviceParameterMapper.selectByPrimaryKey(deviceParameterId);
			System.out.println(deviceParameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************查询接口结束*******************/
	/*****************插入接口开始*******************/
	/** 
	 * @description 添加设备参数
	 */
	@Test
	public void insert(){
		DeviceParameter deviceParameter = new DeviceParameter();
		deviceParameter.setDeviceId("deviceParameterId");
		deviceParameter.setDeviceName("添加设备参数");
		deviceParameter.setGateway("255.255.255.255");
		deviceParameter.setIpAddr("192.168.1.156");
		deviceParameter.setMacAddr("192.168.1.156");
		deviceParameter.setMask("0.0.0.0");
		deviceParameter.setModbusPort(2000); //注意类型为INTEGER
		deviceParameter.setOnDhcp(true);
		deviceParameter.setPassword("123456");
		deviceParameter.setPrintLevel(1);	//注意类型为INTEGER
		try {
			int count = deviceParameterMapper.insert(deviceParameter);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/*****************插入接口结束*******************/
	/*****************删除接口开始*******************/
	/** 
	 * @description 根据设备参数编号删除设备参数
	 */
	@Test
	public void deleteByPrimaryKey(){
		String deviceParameterId = "deviceParameterId";
		try {
			int count = deviceParameterMapper.deleteByPrimaryKey(deviceParameterId);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************删除接口结束*******************/
	/*****************更新接口开始*******************/
	/** 
	 * @description 更新设备参数信息
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		DeviceParameter deviceParameter = new DeviceParameter();
		deviceParameter.setDeviceId("deviceParameterId");
		deviceParameter.setDeviceName("修改设备参数");
		deviceParameter.setGateway("255.255.255.255");
		deviceParameter.setIpAddr("192.168.1.156");
		deviceParameter.setMacAddr("192.168.1.156");
		deviceParameter.setMask("0.0.0.0");
		deviceParameter.setModbusPort(2000); //注意类型为INTEGER
		deviceParameter.setOnDhcp(true);
		deviceParameter.setPassword("123456");
		deviceParameter.setPrintLevel(1);	//注意类型为INTEGER
		try {
			int count = deviceParameterMapper.updateByPrimaryKeySelective(deviceParameter);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*****************更新接口结束*******************/
	/*****************END BY HaoShaSha***********/
}