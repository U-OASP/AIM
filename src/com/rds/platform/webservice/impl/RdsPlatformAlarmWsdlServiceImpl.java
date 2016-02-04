package com.rds.platform.webservice.impl;

import javax.jws.WebService;

import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.rds.platform.model.RdsPlatformAlarmModel;
import com.rds.platform.service.RdsPlatformAlarmService;
import com.rds.platform.webservice.RdsPlatformAlarmWsdlService;
import com.rds.platform.webservice.model.RdsPlatformWsResultModel;
/**
 * 告警ws处理接口
 * 
 * wsdl版
 * 
 * @author chenwei
 *
 */
@WebService(targetNamespace="ws")
public class RdsPlatformAlarmWsdlServiceImpl implements RdsPlatformAlarmWsdlService {
	
private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	
	@Setter
	@Autowired
	private RdsPlatformAlarmService rdsPlatformAlarmService;

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
					@SuppressWarnings("rawtypes")
					Class cl = RdsPlatformAlarmModel.class;
					rdsPlatformAlarmService.insert((RdsPlatformAlarmModel)JSONObject.toBean((JSONObject)object,cl));
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

	@Override
	public RdsPlatformWsResultModel updateAlarms(String alarm) {
		RdsPlatformWsResultModel model = new RdsPlatformWsResultModel();
		
		String resultcode = "0000"; 
		String errorMsg = null;
		Integer data = null;
		try {
			JSONObject object = JSONObject.fromObject(alarm);
			@SuppressWarnings("rawtypes")
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

}
