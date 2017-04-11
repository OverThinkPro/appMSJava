package com.webleader.appms.db.service.setting.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webleader.appms.db.mapper.setting.CoalmineMapper;
import com.webleader.appms.db.service.setting.CoalmineService;

/**
 * @ClassName CoalmineServerImpl
 * @Description 煤矿基本信息
 * @author ding
 * @Date 2017年3月31日 上午10:07:05
 * @version 1.0.0
 */

@Service("coalmineService")
public class CoalmineServiceImpl implements CoalmineService{
	
	@Resource
	private CoalmineMapper coalmineMapper;

}
