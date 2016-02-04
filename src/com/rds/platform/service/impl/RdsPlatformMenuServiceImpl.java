package com.rds.platform.service.impl;

import java.util.List;

import lombok.Setter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformMenuMapper;
import com.rds.platform.service.RdsPlatformMenuService;

@Service("rdsPlatformMenuService")
public class RdsPlatformMenuServiceImpl implements RdsPlatformMenuService {
	
	@Setter
	@Autowired
	private RdsPlatformMenuMapper rdsPlatformMenuMapper;

	@Override
	public List<Object> queryPlatformMenuByParentid(Object params) {
		return rdsPlatformMenuMapper.queryPlatformMenuByParentid(params);
	}

}
