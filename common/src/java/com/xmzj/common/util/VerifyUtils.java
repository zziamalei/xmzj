package com.xmzj.common.util;

import org.springframework.util.StringUtils;

public class VerifyUtils {
	
	public static boolean verifyAllParamsNotNull(Object...objects){
		for (Object object : objects) {
			if(StringUtils.isEmpty(object)){
				return false;
			}
		}
		
		return true;
	}
	public static boolean verifyAllParamsNull(Object...objects){
		for (Object object : objects) {
			if(!StringUtils.isEmpty(object)){
				return false;
			}
		}
		
		return true;
	}

}
