package com.xmzj.common.util;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 对象转Json
 * @author lei.ma 2016年5月31日 下午2:07:28
 *
 */
public class JsonUtils {
	private static Logger log = Logger.getLogger(JsonUtils.class);
	
	/**
	 * 返回json字符串
	 * @author lei.ma 2016年5月31日 下午2:15:59 
	 * @param obj
	 * @return
	 */
	public static String Obj2JsonString(Object obj){
		return JSONObject.toJSONString(obj);
	}
	
	/**
	 * 返回加密的json字符串
	 * @author lei.ma 2016年5月31日 下午2:17:45 
	 * @param obj
	 * @return
	 */
	public static String Obj2JsonEncryptString(Object obj){
		log.debug("加密前："+JSONObject.toJSONString(obj));
		return SecurityUtils.encrypt(JSONObject.toJSONString(obj));
	}
	/**
	 * 返回加密的字符串
	 * @author lei.ma 2016年5月31日 下午2:17:45 
	 * @param obj
	 * @return
	 */
	public static String EncryptString(String obj){
		log.debug("加密前："+obj);
		return SecurityUtils.encrypt(obj);
	}

	
	/**
	 * @author lei.ma 2016年5月31日 下午8:35:53 
	 * @param params 加密请求参数转换为jsonobject
	 * @return
	 */
	public static JSONObject decodeParams2Json(String params) throws Exception   {
		if(StringUtils.isEmpty(params)){
			return null;
		}
		JSONObject rb = null;
		try {
//			rb = JSONObject.parseObject(AES256Encryption.decrypt2String(ConstantKey.key, params));
			rb = JSONObject.parseObject(params);
			log.debug(JSONObject.toJSONString(rb));
		} catch (Exception e) {
			throw new Exception("请求参数转换为json时错误："+params);
		}
		return rb;
		
	}
	/**
	 * 
	 * @author lei.ma 2016年5月31日 下午8:36:22 
	 * @param 非加密请求参数转换为jsonobject
	 * @return
	 */
	public static JSONObject params2Json(String params){
		JSONObject rb=JSONObject.parseObject(params);
		return rb;
		
	}
	
	/**
	 * 将json字符串转为javaBean
	 * kewei.yu 2016年7月1日
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T>T JsonString2Bean(String jsonString,Class<T> clazz){
			return JSONObject.toJavaObject(JSONObject.parseObject(jsonString), clazz);
	}
}
