package com.rds.platform.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
public class RdsPlatformTaskFeedBackModel {
	
	private String id;
	private String fbtime;
	private String fbmark;
	private String taskid;
	private String filepath;
	private String filename;
	private CommonsMultipartFile file;
}
