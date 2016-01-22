package com.rds.platform.mapper;
/**
 * 考勤
 */
import java.util.List;

public interface RdsPlatformCheckingMapper {
	
	public List<Object> queryPlatformCheckings(Object params);
	
	public List<Object> queryPlatformCheckingsPage(Object params);

	//	public int delete(@Param(value="params") String params);
	
	public int updateCheckingIn(Object params);
	
	public int updateCheckingOut(Object params);
	
	public List<Object> queryPlatformCheckingTotal(Object params);
	
	public List<Object> queryPlatformCheckingTotalDetials(Object params);
	
	public int updatePlatformCheckingValues(Object params);

}
