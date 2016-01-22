package com.rds.platform.service;

public interface RdsPlatformUserInfoService {
	
	public Object queryPlatformUserInfos(Object params);
	
	public Object queryPlatformAllUserInfos(Object params);
	
	public Object queryPlatformAllDepartments(Object params);
	
	public Object queryPlatformUserInfosByDepartment(Object params);
	
}
