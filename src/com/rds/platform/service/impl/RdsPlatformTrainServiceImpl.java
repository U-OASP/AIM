package com.rds.platform.service.impl;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformTrainMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformTrainModel;
import com.rds.platform.service.RdsPlatformTrainService;

import common.Logger;

@Service("rdsPlatformTrainService")
public class RdsPlatformTrainServiceImpl implements RdsPlatformTrainService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformTrainMapper rdsPlatformTrainMapper;
	
	public Object queryPlatformTrains(Object params){
		return rdsPlatformTrainMapper.queryPlatformTrains(params);
	}

	@Override
	public Object queryPlatformTrainsPage(Object params) {
		return rdsPlatformTrainMapper.queryPlatformTrainsPage(params);
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformTrainModel Train = (RdsPlatformTrainModel)params;
			int count = 0;
			if(Train.getTid()==null||"".equals(Train.getTid())){
				count = rdsPlatformTrainMapper.insert(params);
			}else{
				count = rdsPlatformTrainMapper.update(params);
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
			rdsPlatformTrainMapper.delete(params);
			msg.setCode("10000");
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		return msg;
	}

	@Override
	public Object insertTrainFile(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformTrainMapper.insertTrainFile(params);
			
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
	public Object queryPlatformTrainFiles(Object params) {
		return rdsPlatformTrainMapper.queryPlatformTrainFiles(params);
	}

	
}
