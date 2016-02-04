package com.rds.platform.service.impl;

import lombok.Setter;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rds.platform.mapper.RdsPlatformCheckingMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.service.RdsPlatformCheckingService;

import common.Logger;

@Transactional
@Service("rdsPlatformCheckingService")
public class RdsPlatformCheckingServiceImpl implements RdsPlatformCheckingService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformCheckingMapper rdsPlatformCheckingMapper;
	
	public Object queryPlatformCheckings(Object params){
		return rdsPlatformCheckingMapper.queryPlatformCheckings(params);
	}

	@Override
	public Object queryPlatformCheckingsPage(Object params) {
		return rdsPlatformCheckingMapper.queryPlatformCheckingsPage(params);
	}

	@Override
	public Object updateCheckingIn(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformCheckingMapper.updateCheckingIn(params);
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
	public Object updateCheckingOut(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformCheckingMapper.updateCheckingOut(params);
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
	public Object queryPlatformCheckingTotal(Object params) {
		return rdsPlatformCheckingMapper.queryPlatformCheckingTotal(params);
	}

	@Override
	public Object queryPlatformCheckingTotalDetails(Object params) {
		// TODO Auto-generated method stub
		return rdsPlatformCheckingMapper.queryPlatformCheckingTotalDetials(params);
	}
	
	@Override
	public Object updatePlatformCheckingValues(JSONArray jsons) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			for (Object object : jsons) {
				rdsPlatformCheckingMapper.updatePlatformCheckingValues(object);
			}
			
			msg.setCode("10000");
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		
		return msg;
	}

}
