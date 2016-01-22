package com.rds.platform.web.ws;

import java.util.List;

public class WsTest {
	
	public static void main(String[] args) {
		ArrayOfString as = new ArrayOfString();
		List<String> ps = as.getString();
		ps.add("UM_ID");
		ps.add("UM_user_role");
		System.out.println(ps);
	}

}
