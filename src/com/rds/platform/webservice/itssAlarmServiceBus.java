package com.rds.platform.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 告警ws处理接口
 * 
 * wsdl版
 * 
 * @author chenwei
 *
 */
@WebService(targetNamespace="http://www.chinawiserv.com/onecenter")
public interface itssAlarmServiceBus {
	
	@WebMethod
	public String sendAlarms(String alarms);
	
	@WebMethod
	public String updateAlarms(String alarm);

}
