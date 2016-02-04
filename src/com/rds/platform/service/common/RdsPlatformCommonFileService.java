package com.rds.platform.service.common;

public interface RdsPlatformCommonFileService {
	
	public Object queryPlatformCommonFiles(Object params);
	
	public Object queryPlatformCommonFilesPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

}
