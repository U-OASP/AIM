package com.rds.platform.service;

import net.sf.json.JSONArray;

public interface RdsPlatformCheckingService {
	
	public Object queryPlatformCheckings(Object params);
	
	public Object queryPlatformCheckingsPage(Object params);
	
	public Object updateCheckingIn(Object params);
	
	public Object updateCheckingOut(Object params);
	
	public Object queryPlatformCheckingTotal(Object params);
	
	public Object queryPlatformCheckingTotalDetails(Object params);
	
	public Object updatePlatformCheckingValues(JSONArray jsons);
	

}
