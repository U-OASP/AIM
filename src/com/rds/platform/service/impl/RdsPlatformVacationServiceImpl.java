package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformVacationMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformVacationModel;
import com.rds.platform.service.RdsPlatformVacationService;

import common.Logger;

@Service("rdsPlatformVacationService")
public class RdsPlatformVacationServiceImpl implements RdsPlatformVacationService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformVacationMapper rdsPlatformVacationMapper;
	
	public Object queryPlatformVacations(Object params){
		return rdsPlatformVacationMapper.queryPlatformVacations(params);
	}

	@Override
	public Object queryPlatformVacationsPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformVacationMapper.queryPlatformVacationsPage(params));
		result.put("total", rdsPlatformVacationMapper.queryPlatformVacationsPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformVacationModel Vacation = (RdsPlatformVacationModel)params;
			int count = 0;
			if(Vacation.getId()==null||"".equals(Vacation.getId())){
				count = rdsPlatformVacationMapper.insert(params);
			}else{
				count = rdsPlatformVacationMapper.update(params);
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
			int count = rdsPlatformVacationMapper.delete(params);
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
			int count = rdsPlatformVacationMapper.updateApproval(params);
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
