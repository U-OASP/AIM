package com.rds.platform.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Setter;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.service.RdsPlatformWaitService;

/**
 * 待办
 * 
 * @author dell
 *
 */
@Controller
@RequestMapping("platform/wait")
public class RdsPlatformWaitController {
	
	@Setter
	@Autowired
	private RdsPlatformWaitService rdsPlatformWaitService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformwaitworkflowpage")
	@ResponseBody
	public Object queryPlatformWaitWorkFlowPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
//		{limit=25, title=23, start=0, page=1, operate=2, _dc=1445356168352, end=25}
		//{limit=25, start=0, page=1, status=2, userId=sw, operate=2, beginTime=, _dc=1450275046791, serviceType=1, endTime=}
//		params = PageUtil.pageSet(params);
//		params.put("pageSize", params.get("limit"));
//		params.put("page", params.get("page"));
//		params.remove("limit");
//		params.remove("start");
//		params.remove("_dc");
//		params.remove("end");
		
		Map<String, Object> json = new LinkedHashMap<String, Object>();
		json.put("pageSize", "'"+params.get("limit")+"'");
		json.put("page", "'"+params.get("page")+"'");
		json.put("userId", params.get("userId"));
		json.put("title", params.get("title"));
		json.put("operate", params.get("operate"));
		json.put("beginTime", params.get("beginTime"));
		json.put("endTime", params.get("endTime"));
		json.put("status", params.get("status"));
		json.put("serviceType", params.get("serviceType"));
		
		
		
		JSONObject result = (JSONObject)rdsPlatformWaitService.queryPlatformWaitwWorkFlowPage(json);
		
//		JSONObject result = JSONObject.fromObject("{result:\"0000\",info:\"查询成功\",datas:{rows:[{processInstanceId:4151,submitter:\"张建\",categoryName:\"事件\",code:\"SJD2014110620412027\",priority:\"二级\",createTime:\"2014-11-06 20:41:20\",subject:\"2323\",states:\"处理中\",surplusTime:\"\"}],tmp_pgCount:{pagesize:20,currentpage:1,total:1,pages:1}}}");
		Map<String, Object> rs = new HashMap<String,Object>();
		rs.put("datas", result.getJSONObject("datas").get("rows"));
		rs.put("total", result.getJSONObject("datas").getJSONObject("tmp_pgCount").get("total"));
		return rs;
	}
	
}
