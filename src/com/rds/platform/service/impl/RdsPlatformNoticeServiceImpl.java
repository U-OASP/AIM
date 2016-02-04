package com.rds.platform.service.impl;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformNoticeMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformNoticeModel;
import com.rds.platform.service.RdsPlatformNoticeService;
import common.Logger;

@Service("rdsPlatformNoticeService")
public class RdsPlatformNoticeServiceImpl implements RdsPlatformNoticeService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformNoticeMapper rdsPlatformNoticeMapper;
	
	public Object queryPlatformNotices(Object params){
		return rdsPlatformNoticeMapper.queryPlatformNotices(params);
	}

	@Override
	public Object queryPlatformNoticesPage(Object params) {
		return rdsPlatformNoticeMapper.queryPlatformNoticesPage(params);
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformNoticeModel notice = (RdsPlatformNoticeModel)params;
			int count = 0;
			if(notice.getId()==null||"".equals(notice.getId())){
				count = rdsPlatformNoticeMapper.insert(params);
			}else{
				count = rdsPlatformNoticeMapper.update(params);
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
			int count = rdsPlatformNoticeMapper.delete(params);
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
