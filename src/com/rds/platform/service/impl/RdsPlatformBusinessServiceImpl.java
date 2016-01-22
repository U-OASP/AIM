package com.rds.platform.service.impl;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformBusinessMapper;
import com.rds.platform.model.RdsPlatformBusinessModel;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.service.RdsPlatformBusinessService;
import common.Logger;

@Service("rdsPlatformBusinessService")
public class RdsPlatformBusinessServiceImpl implements
		RdsPlatformBusinessService {
	
	@Setter
	@Autowired
	private RdsPlatformBusinessMapper rdsPlatformBusinessMapper;
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Object queryPlatformBusiness(Object params) {
		return rdsPlatformBusinessMapper.queryPlatformBusiness(params);
	}
	
	@Override
	public Object queryPlatformBusinessPage(Object params) {
		return rdsPlatformBusinessMapper.queryPlatformBusinessPage(params);
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformBusinessModel business = (RdsPlatformBusinessModel)params;
			int count = 0;
			if(business.getId()==null||"".equals(business.getId())){
				count = rdsPlatformBusinessMapper.insert(params);
			}else{
				count = rdsPlatformBusinessMapper.update(params);
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
			int count = rdsPlatformBusinessMapper.delete(params);
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
