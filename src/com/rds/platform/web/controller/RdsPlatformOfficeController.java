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
import com.rds.platform.model.RdsPlatformSeatModel;
import com.rds.platform.service.RdsPlatformOfficeService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/office")
public class RdsPlatformOfficeController {
	
	@Setter
	@Autowired
	private RdsPlatformOfficeService rdsPlatformOfficeService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformoffices")
	@ResponseBody
	public Object queryPlatformOffices(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOfficeService.queryPlatformOffices(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformseats")
	@ResponseBody
	public Object queryPlatformSeats(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOfficeService.queryPlatformSeats(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformofficesexists")
	@ResponseBody
	public Object queryPlatformOfficesExists(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOfficeService.queryPlatformOfficesExists(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformseatspage")
	@ResponseBody
	public Object queryPlatformOfficesPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOfficeService.queryPlatformSeatsPage(PageUtil.pageSet(params));
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformseatsstatuspage")
	@ResponseBody
	public Object queryPlatformSeatsStatusPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformOfficeService.queryPlatformSeatsStatusPage(PageUtil.pageSet(params));
		return result;
	}
	
	/**
	 * 初始化座位
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("init")
	@ResponseBody
	public Object update(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		return rdsPlatformOfficeService.updateInitSeat(params);
	}
	
	
	@RequestMapping("updateSeat")
	@ResponseBody
	public Object updateSeat(RdsPlatformSeatModel model){
		return rdsPlatformOfficeService.updateSeat(model);
	}
	
	@RequestMapping("insertSeat")
	@ResponseBody
	public Object insertSeat(RdsPlatformSeatModel model){
		return rdsPlatformOfficeService.insertSeat(model);
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		return rdsPlatformOfficeService.delete(ids);
	}
	
}
