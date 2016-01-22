package com.rds.platform.service;

public interface RdsPlatformGoOutService {
	
	public Object queryPlatformGoOuts(Object params);
	
	public Object queryPlatformGoOutsPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

	public Object updateApproval(Object params);

}
