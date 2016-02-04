package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.service.RdsPlatformAlarmService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/alarm")
public class RdsPlatformAlarmController {
	
	@Setter
	@Autowired
	private RdsPlatformAlarmService rdsPlatformAlarmService;
	

	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformalarmpage")
	@ResponseBody
	public Object queryPlatformNoticesPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformAlarmService.queryPlatformAlarmsPage(PageUtil.pageSet(params));
		return result;
	}
	
}
