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
import com.rds.platform.model.RdsPlatformGoOutModel;
import com.rds.platform.service.RdsPlatformGoOutService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/goout")
public class RdsPlatformGoOutController {
	
	@Setter
	@Autowired
	private RdsPlatformGoOutService rdsPlatformGoOutService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformgoouts")
	@ResponseBody
	public Object queryPlatformGoOuts(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformGoOutService.queryPlatformGoOuts(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformgooutspage")
	@ResponseBody
	public Object queryPlatformGoOutsPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformGoOutService.queryPlatformGoOutsPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformGoOutModel goout){
		return rdsPlatformGoOutService.update(goout);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformGoOutService.delete(ids);
	}
	
	@RequestMapping("updateapproval")
	@ResponseBody
	public Object updateApproval(RdsPlatformGoOutModel goout){
		return rdsPlatformGoOutService.updateApproval(goout);
	}
	
}
