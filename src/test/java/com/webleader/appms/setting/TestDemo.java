package com.webleader.appms.setting;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webleader.appms.bean.setting.Coalmine;
import com.webleader.appms.db.service.setting.CoalmineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDemo {
	
	@Autowired
	private CoalmineService coalmineService;
	
	@Test
	public void getCoalmine(){
		List<Coalmine> coalmineList = coalmineService.getCoalmineList();
		System.out.println(coalmineList.size());
	}
	
}