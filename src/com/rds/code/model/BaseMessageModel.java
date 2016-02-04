package com.rds.code.model;

import lombok.Data;

@Data
public class BaseMessageModel {
	
	private boolean success = true;
	private String message = "";
	private boolean result = false;
	private String code = "";

}
