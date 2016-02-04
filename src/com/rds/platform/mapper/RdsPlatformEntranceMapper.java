package com.rds.platform.mapper;

/**
 * 除入场
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformEntranceMapper {
	
	public List<Object> queryPlatformEntrances(Object params);
	
	public List<Object> queryPlatformEntrancesPage(Object params);
	
	public List<Object> queryPlatformEntrancesPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateOutEntrances(@Param(value="params") String params);
	
}
