package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Setter;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.service.RdsPlatformCheckingService;

@Controller
@RequestMapping("platform/checking")
public class RdsPlatformCheckingController {
	
	@Setter
	@Autowired
	private RdsPlatformCheckingService rdsPlatformCheckingService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcheckings")
	@ResponseBody
	public Object queryPlatformCheckings(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformCheckingService.queryPlatformCheckings(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcheckingspage")
	@ResponseBody
	public Object queryPlatformCheckingsPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformCheckingService.queryPlatformCheckingsPage(params);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("checkingin")
	@ResponseBody
	public Object checkingIn(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformCheckingService.updateCheckingIn(params);
		return result; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("checkingout")
	@ResponseBody
	public Object checkingOut(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformCheckingService.updateCheckingOut(params);
		return result; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcheckingtotal")
	@ResponseBody
	public Object queryPlatformCheckingTotal(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformCheckingService.queryPlatformCheckingTotal(params);
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcheckingtotaldetial")
	@ResponseBody
	public Object queryPlatformCheckingTotalDetials(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformCheckingService.queryPlatformCheckingTotalDetails(params);
		return result;
	}
	
	@RequestMapping(value="updateplatformcheckingvalues")
	@ResponseBody
	public Object updatePlatformCheckingValues(HttpServletRequest request,String list) throws Exception{
		JSONArray jsons = JSONArray.fromObject(list);
		Object result = rdsPlatformCheckingService.updatePlatformCheckingValues(jsons);
		return result;
	}
	
}
