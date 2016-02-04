package com.rds.platform.service;

public interface RdsPlatformEntranceService {
	
	public Object queryPlatformEntrances(Object params);
	
	public Object queryPlatformEntrancesPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);
	
	public Object updateOutEntrances(String params);
	
}
