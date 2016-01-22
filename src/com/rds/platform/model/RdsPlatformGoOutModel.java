package com.rds.platform.model;

import lombok.Data;

@Data
public class RdsPlatformGoOutModel {
	
	private String id;
	private String title;
	private String content;
	private String starttime;
	private String endtime;
	private String reguser;
	private String regtime;
	private String status;
	private String goouter;
	private String approval;
	private String approvaltime;
}
