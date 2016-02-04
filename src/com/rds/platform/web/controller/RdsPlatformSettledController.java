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
import com.rds.platform.model.RdsPlatformSettledModel;
import com.rds.platform.service.RdsPlatformSettledService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/settled")
public class RdsPlatformSettledController {
	
	@Setter
	@Autowired
	private RdsPlatformSettledService rdsPlatformSettledService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformsettleds")
	@ResponseBody
	public Object queryPlatformSettleds(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformSettledService.queryPlatformSettleds(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformsettledspage")
	@ResponseBody
	public Object queryPlatformSettledsPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformSettledService.queryPlatformSettledsPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformSettledModel settled){
		return rdsPlatformSettledService.update(settled);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformSettledService.delete(ids);
	}
	
	@RequestMapping("updateapproval")
	@ResponseBody
	public Object updateApproval(RdsPlatformSettledModel settled){
		return rdsPlatformSettledService.updateApproval(settled);
	}
	
}
