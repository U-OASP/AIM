package com.rds.platform.mapper;
/**
 * 入驻管理
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformSettledMapper {
	
	public List<Object> queryPlatformSettleds(Object params);
	
	public List<Object> queryPlatformSettledsPage(Object params);
	
	public int queryPlatformSettledsPageTotal(Object params);
	
	public int insert(Object params);
	
	public int update(Object params);
	
	public int delete(@Param(value="params") String params);
	
	public int updateApproval(Object params);

}
