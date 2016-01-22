package com.rds.platform.service;

/**
 * 入驻 service
 * 
 * @author dell
 *
 */
public interface RdsPlatformSettledService {
	
	public Object queryPlatformSettleds(Object params);
	
	public Object queryPlatformSettledsPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);
	
	public Object updateApproval(Object params);

}
