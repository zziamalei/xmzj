package com.xmzj.common.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.xmzj.common.ReturnBean;

public class ReturnBeanUtils {

	/**
	 * 判断返回是否成功
	 * 
	 * @author lei.ma 2016年6月29日 下午1:34:52
	 * @param str
	 * @return
	 */
	public static boolean result(String str) {
		JSONObject jb = JSONObject.parseObject(str);

		if (null == jb) {
			return false;
		}

		if (jb.containsKey("resultCode") && jb.getString("resultCode").trim().equals("SUCCESS")) {

			return true;
		}

		return false;

	}
	public static boolean issuccess(ReturnBean rb) {
		
		if (null == rb) {
			return false;
		}
		
		if (rb.getResultCode().equals("SUCCESS")) {
			
			return true;
		}
		
		return false;
		
	}

	public static JSONObject getResultData(String str) {
		JSONObject jb = JSONObject.parseObject(str);
        return jb.containsKey("resultData")?jb.getJSONObject("resultData"):null;

	}
	public static String getResultDataString(String str) {
		JSONObject jb = JSONObject.parseObject(str);
		return jb.containsKey("resultData")?jb.getString("resultData"):null;
		
	}
	public static <T> List<T> getResultDataList(String str,Class<T> clazz) {
		JSONObject jb=	ReturnBeanUtils.getResultData(str);
		if(jb.containsKey("list")){
			return JSONObject.parseArray(jb.getString("list"), clazz);
		}
		
		return null;
		
	}
	public static <T> List<T> getResultDataList2(String str,Class<T> clazz) {
		JSONObject jb = JSONObject.parseObject(str);
		if(jb.containsKey("resultData")&&StringUtils.isNotEmpty(jb.getString("resultData"))){
			return JSONObject.parseArray(jb.getString("resultData"), clazz);
		}
		
		return null;
		
	}
	public static <T> T getResultDataObject(String str,Class<T> clazz) {
		JSONObject jb=	ReturnBeanUtils.getResultData(str);
		return JSONObject.parseObject(jb.toJSONString(), clazz);
		
	}

}
