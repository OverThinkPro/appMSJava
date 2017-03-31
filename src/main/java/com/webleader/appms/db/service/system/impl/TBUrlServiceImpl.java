package com.webleader.appms.db.service.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webleader.appms.db.mapper.system.TBUrlMapper;
import com.webleader.appms.db.service.system.TBUrlService;


@Service("tbUrlService")
public class TBUrlServiceImpl implements TBUrlService{
	
	@Resource
	private TBUrlMapper tbUrlMapper;
	
}
