package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rds.code.utils.web.RequestUtils;
import com.rds.code.web.servlet.RdsDispatchServlet;
import com.rds.platform.web.common.NetworkUtil;
import com.rds.platform.web.common.RdsPlatformAPI;
import com.rds.platform.web.common.RdsPlatformStaticParam;
import com.rds.platform.web.itsmws.OrdersServices;

@Controller
@RequestMapping("/")
public class RdsPlatformHomeController {

	/**
	 * 系统首页
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("home")
	public ModelAndView homeIndex(HttpServletRequest request) throws Exception {

		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		ModelAndView mv = RdsDispatchServlet.getModeAndView();
		params.put("ip", NetworkUtil.getIpAddress(request));
		// 验证登录
		int result = 302;//RdsPlatformAPI.ssoWsdl(params);
		if (result > 0) {
			RdsPlatformStaticParam.getInstance().setSid(params.get("userid"));
			mv.setViewName("home");
			mv.getModel().put("userid", params.get("userid"));
			mv.getModel().put("username", params.get("username"));
			mv.getModel().put("role", params.get("role"));
			// 获取基本信息
//			@SuppressWarnings("rawtypes")
//			Map u_params = new HashMap();
//			u_params.put("userid", result);
//			String userinfo = "";//RdsPlatformAPI.userInfoWsdl(u_params);
//			mv.getModel().put("userinfos", JSONArray.fromObject(userinfo));
			return mv;
		} else {
			mv.setViewName("error/500");
			return mv;
		}
	}

	/**
	 * 业务管理首页
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("index")
	public ModelAndView platformIndex(HttpServletRequest request)
			throws Exception {

		@SuppressWarnings("unchecked")
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		params.put("ip", NetworkUtil.getIpAddress(request));
		int result = 302;//RdsPlatformAPI.ssoWsdl(params);
		ModelAndView mv = RdsDispatchServlet.getModeAndView();
		if (result > 0) {
			//登录成功
			RdsPlatformStaticParam.getInstance().setSid(params.get("userid"));
			mv.setViewName("index");
			mv.getModel().put("userid", params.get("userid"));
			mv.getModel().put("username", params.get("username"));
			mv.getModel().put("menuid", params.get("menuid"));
			return mv;
		} else {
			//登录失败
			mv.setViewName("error/500");
			return mv;
		}
	}

	public static void main(String[] args) {
		String address = "http://192.8.124.183:9080/itsm/schemas/OrdersServices?wsdl"; // 此处最好用系统参数
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(address);
		bean.setServiceClass(OrdersServices.class);
		OrdersServices ws = (OrdersServices) bean.create();
		// int result =
		// ws.authUserByLoginName(params.get("username").toString(),
		// params.get("userid").toString());
		String result = ws
				.queryWorkOrder("{\"pageSize\":20,\"page\":1,\"userId\":\"zhangsan\",\"title\":\"\",\"operate\":\"2\"}");
		System.out.println(result);
	}

}
