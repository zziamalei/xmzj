package com.xmzj.common.util;

import org.apache.commons.lang3.StringUtils;

public class PhoneUtils {

	public static String hidePhone(String phone){
		if(StringUtils.isEmpty(phone)){
			return "";
		}
		if(phone.length()>4){
			return phone.substring(0,3)+"****"+phone.substring(phone.length()-4, phone.length());
		}else{
			return phone;
		}
	}
}
