package com.rds.platform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rds.code.utils.uuid.UUIDUtil;
import com.rds.platform.mapper.RdsPlatformTaskMapper;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformTaskMainModel;
import com.rds.platform.model.RdsPlatformTaskSubModel;
import com.rds.platform.service.RdsPlatformTaskService;

import common.Logger;

@Service("rdsPlatformTaskService")
public class RdsPlatformTaskServiceImpl implements RdsPlatformTaskService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformTaskMapper rdsPlatformTaskMapper;
	
	@Override
	public Object queryPlatformSubTasks(Object params){
		return rdsPlatformTaskMapper.queryPlatformSubTasks(params);
	}

	@Override
	public Object queryPlatformMainTasksPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformTaskMapper.queryPlatformMainTasksPage(params));
		result.put("total", rdsPlatformTaskMapper.queryPlatformMainTasksPageTotal(params));
		return result;
	}

	@Override
	public Object updateMainTask(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformTaskMainModel taskmain = (RdsPlatformTaskMainModel)params;
//			int count = 0;
			if(taskmain.getId()==null||"".equals(taskmain.getId())){
				taskmain.setId(UUIDUtil.getUUID());
//				count = 
				rdsPlatformTaskMapper.insertMainTask(params);
			}else{
//				count = 
				rdsPlatformTaskMapper.updateMainTask(params);
			}
			
//			if(count>0){
				msg.setCode("10000");
//			}else{
//				msg.setCode("10001");
//			}
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public Object deleteMainTask(String params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
//			int count = 
			rdsPlatformTaskMapper.deleteMainTask(params);
//			if(count>0){
				msg.setCode("10000");
//			}else{
//				msg.setCode("10001");
//			}
			
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		return msg;
	}

	@Override
	public Object updateMainTaskApproval(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformTaskMapper.updateMainTaskApproval(params);
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
	@Transactional
	public Object updateSubTask(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformTaskSubModel submain = (RdsPlatformTaskSubModel)params;
//			int count = 0;
			if(submain.getId()==null||"".equals(submain.getId())){
				submain.setId(UUIDUtil.getUUID());
				String [] userids = submain.getUserid().split(",");
				
				String id = submain.getId();
				List<Object> arraylist = new ArrayList<>();
				
				for (String string : userids) {
					Map<String, Object> ps = new HashMap<>();
					ps.put("subtaskid", id);
					ps.put("userid", string);
					arraylist.add(ps);
				}
				rdsPlatformTaskMapper.deleteSubUsers(id);
				rdsPlatformTaskMapper.updateSubUsers(arraylist);
				rdsPlatformTaskMapper.insertSubTask(params);
			}else{
				String [] userids = submain.getUserid().split(",");
				
				String id = submain.getId();
				List<Object> arraylist = new ArrayList<>();
				
				for (String string : userids) {
					Map<String, Object> ps = new HashMap<>();
					ps.put("subtaskid", id);
					ps.put("userid", string);
					arraylist.add(ps);
				}
				rdsPlatformTaskMapper.deleteSubUsers(id);
				rdsPlatformTaskMapper.updateSubUsers(arraylist);
				rdsPlatformTaskMapper.updateSubTask(params);
			}
			
//			if(count>0){
				msg.setCode("10000");
//			}else{
//				msg.setCode("10001");
//			}
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		
		return msg;
	}
	
	@Override
	public Object updateSubsComplete(String ids,String userid) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			
			try {
				Map<String, Object> params = new HashMap<>();
				params.put("userid", userid);
				params.put("ids", ids);
				int count = rdsPlatformTaskMapper.updateSubsComplete(params);
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
			
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		return msg;
	}
	
	@Override
	public Object updateTaskFeedBack(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = rdsPlatformTaskMapper.updateTaskFeedBack(params);
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
	public Object queryPlatformTaskFeedBack(Object params){
		return rdsPlatformTaskMapper.queryPlatformTaskFeedBack(params);
	}
	
	@Override
	public Object updateSure(String params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			int count = 
			rdsPlatformTaskMapper.updateSure(params);
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
	public Object queryPlatformSubTasksByUser(Object params) {
		return rdsPlatformTaskMapper.queryPlatformSubTasksByUser(params);
	}
	
}
