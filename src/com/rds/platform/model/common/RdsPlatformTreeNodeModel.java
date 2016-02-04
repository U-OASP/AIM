package com.rds.platform.model.common;

import java.util.List;

import lombok.Data;

@Data
public class RdsPlatformTreeNodeModel {
	private String id;  
    private String text;  
    private String parentid;  
    private List<RdsPlatformTreeNodeModel> children;

}
