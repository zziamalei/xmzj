package com.xmzj.common;

import com.xmzj.common.Enums.EnumRedisKey;
import com.xmzj.common.Enums.EnumSmsType;


/**
 * Redis  key生成工具类
 * @author lei.ma 2016年12月26日下午2:38:39
 *
 */
public class RedisKeyUtils {

	/**
	 * 注册验证码
	 * @author lei.ma 2016年12月26日下午2:45:22
	 * @param phone
	 * @return
	 */
	public static String registerKey(String phone) {
		return EnumRedisKey.register_code.getValue()+phone;
	}

	public static String resetPwdByPhoneKey(String phone) {
		return EnumSmsType.alert_login_pwd.getValue()+phone;
	}
	public static String changePhoneKey(String phone) {
		return EnumSmsType.change_phone.getValue()+phone;
	}

	public static String sendOrderKey(String orderId) {
		 return EnumSmsType.order_id.getValue()+orderId;
	}
	
	

}
