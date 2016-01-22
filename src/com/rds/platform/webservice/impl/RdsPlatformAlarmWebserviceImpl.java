package com.rds.platform.webservice.impl;


import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.model.RdsPlatformAlarmModel;
import com.rds.platform.service.RdsPlatformAlarmService;
import com.rds.platform.webservice.RdsPlatformAlarmWebService;
import com.rds.platform.webservice.model.RdsPlatformWsResultModel;

/**
 * 告警ws处理接口
 * 
 * restful版
 * 
 * @author chenwei
 *
 */
@Service("rdsPlatformAlarmWebService")
public class RdsPlatformAlarmWebserviceImpl implements RdsPlatformAlarmWebService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 818747165881836701L;
	
	private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformAlarmService rdsPlatformAlarmService;

	@SuppressWarnings("rawtypes")
	@Override
	public RdsPlatformWsResultModel sendAlarms(String alarms) {
		RdsPlatformWsResultModel model = new RdsPlatformWsResultModel();
		
		String resultcode = "0000"; 
		String errorMsg = null;
		Integer data = null;
		try {
			JSONArray as = JSONArray.fromObject(alarms);
			if(as.size()>=20){
				resultcode = "9911"; 
				errorMsg = "超过告警数量最大值";
			}else{
				for (Object object : as) {
					Class cl = RdsPlatformAlarmModel.class;
					RdsPlatformAlarmModel mod = (RdsPlatformAlarmModel)JSONObject.toBean((JSONObject)object,cl);
					rdsPlatformAlarmService.insert(mod);
				}
				data = as.size();
			}
		} catch (Exception e) {
			resultcode = "9910";
			errorMsg = "内部未知错误";
			logger.error(e.getMessage());
		}
		model.setResultCode(resultcode);
		model.setErrorMsg(errorMsg);
		model.setData(data);
		return model;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public RdsPlatformWsResultModel updateAlarms(String alarm) {
		RdsPlatformWsResultModel model = new RdsPlatformWsResultModel();
		
		String resultcode = "0000"; 
		String errorMsg = null;
		Integer data = null;
		try {
			JSONObject object = JSONObject.fromObject(alarm);
			Class cl = RdsPlatformAlarmModel.class;
			rdsPlatformAlarmService.update((RdsPlatformAlarmModel)JSONObject.toBean((JSONObject)object,cl));

		} catch (Exception e) {
			resultcode = "9910";
			errorMsg = "内部未知错误";
			logger.error(e.getMessage());
		}
		model.setResultCode(resultcode);
		model.setErrorMsg(errorMsg);
		model.setData(data);
		return model;
	}
	
	@Override
	public Object queryDemo(String number) {
		// TODO Auto-generated method stub
		return JSONObject.fromObject("{"+
  "total:4,"+
  "data:[{"+
    "business:'服务台',"+
    "waitname:'接口请求：请分配某系统10G存储空间（李四，2015-10-10）',"+
    "action:'[事件指派][知识库查询][直接处理]'"+
  "},{"+
   "business:'事件管理',"+
    "waitname:'新指派事件：某系统服务需要重启（运维问题；紧急程度：高；报告人：张三）',"+
    "action:'[事件处理][知识库查询]'"+
  "},{"+
    "business:'问题管理',"+
    "waitname:'未接受问题：某服务系统需要重启',"+
    "action:'[问题接手][拒绝接手]'"+
  "},{"+
    "business:'问题管理',"+
    "waitname:'审核完成待实施问题：某系统服务需要重启33',"+
    "action:'[编辑实施信息]'"+
  "}]"+
"}");
	}

}
