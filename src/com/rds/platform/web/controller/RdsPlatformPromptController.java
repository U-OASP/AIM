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
import com.rds.platform.service.RdsPlatformPromptService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/prompt")
public class RdsPlatformPromptController {
	
	@Setter
	@Autowired
	private RdsPlatformPromptService rdsPlatformPromptService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformpromptioispage")
	@ResponseBody
	public Object queryPlatformPromptIOISPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		params = PageUtil.pageSet(params);
		Object result = rdsPlatformPromptService.queryPlatformPromptIOISPage(params);
		return result;
	}
	
}
