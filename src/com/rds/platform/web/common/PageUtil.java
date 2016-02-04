package com.rds.platform.web.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 页码设置工具
 * @author ThinK 2015年4月16日
 */
public class PageUtil {
	public static Map<String, String> pageSet(Map<String, String> map)
			throws Exception {
		if (map == null) {
			throw new Exception("分页参数为空。");
		}
		Integer start = Integer.parseInt( map.get("start"));
		Integer limit = Integer.parseInt( map.get("limit"));
		Map<String, String> result = new HashMap<String, String>();
		result.put("start", start+"");
		result.put("end", (limit+start)+"");
		map.putAll(result);
		return map;
	}
}
