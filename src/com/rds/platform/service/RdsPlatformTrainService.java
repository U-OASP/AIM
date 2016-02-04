package com.rds.platform.service;

public interface RdsPlatformTrainService {
	
	public Object queryPlatformTrains(Object params);
	
	public Object queryPlatformTrainsPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);
	
	public Object insertTrainFile(Object params);
	
	public Object queryPlatformTrainFiles(Object params);

}
