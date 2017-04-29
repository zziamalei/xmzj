package com.xmzj.common.Enums;

public enum EnumSpecialCharacterType {
	/**
	 * 特殊字符使用场景
	 */
	
	name(0,"用户名类"),	//
	password(1,"密码类"),
	netUrl(2,"链接类"),
	latLong(3,"坐标类"),
	email(4,"邮箱类");//
	
	private int value;
	private String desc;
	
	
	private EnumSpecialCharacterType(int value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumSpecialCharacterType setValue(int str) {
		for (EnumSpecialCharacterType e:EnumSpecialCharacterType.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return name;

	}
	
}
