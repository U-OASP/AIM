package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformBusinessMapper {
	
	public List<Object> queryPlatformBusiness(Object params);
	
	public List<Object> queryPlatformBusinessPage(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);

}
