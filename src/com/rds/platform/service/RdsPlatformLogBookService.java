package com.rds.platform.service;

public interface RdsPlatformLogBookService {
	
	public Object queryPlatformLogBooks(Object params);
	
	public Object queryPlatformLogBooksPage(Object params);
	
	public Object update(Object params);
	
	public Object delete(String params);

}
