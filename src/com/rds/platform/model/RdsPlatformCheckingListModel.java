package com.rds.platform.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RdsPlatformCheckingListModel {

	private List<RdsPlatformCheckingModel> checkings = new ArrayList<RdsPlatformCheckingModel>();
}
