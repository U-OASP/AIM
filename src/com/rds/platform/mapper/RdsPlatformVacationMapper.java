package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformVacationMapper {
	
	public List<Object> queryPlatformVacations(Object params);
	
	public List<Object> queryPlatformVacationsPage(Object params);
	
	public int queryPlatformVacationsPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateApproval(Object params);

}
