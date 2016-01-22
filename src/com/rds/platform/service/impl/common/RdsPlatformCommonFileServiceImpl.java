package com.rds.platform.service.impl.common;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.common.RdsPlatformCommonFileMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.common.RdsPlatformCommonFileModel;
import com.rds.platform.service.common.RdsPlatformCommonFileService;
import common.Logger;

@Service("rdsPlatformCommonFileService")
public class RdsPlatformCommonFileServiceImpl implements RdsPlatformCommonFileService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformCommonFileMapper rdsPlatformCommonFileMapper;
	
	public Object queryPlatformCommonFiles(Object params){
		return rdsPlatformCommonFileMapper.queryPlatformCommonFiles(params);
	}

	@Override
	public Object queryPlatformCommonFilesPage(Object params) {
		return rdsPlatformCommonFileMapper.queryPlatformCommonFilesPage(params);
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformCommonFileModel CommonFile = (RdsPlatformCommonFileModel)params;
			int count = 0;
			if(CommonFile.getTid()==null||"".equals(CommonFile.getTid())){
				count = rdsPlatformCommonFileMapper.insert(params);
			}else{
				count = rdsPlatformCommonFileMapper.update(params);
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
			rdsPlatformCommonFileMapper.delete(params);
			msg.setCode("10000");
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		return msg;
	}
	
}
