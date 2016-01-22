package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformNoticeMapper {
	
	public List<Object> queryPlatformNotices(Object params);
	
	public List<Object> queryPlatformNoticesPage(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
}
