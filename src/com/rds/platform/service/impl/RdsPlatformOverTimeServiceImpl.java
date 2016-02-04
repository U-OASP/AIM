package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformOverTimeMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformOverTimeModel;
import com.rds.platform.service.RdsPlatformOverTimeService;

import common.Logger;

@Service("rdsPlatformOverTimeService")
public class RdsPlatformOverTimeServiceImpl implements RdsPlatformOverTimeService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformOverTimeMapper rdsPlatformOverTimeMapper;
	
	public Object queryPlatformOverTimes(Object params){
		return rdsPlatformOverTimeMapper.queryPlatformOverTimes(params);
	}

	@Override
	public Object queryPlatformOverTimesPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformOverTimeMapper.queryPlatformOverTimesPage(params));
		result.put("total", rdsPlatformOverTimeMapper.queryPlatformOverTimesPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformOverTimeModel OverTime = (RdsPlatformOverTimeModel)params;
			int count = 0;
			if(OverTime.getId()==null||"".equals(OverTime.getId())){
				count = rdsPlatformOverTimeMapper.insert(params);
			}else{
				count = rdsPlatformOverTimeMapper.update(params);
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
			int count = rdsPlatformOverTimeMapper.delete(params);
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
	public Object updateApproval(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformOverTimeMapper.updateApproval(params);
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
	public Object updateSure(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformOverTimeMapper.updateSure(params);
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
	public Object updateEndTime(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformOverTimeMapper.updateEndTime(params);
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
