package com.rds.platform.web.common;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.rds.code.utils.PropertiesUtils;
import com.rds.code.utils.syspath.ConfigPath;
import com.rds.platform.web.itsmws.OrdersServices;
import com.rds.platform.web.ws.ArrayOfString;
import com.rds.platform.web.ws.UserCtrlServiceSoap;

public class RdsPlatformAPI {
	
	private static Logger logger = Logger.getLogger(RdsPlatformAPI.class);

	/**
	 * 单点登录 restful
	 * 
	 * @return
	 */
	public static Object ssoRestful(String loginName, String nameCode) {
		String init_path = ConfigPath.getWebInfPath() + "spring"
				+ File.separator + "properties" + File.separator
				+ "init.properties";
		String ws_sso_url = PropertiesUtils.readValue(init_path, "ws_sso_url");
		String s_result = HttpClientUtils.doGet(ws_sso_url);
		JSONObject result = JSONObject.fromObject(s_result);
		return result;
	}

	/**
	 * 单点登录
	 * 
	 * @param params
	 * @return
	 */
	public static int ssoWsdl(@SuppressWarnings("rawtypes") Map params) {

		String init_path = ConfigPath.getWebInfPath() + "spring"
				+ File.separator + "properties" + File.separator
				+ "init.properties";
		String ws_sso_url = PropertiesUtils.readValue(init_path, "ws_sso_url");

		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(ws_sso_url);
		bean.setServiceClass(UserCtrlServiceSoap.class);
		UserCtrlServiceSoap ws = (UserCtrlServiceSoap) bean.create();
		int result = ws.authUserByLoginNameV2(
				params.get("username").toString(), params.get("userid")
						.toString(), params.get("ip").toString());
		logger.info("ssoWsdl--->"+result);
		return result;
	}

	/**
	 * 用户信息wsdl
	 * 
	 * @param params
	 * @return
	 */
	public static String userInfoWsdl(@SuppressWarnings("rawtypes") Map params) {

		String init_path = ConfigPath.getWebInfPath() + "spring"
				+ File.separator + "properties" + File.separator
				+ "init.properties";
		String ws_sso_url = PropertiesUtils.readValue(init_path,
				"ws_user_info_url");

		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(ws_sso_url);
		bean.setServiceClass(UserCtrlServiceSoap.class);
		UserCtrlServiceSoap ws = (UserCtrlServiceSoap) bean.create();
		ArrayOfString as = new ArrayOfString();
		List<String> ps = as.getString();
		ps.add("UM_ID");
		ps.add("UM_user_role");
		ps.add("UM_ROLE_RANK");
		String result = ws.umGetUserInfoJson(params.get("userid").toString(),
				as);
		logger.info("userInfoWsdl--->"+result);
		return result;
	}

	/**
	 * 获取用户基本信息
	 * 
	 * @return
	 */
	public static Object userInfo(String loginName, String nameCode) {
		String init_path = ConfigPath.getWebInfPath() + "spring"
				+ File.separator + "properties" + File.separator
				+ "init.properties";
		String ws_sso_url = PropertiesUtils.readValue(init_path, "ws_sso_url");
		String s_result = HttpClientUtils.doGet(ws_sso_url);
		JSONObject result = JSONObject.fromObject(s_result);
		logger.info("userInfo--->"+result);
		return result;
	}

	/**
	 * 待办事项
	 * 
	 * @param params
	 *            {\
	 *            "pageSize\":20,\"page\":1,\"userId\":\"zhangsan\",\"title\":\"\",\"operate\":\"2\"
	 *            }
	 * @return
	 * @throws Exception 
	 */
	public static Object orderServicesWsdl(String params) throws Exception {
		String init_path = ConfigPath.getWebInfPath() + "spring"
				+ File.separator + "properties" + File.separator
				+ "init.properties";
		String ws_orderservice_url = PropertiesUtils.readValue(init_path,
				"ws_orderservice_url");
		logger.info("ws_orderservice_url:=========="+ws_orderservice_url);
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(ws_orderservice_url);
		bean.setServiceClass(OrdersServices.class);
		OrdersServices ws = (OrdersServices) bean.create();
		String result = ws.queryWorkOrder(params);
		logger.info("orderServicesWsdl--->"+result);
		return result;
//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
////	    org.apache.cxf.endpoint.Client client = dcf.createClient("http://86.12.79.2:9080/itsm/schemas/OrdersServices?wsdl"); 
//		org.apache.cxf.endpoint.Client client = dcf.createClient(ws_orderservice_url);
//	    logger.info("params:=========="+params);
//	    Object[] objects=client.invoke("queryWorkOrder", params);   
//	    logger.error("result:========="+objects);
//	    if(objects==null||objects.length==0){
//	    	return "[]";
//	    }else {
//	    	return objects[0].toString();
//		}
	}

	public static void main(String[] args) {
		System.out.println(RdsPlatformAPI.ssoRestful("sw",
				"TkcQu9WBUErxbKrQOE4ipQ"));
	}

}
