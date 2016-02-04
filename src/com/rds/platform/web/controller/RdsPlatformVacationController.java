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
import com.rds.platform.model.RdsPlatformVacationModel;
import com.rds.platform.service.RdsPlatformVacationService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/vacation")
public class RdsPlatformVacationController {
	
	@Setter
	@Autowired
	private RdsPlatformVacationService rdsPlatformVacationService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformvacations")
	@ResponseBody
	public Object queryPlatformVacations(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformVacationService.queryPlatformVacations(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformvacationspage")
	@ResponseBody
	public Object queryPlatformVacationsPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformVacationService.queryPlatformVacationsPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformVacationModel vacation){
		return rdsPlatformVacationService.update(vacation);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformVacationService.delete(ids);
	}
	
	@RequestMapping("updateapproval")
	@ResponseBody
	public Object updateApproval(RdsPlatformVacationModel vacation){
		return rdsPlatformVacationService.updateApproval(vacation);
	}
	
}
