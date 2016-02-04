package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.model.RdsPlatformBusinessModel;
import com.rds.platform.service.RdsPlatformBusinessService;

@Controller
@RequestMapping("platform/business")
public class RdsPlatformBusinessController {
	
	@Setter
	@Autowired
	private RdsPlatformBusinessService rdsPlatformBusinessService;
	
	@RequestMapping("queryplatformbusiness")
	@ResponseBody
	public Object queryPlatformBusiness(Model model){
		Object result = rdsPlatformBusinessService.queryPlatformBusiness(null);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformbusinesspage")
	@ResponseBody
	public Object queryPlatformBusinessPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformBusinessService.queryPlatformBusinessPage(params);
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformBusinessModel business){
		return rdsPlatformBusinessService.update(business);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformBusinessService.delete(ids);
	}

}
