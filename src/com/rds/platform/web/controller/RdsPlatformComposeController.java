package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.model.RdsPlatformComposeModel;
import com.rds.platform.service.RdsPlatformComposeService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/compose")
public class RdsPlatformComposeController {
	
	@Setter
	@Autowired
	private RdsPlatformComposeService rdsPlatformComposeService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcomposes")
	@ResponseBody
	public Object queryPlatformComposes(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformComposeService.queryPlatformComposes(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcomposespage")
	@ResponseBody
	public Object queryPlatformComposesPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformComposeService.queryPlatformComposesPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformComposeModel compose){
		return rdsPlatformComposeService.update(compose);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformComposeService.delete(ids);
	}
	
	@RequestMapping("updateapproval")
	@ResponseBody
	public Object updateApproval(RdsPlatformComposeModel compose){
		return rdsPlatformComposeService.updateApproval(compose);
	}
	
	@RequestMapping("init")
	@ResponseBody
	public Object init(HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		return rdsPlatformComposeService.updaetInitCompose(params);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformcomposeholidays")
	@ResponseBody
	public Object queryPlatformComposeHolidays(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformComposeService.queryPlatformComposeHolidays(PageUtil.pageSet(params));
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("updatedownandup")
	@ResponseBody
	public Object updatePlatformComposeDownAndUp(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformComposeService.updatePlatformComposeDownAndUp(params);
		return result;
	}
	
}
