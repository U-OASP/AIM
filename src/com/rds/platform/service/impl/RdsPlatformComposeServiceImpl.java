package com.rds.platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rds.platform.mapper.RdsPlatformComposeMapper;
import com.rds.platform.model.RdsPlatformComposeResultModel;
import com.rds.platform.model.RdsPlatformComposeUsersModel;
import com.rds.platform.model.RdsPlatformMsgModel;
import com.rds.platform.model.RdsPlatformComposeModel;
import com.rds.platform.service.RdsPlatformComposeService;

import common.Logger;
@Transactional
@Service("rdsPlatformComposeService")
public class RdsPlatformComposeServiceImpl implements RdsPlatformComposeService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformComposeMapper rdsPlatformComposeMapper;
	
	public Object queryPlatformComposes(Object params){
		return rdsPlatformComposeMapper.queryPlatformComposes(params);
	}

	@Override
	public Object queryPlatformComposesPage(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformComposeMapper.queryPlatformComposesPage(params));
		result.put("total", rdsPlatformComposeMapper.queryPlatformComposesPageTotal(params));
		return result;
	}

	@Override
	public Object update(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			RdsPlatformComposeModel Compose = (RdsPlatformComposeModel)params;
			int count = 0;
			if(Compose.getId()==null||"".equals(Compose.getId())){
				count = rdsPlatformComposeMapper.insert(params);
			}else{
				count = rdsPlatformComposeMapper.update(params);
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
			int count = rdsPlatformComposeMapper.delete(params);
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
			int count = rdsPlatformComposeMapper.updateApproval(params);
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
	public Object updaetInitCompose(Map<String, String> params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
			/**初始化信息*/
			Map<String, String> init = rdsPlatformComposeMapper.queryComposeInit();
			Map<Integer, String> users = this.composeUsersToMap();
			
			//一次生成多少批次
			Integer p_lot = Integer.parseInt(params.get("lot"));
			//第一批执行
			Integer lot = Integer.parseInt(init.get("LOT")==null?"0":init.get("LOT"));
			//下次执行时间
			String nexttime = init.get("NEXTTIME")==null?"2015-12-05":init.get("NEXTTIME");
			//多少个星期一次循环
			Integer step = Integer.parseInt(init.get("STEP"));
			//循环人数
			Integer pda = Integer.parseInt(init.get("PDA"));
			
			//保存数据库
			List<RdsPlatformComposeResultModel> results = new ArrayList<RdsPlatformComposeResultModel>();
			for(int m=0;m<p_lot;m++){
				++lot;
				
				Map<String, Object> i_params = new HashMap<String,Object>();
				String day = nexttime;
				int size = step*7;
				i_params.put("day", day);
				i_params.put("size", size);
				/**日期表*/
				List<RdsPlatformComposeModel> composes = rdsPlatformComposeMapper.queryComposes(i_params);
				int first = lot%pda==0?3:lot%pda;
				
				for(int i=1;i<=composes.size();i++){
					RdsPlatformComposeModel model = composes.get(i-1);
					String id = model.getId();
					//1非节假日，0节假日
					String flag =  model.getFlag();
					
					if(flag.equals("1")){
						RdsPlatformComposeResultModel resultModel = new RdsPlatformComposeResultModel();
						resultModel.setComposeid(id);
						resultModel.setUsername(users.get(first));
						resultModel.setFlag("2");
						results.add(resultModel);
						
					}else if(flag.equals("0")){
						RdsPlatformComposeResultModel resultModel = new RdsPlatformComposeResultModel();
						resultModel.setComposeid(id);
						resultModel.setUsername(users.get(first));
						resultModel.setFlag("1");
						results.add(resultModel);
						if(first==pda){
							first = 1;
						}else{
							first++;
						}
						resultModel = new RdsPlatformComposeResultModel();
						resultModel.setComposeid(id);
						resultModel.setUsername(users.get(first));
						resultModel.setFlag("2");
						results.add(resultModel);
					}
					if(first==pda){
						first = 1;
					}else{
						first++;
					}
				}
				nexttime = getNextTime(nexttime, size);
			}
			
			Map<String, Object> init_params = new HashMap<String,Object>();
			init_params.put("lot", lot);
			init_params.put("nexttime", nexttime);
			
			rdsPlatformComposeMapper.insertComposeResult(results);
			rdsPlatformComposeMapper.updateComposeInit(init_params);
			
			msg.setCode("10000");
		} catch (Exception e) {
			logger.error(e);
			msg.setCode("10001");
			msg.setMessage(e.getMessage());
		}
		
		return msg;
	}
	
	private Map<Integer, String> composeUsersToMap(){
		
		/**值班人员*/
		List<RdsPlatformComposeUsersModel> users = rdsPlatformComposeMapper.queryComposeUsers();
		
		Map<Integer, String> result = new HashMap<Integer,String>();
		for (RdsPlatformComposeUsersModel model : users) {
			result.put(model.getId(),model.getName());
		}
		return result;
	}
	
	private String getNextTime(String now,int step){
		Calendar calendar = Calendar.getInstance();
		
		String []input = now.split("-");
		calendar.set(Integer.parseInt(input[0]),Integer.parseInt(input[1])-1,Integer.parseInt(input[2]));
		SimpleDateFormat s=new SimpleDateFormat("yyyy'-'MM'-'dd");
		calendar.add(Calendar.DATE, step);
		return s.format(calendar.getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(1%3);
		
		Calendar calendar = Calendar.getInstance();
		
		String []input ="2015-12-05".split("-");
		calendar.set(Integer.parseInt(input[0]),Integer.parseInt(input[1])-1,Integer.parseInt(input[2]));
		SimpleDateFormat s=new SimpleDateFormat("yyyy'-'MM'-'dd");
		System.out.println(s.format(calendar.getTime()));
		calendar.add(Calendar.DATE, 28);
		System.out.println(s.format(calendar.getTime()));
	}

	@Override
	public Object queryPlatformComposeHolidays(Object params) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", rdsPlatformComposeMapper.queryPlatformComposeHolidays(params));
		result.put("total", rdsPlatformComposeMapper.queryPlatformComposeHolidaysTotal(params));
		return result;
	}
	
	@Override
	public Object updatePlatformComposeDownAndUp(Object params) {
		RdsPlatformMsgModel msg = new RdsPlatformMsgModel();
		try {
//			int count = 
			rdsPlatformComposeMapper.updatePlatformComposeDownAndUp(params);
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
	
}
