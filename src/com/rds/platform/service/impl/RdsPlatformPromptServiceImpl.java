package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformPromptMapper;
import com.rds.platform.service.RdsPlatformPromptService;

@Service("rdsPlatformPromptService")
public class RdsPlatformPromptServiceImpl implements RdsPlatformPromptService {
	
	@Setter
	@Autowired
	private RdsPlatformPromptMapper rdsPlatformPromptMapper;

	@Override
	public Object queryPlatformPromptIOISPage(Object params) {
		Object result =  rdsPlatformPromptMapper.queryPlatformPromptIOISPage(params);
		Object count = rdsPlatformPromptMapper.queryPlatformPromptIOISPageCount(params);
		
		Map<String, Object> r_m = new HashMap<String, Object>();
		r_m.put("total", count);
		r_m.put("data", result);
		return r_m;
	}

}
