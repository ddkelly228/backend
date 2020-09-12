package citi.training.backend.utils;

import com.alibaba.fastjson.JSONObject;

public class ResultUtils {
/***
 * 返回的结果集中处理
 */
	
	public static JSONObject success(Object data) {
		JSONObject result = new JSONObject();
		result.put("status", 200);
		result.put("msg", "success");
		result.put("data", data);
		return result;
	}
	
	public static JSONObject success() {
		JSONObject result = new JSONObject();
		result.put("status", 200);
		result.put("msg", "success");
		return result;
	}
	
	public static JSONObject error(String msg) {
		JSONObject result = new JSONObject();
		result.put("status", 500);
		result.put("msg", msg);
		return result;
	}
}
