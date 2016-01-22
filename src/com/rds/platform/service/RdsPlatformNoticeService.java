package com.rds.platform.service;

public interface RdsPlatformNoticeService {
	
	public Object queryPlatformNotices(Object params);
	
	public Object queryPlatformNoticesPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

}
