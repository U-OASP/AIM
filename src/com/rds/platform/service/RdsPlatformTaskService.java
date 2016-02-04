package com.rds.platform.service;

public interface RdsPlatformTaskService {
	
	public Object queryPlatformSubTasks(Object params);
	
	public Object queryPlatformSubTasksByUser(Object params);
	
	public Object queryPlatformMainTasksPage(Object params);
	
	public Object updateMainTask(Object params);
	
	public Object deleteMainTask(String params);

	public Object updateMainTaskApproval(Object params);
	
	public Object updateSubTask(Object params);
	
	public Object updateSubsComplete(String params, String userid);
	
	public Object updateTaskFeedBack(Object params);
	
	public Object queryPlatformTaskFeedBack(Object params);
	
	public Object updateSure(String params);
	
}
