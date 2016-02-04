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
import com.rds.platform.model.RdsPlatformOverTimeModel;
import com.rds.platform.service.RdsPlatformOverTimeService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/overtime")
public class RdsPlatformOverTimeController {
	
	@Setter
	@Autowired
	private RdsPlatformOverTimeService rdsPlatformOverTimeService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformovertimes")
	@ResponseBody
	public Object queryPlatformOverTimes(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOverTimeService.queryPlatformOverTimes(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformovertimespage")
	@ResponseBody
	public Object queryPlatformOverTimesPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOverTimeService.queryPlatformOverTimesPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformOverTimeModel overtime){
		return rdsPlatformOverTimeService.update(overtime);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformOverTimeService.delete(ids);
	}
	
	@RequestMapping("updateapproval")
	@ResponseBody
	public Object updateApproval(RdsPlatformOverTimeModel overtime){
		return rdsPlatformOverTimeService.updateApproval(overtime);
	}
	
	@RequestMapping("updatesure")
	@ResponseBody
	public Object updateSure(RdsPlatformOverTimeModel overtime){
		return rdsPlatformOverTimeService.updateSure(overtime);
	}
	
	@RequestMapping("updateendtime")
	@ResponseBody
	public Object updateEndTime(RdsPlatformOverTimeModel overtime){
		return rdsPlatformOverTimeService.updateEndTime(overtime);
	}
	
}
