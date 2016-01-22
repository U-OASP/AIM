package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * 加班
 * 
 * @author dell
 *
 */
public interface RdsPlatformOverTimeMapper {
	
	public List<Object> queryPlatformOverTimes(Object params);
	
	public List<Object> queryPlatformOverTimesPage(Object params);
	
	public int queryPlatformOverTimesPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateApproval(Object params);
	
	public int updateEndTime(Object params);
	
	public int updateSure(Object params);
	
	

}
