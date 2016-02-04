package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Setter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.service.RdsPlatformUserInfoService;
import com.rds.platform.web.common.TreeJson;

@Controller
@RequestMapping("platform/userinfos")
public class RdsPlatformUserInfoController {
	
	@Setter
	@Autowired
	private RdsPlatformUserInfoService rdsPlatformUserInfoService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformuserinfos")
	@ResponseBody
	public Object queryPlatformUserInfos(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformUserInfoService.queryPlatformUserInfos(param);
		
		return TreeJson.formatTree((List<TreeJson>)result);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformalluserinfos")
	@ResponseBody
	public Object queryPlatformAllUserInfos(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformUserInfoService.queryPlatformAllUserInfos(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformalldepartments")
	@ResponseBody
	public Object queryPlatformAllDepartments(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformUserInfoService.queryPlatformAllDepartments(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformuserinfosbydepartment")
	@ResponseBody
	public Object queryPlatformUserInfosByDepartment(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformUserInfoService.queryPlatformUserInfosByDepartment(param);
		return result;
	}
	
}
