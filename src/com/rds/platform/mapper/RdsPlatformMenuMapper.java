package com.rds.platform.mapper;

import java.util.List;

/**
 * 首页右上方提示列表
 * 
 * @author dell
 *
 */
public interface RdsPlatformMenuMapper {
	
	public List<Object> queryPlatformMenuByParentid(Object params);

}
