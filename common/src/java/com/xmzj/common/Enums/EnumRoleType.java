package com.xmzj.common.Enums;

/**
 * 角色类型枚举变量
 * @author 
 *
 */
public enum EnumRoleType {

//    platform_admin(0,"平台管理员"),  
//    platform_user(1,"平台用户"),  
//    agency_user_first(2,"一级代理商"),
//    agency_user_second(3,"二级代理商"),  
//    operator_admin(4,"运营商管理员"), 
//    operator_user(5,"运营商用户"),
//    ; 
	platForm(0,"平台"),
	restaurant(1,"餐厅"),
	hub(2,"hub");
	
	
	private int value;
	private String desc;
	
	
	private EnumRoleType(int value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumRoleType setValue(int str) {
		for (EnumRoleType e:EnumRoleType.values()) {
			if(e.getValue() ==(str)){
				return e;
			}
		}
		return platForm;
	}
	
}
