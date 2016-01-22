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
import com.rds.platform.model.RdsPlatformLogBookModel;
import com.rds.platform.service.RdsPlatformLogBookService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/logbook")
public class RdsPlatformLogBookController {
	
	@Setter
	@Autowired
	private RdsPlatformLogBookService rdsPlatformLogBookService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformlogbooks")
	@ResponseBody
	public Object queryPlatformLogBooks(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformLogBookService.queryPlatformLogBooks(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformlogbookspage")
	@ResponseBody
	public Object queryPlatformLogBooksPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformLogBookService.queryPlatformLogBooksPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformLogBookModel logbook){
		return rdsPlatformLogBookService.update(logbook);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformLogBookService.delete(ids);
	}
	
}
