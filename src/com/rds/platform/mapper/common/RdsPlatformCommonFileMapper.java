package com.rds.platform.mapper.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformCommonFileMapper {
	
	public List<Object> queryPlatformCommonFiles(Object params);
	
	public List<Object> queryPlatformCommonFilesPage(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public void delete(@Param(value="params") String params);

}
