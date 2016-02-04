package com.rds.platform.service;

public interface RdsPlatformOverTimeService {
	
	public Object queryPlatformOverTimes(Object params);
	
	public Object queryPlatformOverTimesPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

	public Object updateApproval(Object params);
	
	public Object updateSure(Object params);
	
	public Object updateEndTime(Object params);
	
}
