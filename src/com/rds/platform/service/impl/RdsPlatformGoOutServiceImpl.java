package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformGoOutMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformGoOutModel;
import com.rds.platform.service.RdsPlatformGoOutService;

import common.Logger;

@Service("rdsPlatformGoOutService")
public class RdsPlatformGoOutServiceImpl implements RdsPlatformGoOutService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformGoOutMapper rdsPlatformGoOutMapper;
	
	public Object queryPlatformGoOuts(Object params){
		return rdsPlatformGoOutMapper.queryPlatformGoOuts(params);
	}

	@Override
	public Object queryPlatformGoOutsPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformGoOutMapper.queryPlatformGoOutsPage(params));
		result.put("total", rdsPlatformGoOutMapper.queryPlatformGoOutsPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformGoOutModel GoOut = (RdsPlatformGoOutModel)params;
			int count = 0;
			if(GoOut.getId()==null||"".equals(GoOut.getId())){
				count = rdsPlatformGoOutMapper.insert(params);
			}else{
				count = rdsPlatformGoOutMapper.update(params);
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
			int count = rdsPlatformGoOutMapper.delete(params);
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
			int count = rdsPlatformGoOutMapper.updateApproval(params);
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
