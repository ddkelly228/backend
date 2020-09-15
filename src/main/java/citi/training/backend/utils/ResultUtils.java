package citi.training.backend.utils;

import citi.training.backend.model.Result;
//import com.alibaba.fastjson.JSONObject;

public class ResultUtils {
/***
 * 返回的结果集中处理
 */
	
	public static Result success(Object data) {
		Result result = new Result();
//		result.put("status", 200);
//		result.put("msg", "success");
//		result.put("data", data);
		return result;
	}
	
	public static Result success() {
		Result result = new Result();
//		JSONObject result = new JSONObject();
//		result.put("status", 200);
//		result.put("msg", "success");
		return result;
	}
	
	public static Result error(String msg) {
		Result result = new Result();
//		JSONObject result = new JSONObject();
//		result.put("status", 500);
//		result.put("msg", msg);
		return result;
	}
}
