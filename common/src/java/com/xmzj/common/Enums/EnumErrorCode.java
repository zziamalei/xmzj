package com.xmzj.common.Enums;

public enum EnumErrorCode {
//编码规则：后三位为某一模块的具体功能的错误码，从1~999；前几位为模块编号，从1开始
	
	//参数相关0
	PARAM_ERROR("-1001","参数错误"),	//
	SYSTEM_ERROR("-1002","系统错误"),	//
	//会员相关1
	PWD_ERROR("-2001","密码错误"),//
	LOGIN_TIME_OUT_ERROR("-2002","用户登录超时"),//
	LOGIN_OTHER_ERROR("-2003","用户在别处登录"),//
	MEMBER_FROZEN_ERROR("-2004","会员冻结"),
	MEMBER_NOT_ACTIVATE_ERROR("-2005","会员未激活"),
	MEMBER_NOT_EXITS("-2006","会员不存在"),
	MEMBER_EXITS("-2007","该会员账号已被注册"),
	MEMBER_OPENID_EXITS("-2008","该会员已绑定微信，不能重复绑定"),
	MEMBER_email_empty("-2009","未绑定或注册邮箱"),
	
	//支付相关3
	pay_type_not_exits("-3001","不存在的支付方式"),
	pay_payed("-3002","已支付"),
	pay_zero("-3003","支付金额为0"),
	wallet_not_exits("-3004","钱包不存在"),
	pay_not_exits("-3005","支付单不存在"),
	pay_info_fail("-3006","获取支付信息失败"),
	
	
	//邀请码相关4
	invite_code_not_exist("-4001","邀请码不存在"),
	
	//邀请码相关订单相关
	order_cart_param_err("-5001","购物车参数错误"),
	order_cart_dish_not_exist("-5002","商品不存在"),
	order_cart_address_null("-5003","收货地址为空"),
	order_cart_balance_low("-5004","余额不足"),
	order_cart_stock_low("-5005","库存不足"),
	order_not_exist("-5006","订单不存在"),
	order_pay_outtime("-5007","订单支付超时"),
	order_pay_yet("-5008","订单已支付"),
	
	//hub相关
	hub_rider_exist("-6001","骑手已绑定该hub"),
	hub_rider_wait_check("-6002","已提交审核，请等待"),
	hub_rider_order_over("-6003","订单已经被人抢了"),
	
	//礼品卡相关
	gift_card_not_exist("-7001","礼品卡不存在"),
	gift_card_used("-7002","已使用"),
	gift_card_same_person("-7003","不能赠送同一人"),
	
//	comp_not_exits("-799","不存在的公司"),
//	YKT_CONNECT_ERROR("-798","一卡通链接错误"),
//	YKT_DEAL_ERROR("-797","一卡通处理错误"),
	
	team_not_exist("-8001","团队不存在"),
	team_address_not_exist("-8002","团队地址不存在"),
	team_joined("-8003","已加入该团队"),
	
	OTHER_ERROR("-1","其他错误");//
	
	private String value;
	private String desc;
	
	
	private EnumErrorCode(String value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumErrorCode setValue(String str) {
		for (EnumErrorCode e:EnumErrorCode.values()) {
			if(e.getValue().equals(str)){
				return e;
			}
		}
		return PARAM_ERROR;

	}
	
}
