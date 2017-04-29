package com.xmzj.common.Enums;

public enum EnumIsDefault {

	
	Isdefault(0,"默认"),	//
	NotDefault(1,"不默认");//
	
	private int value;
	private String desc;
	
	
	private EnumIsDefault(int value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumIsDefault setValue(int str) {
		for (EnumIsDefault e:EnumIsDefault.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return NotDefault;

	}
	
}
