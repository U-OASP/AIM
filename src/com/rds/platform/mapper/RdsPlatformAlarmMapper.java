package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformAlarmMapper {
	
	
	public List<Object> queryPlatformAlarmsPage(Object params);
	
	public int queryPlatformAlarmsPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);

}
