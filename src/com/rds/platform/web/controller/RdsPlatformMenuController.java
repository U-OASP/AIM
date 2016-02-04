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
import com.rds.platform.service.RdsPlatformMenuService;
import com.rds.platform.web.common.PageUtil;

/**
 * 待办
 * 
 * @author dell
 *
 */
@Controller
@RequestMapping("platform/menu")
public class RdsPlatformMenuController {
	
	@Setter
	@Autowired
	private RdsPlatformMenuService rdsPlatformMenuService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformmenubyparentid")
	@ResponseBody
	public Object queryPlatformMenuByParentid(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		params = PageUtil.pageSet(params);
		Object result = rdsPlatformMenuService.queryPlatformMenuByParentid(params);
		return result;
	}
	
}
