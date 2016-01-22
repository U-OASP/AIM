package com.rds.platform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformOfficeMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformSeatModel;
import com.rds.platform.service.RdsPlatformOfficeService;

import common.Logger;

@Service("rdsPlatformOfficeService")
public class RdsPlatformOfficeServiceImpl implements RdsPlatformOfficeService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformOfficeMapper rdsPlatformOfficeMapper;
	
	public Object queryPlatformOffices(Object params){
		return rdsPlatformOfficeMapper.queryPlatformOffices(params);
	}
	
	public Object queryPlatformOfficesExists(Object params){
		return rdsPlatformOfficeMapper.queryPlatformOfficesExists(params);
	}
	
	public Object queryPlatformSeats(Object params){
		return rdsPlatformOfficeMapper.queryPlatformSeats(params);
	}

	@Override
	public Object queryPlatformSeatsPage(Object params) {
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		result.put("data", rdsPlatformOfficeMapper.queryPlatformSeatsPage(params));
		result.put("total", rdsPlatformOfficeMapper.queryPlatformSeatsPageTotal(params));
		return result;
	}

	@Override
	public Object updateInitSeat(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> seat = (HashMap<String, String>)params;
			int count = 0;
			
			int size = Integer.parseInt(seat.get("count"));
			String prefix = seat.get("prefix");
			String officeid = seat.get("officeid");
			List<Object> initlist = new ArrayList<Object>();
			for(int i=0;i<size;i++){
				RdsPlatformSeatModel seatModel = new RdsPlatformSeatModel();
				seatModel.setOfficeid(officeid);
				seatModel.setSeatname(prefix+String.format("%03d",i+1));
				initlist.add(seatModel);
			}
			
			count = rdsPlatformOfficeMapper.updateInitSeat(initlist);
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
			int count = rdsPlatformOfficeMapper.delete(params);
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
	public Object queryPlatformSeatsStatusPage(Object params) {
		Map<String, Object> result = new HashMap<String,Object>();
		
		result.put("data", rdsPlatformOfficeMapper.queryPlatformSeatsStatusPage(params));
		result.put("total", rdsPlatformOfficeMapper.queryPlatformSeatsStatusPageTotal(params));
		return result;
	}

	@Override
	public Object insertSeat(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformOfficeMapper.insertSeat(params);
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
	public Object updateSeat(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformOfficeMapper.updateSeat(params);
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
