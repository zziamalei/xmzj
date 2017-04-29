package com.xmzj.common.util;

import java.util.Date;

public class SerialNumberUtils {
	
	/**
	 * 生成流水号
	 * @return
	 */
	public synchronized static String createSerialNumber(){
		
		String n=DateTimeUtil.DateTimeToStringM(new Date());
		n=n.substring(2);
		n=CodeUtils.createDigitCode(2)+n+CodeUtils.createDigitCode(4);
		return n;
		
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			
			System.out.println(SerialNumberUtils.createSerialNumber());
		}
	}
}
