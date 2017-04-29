package com.xmzj.common.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtil {
	
	
	public static   String basePath;
	public static   String masterSecret;
	


	public static String getBasePath() {
		return basePath;
	}

	@Value("${basePath}")
	public  void setKey(String basePath) {
		PropertyUtil.basePath = basePath;
	}
	
	
}
