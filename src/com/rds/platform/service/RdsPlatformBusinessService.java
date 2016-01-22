package com.rds.platform.service;

/**
 * 业务公开
 * 
 * @author dell
 *
 */
public interface RdsPlatformBusinessService {
	
	public Object queryPlatformBusiness(Object params);
	
	public Object queryPlatformBusinessPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

}
