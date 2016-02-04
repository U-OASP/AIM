package com.rds.platform.model;

import lombok.Data;

@Data
public class RdsPlatformMenuModel {

	private String id;
	private String text;
	private String iconCls;
	private String url;
	private String parentid;
	private String type;
	private boolean leaf = true;
	private String sysname;

}
