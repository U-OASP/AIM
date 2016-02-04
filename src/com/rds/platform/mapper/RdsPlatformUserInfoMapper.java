package com.rds.platform.mapper;

import java.util.List;

import com.rds.platform.model.common.RdsPlatformTreeNodeModel;

public interface RdsPlatformUserInfoMapper {
	
	public List<RdsPlatformTreeNodeModel> queryPlatformUserInfos(Object params);
	
	public List<RdsPlatformTreeNodeModel> queryPlatformAllUserInfos(Object params);
	
	public List<RdsPlatformTreeNodeModel> queryPlatformAllDepartments(Object params);
	
	public List<RdsPlatformTreeNodeModel> queryPlatformUserInfosByDepartment(Object params);

}
