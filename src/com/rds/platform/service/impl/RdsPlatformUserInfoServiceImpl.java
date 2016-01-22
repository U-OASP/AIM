package com.rds.platform.service.impl;

import java.util.List;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.platform.mapper.RdsPlatformUserInfoMapper;
import com.rds.platform.model.common.RdsPlatformTreeNodeModel;
import com.rds.platform.service.RdsPlatformUserInfoService;

//import common.Logger;

@Service("rdsPlatformUserInfoService")
public class RdsPlatformUserInfoServiceImpl implements RdsPlatformUserInfoService {
	
//	private static Logger logger = Logger.getLogger(RdsPlatformUserInfoServiceImpl.class);
	
	@Setter
	@Autowired
	private RdsPlatformUserInfoMapper rdsPlatformUserInfoMapper;
	
	public Object queryPlatformUserInfos(Object params){
//		List<RdsPlatformTreeNodeModel> treeNodeModels =  rdsPlatformUserInfoMapper.queryPlatformUserInfos(params);
//		return TreeNodeUtils.getTreeNodes(treeNodeModels);
		
		return rdsPlatformUserInfoMapper.queryPlatformUserInfos(params);
	}

	@Override
	public Object queryPlatformAllUserInfos(Object params) {
		return rdsPlatformUserInfoMapper.queryPlatformAllUserInfos(params);
	}

	@Override
	public List<RdsPlatformTreeNodeModel> queryPlatformAllDepartments(
			Object params) {
		return rdsPlatformUserInfoMapper.queryPlatformAllDepartments(params);
	}

	@Override
	public Object queryPlatformUserInfosByDepartment(Object params) {
		return rdsPlatformUserInfoMapper.queryPlatformUserInfosByDepartment(params);
	}

}
