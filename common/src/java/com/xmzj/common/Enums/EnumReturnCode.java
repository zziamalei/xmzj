package com.xmzj.common.Enums;

public enum EnumReturnCode {

	
	SUCCESS("SUCCESS","成功"),	//
	FAIL("FAIL","失败");//
	
	private String value;
	private String desc;
	
	
	private EnumReturnCode(String value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumReturnCode setValue(String str) {
		return valueOf(str);

	}
	
}
