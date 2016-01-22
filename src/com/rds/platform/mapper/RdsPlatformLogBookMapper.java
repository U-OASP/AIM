package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformLogBookMapper {
	
	public List<Object> queryPlatformLogBooks(Object params);
	
	public List<Object> queryPlatformLogBooksPage(Object params);
	
	public int queryPlatformLogBooksPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);

}
