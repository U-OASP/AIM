package com.rds.platform.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformLogBookMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformLogBookModel;
import com.rds.platform.service.RdsPlatformLogBookService;

import common.Logger;

@Service("rdsPlatformLogBookService")
public class RdsPlatformLogBookServiceImpl implements RdsPlatformLogBookService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformLogBookMapper rdsPlatformLogBookMapper;
	
	public Object queryPlatformLogBooks(Object params){
		return rdsPlatformLogBookMapper.queryPlatformLogBooks(params);
	}

	@Override
	public Object queryPlatformLogBooksPage(Object params) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformLogBookMapper.queryPlatformLogBooksPage(params));
		result.put("total", rdsPlatformLogBookMapper.queryPlatformLogBooksPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformLogBookModel LogBook = (RdsPlatformLogBookModel)params;
			int count = 0;
			if(LogBook.getId()==null||"".equals(LogBook.getId())){
				count = rdsPlatformLogBookMapper.insert(params);
			}else{
				count = rdsPlatformLogBookMapper.update(params);
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
			int count = rdsPlatformLogBookMapper.delete(params);
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
