package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformSettledMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformSettledModel;
import com.rds.platform.service.RdsPlatformSettledService;

import common.Logger;

@Service("rdsPlatformSettledService")
public class RdsPlatformSettledServiceImpl implements RdsPlatformSettledService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformSettledMapper rdsPlatformSettledMapper;
	
	public Object queryPlatformSettleds(Object params){
		return rdsPlatformSettledMapper.queryPlatformSettleds(params);
	}

	@Override
	public Object queryPlatformSettledsPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformSettledMapper.queryPlatformSettledsPage(params));
		result.put("total", rdsPlatformSettledMapper.queryPlatformSettledsPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformSettledModel Settled = (RdsPlatformSettledModel)params;
			int count = 0;
			if(Settled.getId()==null||"".equals(Settled.getId())){
				count = rdsPlatformSettledMapper.insert(params);
			}else{
				count = rdsPlatformSettledMapper.update(params);
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
			int count = rdsPlatformSettledMapper.delete(params);
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
			int count = rdsPlatformSettledMapper.updateApproval(params);
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
