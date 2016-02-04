package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformEntranceMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformEntranceModel;
import com.rds.platform.service.RdsPlatformEntranceService;

import common.Logger;

@Service("rdsPlatformEntranceService")
public class RdsPlatformEntranceServiceImpl implements RdsPlatformEntranceService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformEntranceMapper rdsPlatformEntranceMapper;
	
	public Object queryPlatformEntrances(Object params){
		return rdsPlatformEntranceMapper.queryPlatformEntrances(params);
	}

	@Override
	public Object queryPlatformEntrancesPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformEntranceMapper.queryPlatformEntrancesPage(params));
		result.put("total", rdsPlatformEntranceMapper.queryPlatformEntrancesPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformEntranceModel entrance = (RdsPlatformEntranceModel)params;
			int count = 0;
			if(entrance.getId()==null||"".equals(entrance.getId())){
				count = rdsPlatformEntranceMapper.insert(params);
			}else{
				count = rdsPlatformEntranceMapper.update(params);
			}
			
			if(count>0){
				msg.setCode("10000");
			}else{
				msg.setCode("10001");
			}
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public Object delete(String params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformEntranceMapper.delete(params);
			if(count>0){
				msg.setCode("10000");
			}else{
				msg.setCode("10001");
			}
			
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		return msg;
	}
	@Override
	public Object updateOutEntrances(String params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformEntranceMapper.updateOutEntrances(params);
			if(count>0){
				msg.setCode("10000");
			}else{
				msg.setCode("10001");
			}
			
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		return msg;
	}
	
	
}
