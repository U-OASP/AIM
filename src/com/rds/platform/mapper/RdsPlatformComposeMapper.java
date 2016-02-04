package com.rds.platform.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rds.platform.model.RdsPlatformComposeModel;
import com.rds.platform.model.RdsPlatformComposeUsersModel;

public interface RdsPlatformComposeMapper {
	
	public List<Object> queryPlatformComposes(Object params);
	
	public List<Object> queryPlatformComposesPage(Object params);
	
	public int queryPlatformComposesPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateApproval(Object params);
	
	public Map<String, String> queryComposeInit();
	
	public List<RdsPlatformComposeUsersModel> queryComposeUsers();
	
	public List<RdsPlatformComposeModel> queryComposes(Object params);
	
	public int insertComposeResult(Object params);
	
	public int updateComposeInit(Object params);
	
	public List<Object> queryPlatformComposeHolidays(Object params);
	
	public int queryPlatformComposeHolidaysTotal(Object params);
	
	public int updatePlatformComposeDownAndUp(Object params);

}
