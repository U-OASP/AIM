package com.rds.platform.mapper;

import java.util.List;

/**
 * 首页右上方提示列表
 * 
 * @author dell
 *
 */
public interface RdsPlatformPromptMapper {
	
	public List<Object> queryPlatformPromptIOISPage(Object params);
	
	public List<Object> queryPlatformPromptIOISPageCount(Object params);

}
