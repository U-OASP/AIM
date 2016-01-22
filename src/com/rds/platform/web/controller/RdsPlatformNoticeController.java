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
import com.rds.platform.model.RdsPlatformNoticeModel;
import com.rds.platform.service.RdsPlatformNoticeService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/notice")
public class RdsPlatformNoticeController {
	
	@Setter
	@Autowired
	private RdsPlatformNoticeService rdsPlatformNoticeService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformnotices")
	@ResponseBody
	public Object queryPlatformNotices(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformNoticeService.queryPlatformNotices(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformnoticespage")
	@ResponseBody
	public Object queryPlatformNoticesPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformNoticeService.queryPlatformNoticesPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformNoticeModel notice){
		return rdsPlatformNoticeService.update(notice);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformNoticeService.delete(ids);
	}
	
}
