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
import com.rds.platform.model.RdsPlatformEntranceModel;
import com.rds.platform.service.RdsPlatformEntranceService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/entrance")
public class RdsPlatformEntranceController {
	
	@Setter
	@Autowired
	private RdsPlatformEntranceService rdsPlatformEntranceService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformentrances")
	@ResponseBody
	public Object queryPlatformEntrances(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformEntranceService.queryPlatformEntrances(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformentrancespage")
	@ResponseBody
	public Object queryPlatformEntrancesPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformEntranceService.queryPlatformEntrancesPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformEntranceModel entrance){
		return rdsPlatformEntranceService.update(entrance);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformEntranceService.delete(ids);
	}
	
	@RequestMapping("outentrance")
	@ResponseBody
	public Object updateOutEntrance(@RequestParam String ids){
		return rdsPlatformEntranceService.updateOutEntrances(ids);
	}
	
}
