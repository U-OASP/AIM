package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformAlarmMapper;
import com.rds.platform.service.RdsPlatformAlarmService;
//import common.Logger;

@Service("rdsPlatformAlarmService")
public class RdsPlatformAlarmServiceImpl implements RdsPlatformAlarmService {
	
//	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformAlarmMapper rdsPlatformAlarmMapper;

	@Override
	public Object queryPlatformAlarmsPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformAlarmMapper.queryPlatformAlarmsPage(params));
		result.put("total", rdsPlatformAlarmMapper.queryPlatformAlarmsPageTotal(params));
		return result;
	}
	
	@Override
	public Object insert(Object params) {
		return rdsPlatformAlarmMapper.insert(params);
	}

	@Override
	public Object update(Object params) {
		return rdsPlatformAlarmMapper.update(params);
	}
	
}
