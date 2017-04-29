package com.xmzj.common.Enums;

public enum EnumResultCode {

	
	SUCCESS("SUCCESS","成功"),	//
	FAIL("FAIL","失败");//
	
	private String value;
	private String desc;
	
	
	private EnumResultCode(String value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumResultCode setValue(String str) {
		return valueOf(str);

	}
	
}
