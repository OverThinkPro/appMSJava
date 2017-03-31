package com.webleader.appms.db.service.setting.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webleader.appms.bean.setting.Coalmine;
import com.webleader.appms.db.mapper.setting.CoalmineMapper;
import com.webleader.appms.db.service.setting.CoalmineService;

/**
 * @ClassName CoalmineServerImpl
 * @Description 煤矿基本信息
 * @author ding
 * @Date 2017年3月31日 上午10:07:05
 * @version 1.0.0
 */

@Service("coalmieService")
public class CoalmineServerImpl implements CoalmineService{
	
	@Resource
	private CoalmineMapper coalmineMapper;

	public List<Coalmine> getCoalmineList(){
		
		List<Coalmine> coalmineList = coalmineMapper.getCoalmineList();
		return coalmineList;
		
	}
}
