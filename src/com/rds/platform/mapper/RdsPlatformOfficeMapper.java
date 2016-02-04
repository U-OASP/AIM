package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformOfficeMapper {
	
	public List<Object> queryPlatformOffices(Object params);
	
	/**
	 * 查找所有的座位
	 * 
	 * @param params
	 * @return
	 */
	public List<Object> queryPlatformSeats(Object params);
	
	public List<Object> queryPlatformOfficesExists(Object params);
	
	public List<Object> queryPlatformSeatsPage(Object params);
	
	public List<Object> queryPlatformSeatsPageTotal(Object params);
	
	public List<Object> queryPlatformSeatsStatusPage(Object params);
	
	public List<Object> queryPlatformSeatsStatusPageTotal(Object params);
	
	public int insertSeat(Object params);
	
	public int updateSeat(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateInitSeat(List<Object> seats);

}
