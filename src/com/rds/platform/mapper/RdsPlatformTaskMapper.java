package com.rds.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RdsPlatformTaskMapper {
	
	public List<Object> queryPlatformSubTasks(Object params);
	
	public List<Object> queryPlatformSubTasksByUser(Object params);
	
	/**
	 * 主任务
	 * 
	 * @param params
	 * @return
	 */
	public List<Object> queryPlatformMainTasksPage(Object params);
	
	public int queryPlatformMainTasksPageTotal(Object params);
	
	public int insertMainTask(Object params);
	
	public int updateMainTask(Object params);
	
	public int deleteMainTask(@Param(value="params") String params);
	
	public int updateMainTaskApproval(Object params);
	
	public int insertSubTask(Object params);
	
	public int updateSubTask(Object params);
	
	public int updateSubUsers(Object params);
	
	public int deleteSubUsers(Object params);
	
	/**
	 * 确认完成
	 * 
	 * */
	public int updateSubsComplete(Object params);
	
	public int updateTaskFeedBack(Object params);
	
	public List<Object> queryPlatformTaskFeedBack(Object params);
	
	public int updateSure(@Param(value="params") String params);
	

}
