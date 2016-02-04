package com.rds.platform.service.impl;


import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.rds.platform.service.RdsPlatformWaitService;
import com.rds.platform.web.common.RdsPlatformAPI;

@Service("rdsPlatformWaitService")
public class RdsPlatformWaitServiceImpl implements RdsPlatformWaitService {

	@Override
	public Object queryPlatformWaitwWorkFlowPage(Object params) throws Exception {
		String json_params = params.toString();
		return JSONObject.fromObject(RdsPlatformAPI.orderServicesWsdl(json_params));
	}
}
