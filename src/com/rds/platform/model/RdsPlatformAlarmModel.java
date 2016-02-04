package com.rds.platform.model;

import lombok.Data;

@Data
public class RdsPlatformAlarmModel {

	private String alarmId;
	private String alarmTrackId;
	private String occurTime;
	private String severity;
	private String message;
	private String source;
	private String alarmType;
	private String moId;
	private String additionalInfo;
	//private String mo;

}
