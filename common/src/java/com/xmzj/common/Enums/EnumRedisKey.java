package com.xmzj.common.Enums;
/**
 * redis缓存主键前缀配置
 * @author lei.ma 2016年6月8日 上午11:49:24
 *
 */
public enum EnumRedisKey {

	
	wechatpay("wechatpay","微信支付"),	//
	unionpay("unionpay","银联支付"),	//
	alipay("alipay","阿里支付"),	//
	ykt_url("ykt_url","一卡通地址"),	//
	ykt("ykt","一卡通"),	//
	op_b_pk("op_b_pk","删除"),	//
	op_b_sId("op_b_sId","删除"),	//
	setting("setting","用户设置"),	//
	visit_alarm("visit_alarm","访客提醒"),	//
	wallet_lack("wallet_lack","余额低提醒"),	//
	company_msg_conf("company_msg_conf","公司消息配置"),	//
	qrcode_path("qrcode_path","二维码地址"),	//
	normal("","正常"),
	
	pay_method("dpay","默认支付方式"),
	register_code("reg_code","注册验证码"),
	change_phone("ch_phone","更改手机号");
	
	
	private String value;
	private String desc;
	
	
	private EnumRedisKey(String value,String desc) {
		this.value = value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumRedisKey setValue(String str) {
		for (EnumRedisKey e:EnumRedisKey.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return normal;

	}
	
}
