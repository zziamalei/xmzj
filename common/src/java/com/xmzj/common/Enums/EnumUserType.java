package com.xmzj.common.Enums;

/**
 * 用户类型枚举变量
 * @author 
 *
 */
public enum EnumUserType {

    platform_user(0,"平台用户类型"),  
    agency_user(1,"代理商用户类型"),  
    operator_user(2,"运营商用户类型"),  
	member_user(3,"普通会员用户类型");	//
	
	
	private int value;
	private String desc;
	
	
	private EnumUserType(int value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumUserType setValue(int str) {
		for (EnumUserType e:EnumUserType.values()) {
			if(e.getValue() ==(str)){
				return e;
			}
		}
		return null;
	}
	
}
