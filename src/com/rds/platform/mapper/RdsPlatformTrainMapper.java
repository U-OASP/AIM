package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformTrainMapper {
	
	public List<Object> queryPlatformTrains(Object params);
	
	public List<Object> queryPlatformTrainsPage(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public void delete(@Param(value="params") String params);
	
	public int insertTrainFile(Object params);
	
	public List<Object> queryPlatformTrainFiles(Object params);
	
	
}
