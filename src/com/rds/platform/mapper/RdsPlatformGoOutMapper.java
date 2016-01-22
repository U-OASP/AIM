package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformGoOutMapper {
	
	public List<Object> queryPlatformGoOuts(Object params);
	
	public List<Object> queryPlatformGoOutsPage(Object params);
	
	public int queryPlatformGoOutsPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateApproval(Object params);

}
