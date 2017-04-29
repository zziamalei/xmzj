/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  [PeakeCloud] 
 * @Package:      [com.poobo.sms.EnumSmsType.java]  
 * @ClassName:    [EnumSmsType]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [lei.ma]   
 * @CreateDate:   [2016年6月3日 上午10:12:18]   
 * @UpdateUser:   [RayMa]   
 * @UpdateDate:   [2016年6月3日 上午10:12:18]   
 * @UpdateRemark: [说明本次修改内容]  
 * @Version:      [v1.0] 
 *    
 */
package com.xmzj.common.Enums;

/**
 * @author lei.ma 2016年6月3日 上午10:12:18
 *
 */
public enum EnumSmsType {
	not_exits(-1,"不存在的"),
	alert_login_pwd(0,"修改登录密码"),
	alert_auth(1,"认证信息修改"),
	alert_email(2,"修改邮箱"),
	set_operate_pwd(3,"设置操作密码"),
	register_code(4,"注册验证码"),
	change_phone(5,"更改手机号"),
	door_secret(6,"门禁短信"),
	door_secret_forget(7,"门禁密保重置"),
	order_id(8,"订单");
	
	private int value;
	private String desc;
	
	
	private EnumSmsType(int value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumSmsType setValue(int str) {
		
		EnumSmsType[] list=EnumSmsType.values();
		for(EnumSmsType enums:list){
			if(enums.getValue()==str){
				return enums;
			}
		}
		
		return not_exits;

	}
	

}