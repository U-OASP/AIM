package com.rds.platform.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

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
public interface RdsPlatformAlarmWsdlService {
	
	@WebMethod
	public RdsPlatformWsResultModel sendAlarms(String alarms);
	
	@WebMethod
	public RdsPlatformWsResultModel updateAlarms(String alarm);

}
