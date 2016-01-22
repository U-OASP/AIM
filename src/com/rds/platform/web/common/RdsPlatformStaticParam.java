package com.rds.platform.web.common;

/**
 * 平台初始化实体类
 * @author dell
 *
 */
public class RdsPlatformStaticParam {
	
	private String sid = null;

	private static class SingletonHelp {
		private static final RdsPlatformStaticParam INSTANCE = new RdsPlatformStaticParam();
	}

	private RdsPlatformStaticParam() {
	}

	public static final RdsPlatformStaticParam getInstance() {
		return SingletonHelp.INSTANCE;
	}
	
	public void setSid(String sid){
		this.sid = sid;
	}
	
	public String getSid(){
		return this.sid;
	}

}
