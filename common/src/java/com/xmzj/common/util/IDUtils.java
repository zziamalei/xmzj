package com.xmzj.common.util;

import java.math.BigInteger;
import java.util.UUID;





public class IDUtils {
    
	
	public static String getPk(){
		
		return UUID.randomUUID().toString();
	}

	public static String getVirtualId(){
		return UUID.randomUUID().toString();
	}
	public static BigInteger  getShardingId(){
		return BigInteger.valueOf((long)(Math.random()*999999999)+1);
	}
	
	public static void main(String[] args) {
		System.out.println(IDUtils.getShardingId());
//		main(args);
	}
}
