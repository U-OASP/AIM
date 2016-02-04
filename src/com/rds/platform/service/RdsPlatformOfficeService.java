package com.rds.platform.service;

public interface RdsPlatformOfficeService {
	
	public Object queryPlatformOffices(Object params);
	
	public Object queryPlatformOfficesExists(Object params);
	
	public Object queryPlatformSeats(Object params);
	
	public Object queryPlatformSeatsStatusPage(Object params);
	
	public Object queryPlatformSeatsPage(Object params);
	
	/**
	 * 初始化座位
	 * 
	 * @param params
	 * @return
	 */
	public Object updateInitSeat(Object params);
	
	public Object insertSeat(Object params);
	
	public Object updateSeat(Object params);
		
	public Object delete(String params);

}
