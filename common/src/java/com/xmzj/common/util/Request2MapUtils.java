package com.xmzj.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Request2MapUtils {
	/**
	
	 * @Title: getMapFromRequest
	
	 * @Description: 将request的各项参数放到map中，同事想request重新setAttribute以方便实现回显
	
	 * @param request
	 * @return
	
	 * @return: Map<String,Object>
	
	 */
	public static Map<String, Object> getMapFromRequest(HttpServletRequest request){
		//遍历request 返回包含request所有元素的map
		HashMap<String, Object> map = new HashMap<String, Object>();
		Enumeration paramNames = request.getParameterNames();  
	    while (paramNames.hasMoreElements()) {  
	      String paramName = (String) paramNames.nextElement();  
//	      map.put(paramName, request.getParameter(paramName));  
//	      request.setAttribute(paramName, request.getParameter(paramName));  
	      String[] paramValues = request.getParameterValues(paramName);  
	      if (paramValues.length == 1) {  
	        String paramValue = paramValues[0];  
	        if (paramValue.length() != 0) {
	        	if("null".equals(paramValue)){
	        		continue;
	        	}
	          map.put(paramName, paramValue);  
	          request.setAttribute(paramName, paramValue);  
	        }  
	      }  
	    }  
		return map;
	} 
}
