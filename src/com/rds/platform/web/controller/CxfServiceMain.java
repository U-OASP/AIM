package com.rds.platform.web.controller;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CxfServiceMain {
	
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
	    org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:9080/platform/ws/AlarmWsdlService?wsdl"); 
	            //sayHello 为接口中定义的方法名称   张三为传递的参数   返回一个Object数组 
	    Object[] objects=client.invoke("sendAlarms", "{page=1, status=2, userId=sw, operate=2, pageSize=25, beginTime=,  serviceType=1, endTime=}");    
	    //输出调用结果 
	    System.out.println(objects[0].toString()); 
}

}
