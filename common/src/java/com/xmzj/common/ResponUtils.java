package com.xmzj.common;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class ResponUtils {
	
	public static void responseString(HttpServletResponse response,Object object){
		
		
		OutputStream os=null;
		try {
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires", 0);
			response.setHeader("Content-type", "text/html;charset=UTF-8");  
			os=response.getOutputStream();
			os.write(JSONObject.toJSONString(object).getBytes("utf-8"));
			response.flushBuffer();
		} catch (Exception e) {
		} finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
	public static void responseJSONString(HttpServletResponse response,Object object){
		
		
		OutputStream os=null;
		try {
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires", 0);
			response.setHeader("Content-type", "application/json;charset=UTF-8");  
			os=response.getOutputStream();
			os.write(JSONObject.toJSONString(object).getBytes("utf-8"));
			response.flushBuffer();
		} catch (Exception e) {
		} finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
		
	}

}
