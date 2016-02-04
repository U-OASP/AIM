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

@Controller
@RequestMapping("platform/permit")
public class RdsPlatformPermitController {
	
	@Setter
	@Autowired
	private RdsPlatformMenuService rdsPlatformMenuService;
	
	@RequestMapping("querypermits")
	@ResponseBody
	public Object queryPermits(HttpServletRequest request) throws Exception{
		
		@SuppressWarnings("unchecked")
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformMenuService.queryPlatformMenuByParentid(params);
		return result;
		
//		String result = "[{"+
//        "text:'公告管理',"+
//        "iconCls:'Comments',"+
//        "id:'notice',"+
//        "url:'Rds.panel.RdsPlatformNoticeGrid',"+
//        "leaf:true"+
//    "},{"+
//        "text:'业务公开管理',"+
//        "iconCls:'Applicationviewgallery',"+
//        "id:'business',"+
//        "url:'Rds.panel.RdsPlatformBusinessGrid',"+
//        "leaf:true"+
//    "}]";
//		return JSONArray.parse(result);
	}

}
