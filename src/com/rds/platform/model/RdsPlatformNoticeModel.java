package com.rds.platform.model;

import lombok.Data;

@Data
public class RdsPlatformNoticeModel {
	
	private String id;
	private String title;
	private String content;
	private String publishtime;
	private String starttime;
	private String endtime;
	private String publisher;
	private String permission;

}
