package com.rds.platform.service;

import java.util.Map;

public interface RdsPlatformComposeService {
	
	public Object queryPlatformComposes(Object params);
	
	public Object queryPlatformComposesPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

	public Object updateApproval(Object params);
	
	public Object updaetInitCompose(Map<String, String> params);
	
	public Object queryPlatformComposeHolidays(Object params);
	
	public Object updatePlatformComposeDownAndUp(Object params);

}
