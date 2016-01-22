package com.rds.platform.service;

public interface RdsPlatformVacationService {
	
	public Object queryPlatformVacations(Object params);
	
	public Object queryPlatformVacationsPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

	public Object updateApproval(Object params);

}
