package com.xmzj.common;

public class ConstantValidation {
	public final static String  numberOnly="^[0-9]*$";//只能输入数字：
	//只能输入n位的数字：
	public final static String  numberTotal="^\\d{20}$";//
	//只能输入至少n位的数字：
	public final static String  numberMin="^\\d{5,}$";//
	//只能输入m~n位的数字：。
	public final static String  numberLimit="^\\d{2,10}$";//
	//只能输入零和非零开头的数字：
	public final static String  numberNoZeroStart="^(0|[1-9][0-9]*)$";//
	//只能输入有两位小数的正实数：
	public final static String  number2Real="^[0-9]+(.[0-9]{2})?$";//
	//只能输入有1~3位小数的正实数：
	public final static String  numberThreeReal="^[0-9]+(.[0-9]{1,3})?$";//
	//只能输入非零的正整数：
	public final static String  numberReal="^\\+?[1-9][0-9]*$";//
	//只能输入非零的负整数：
	public final static String  numberPrepReal="^\\-[1-9]0-9*$";//
	//只能输入长度为3的字符：
	public final static String  threeChar="^.{3}$";//
	//只能输入由26个英文字母组成的字符串：
	public final static String  letterOnly="^[A-Za-z]+$";//
	//只能输入由26个大写英文字母组成的字符串：
	public final static String  letterUp="^[A-Z]+$";//
	//只能输入由26个小写英文字母组成的字符串：
	public final static String  letterDown="^[a-z]+$";//
	//只能输入由数字和26个英文字母组成的字符串：
	public final static String  letterAndDigit="^[A-Za-z0-9]+$";//
	//只能输入由数字、26个英文字母或者下划线组成的字符串：
	public final static String  letter_Digit="^\\w+$";//
	//验证用户密码：
	public final static String  passowrd="^[a-z0-9_-]{6,18}$";//正确格式为：小写字母、下划线和数字，长度在6~18之间。
	//验证是否含有^%&',;=?$\"等字符：
	public final static String  illegalChar="[^%&',;=?$\\x22]+";//
	//只能输入汉字：
	public final static String  chineseOnly="^[\u4e00-\u9fa5]{0,}$";//
	//验证Email地址：
	public final static String  email="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";//
	//验证InternetURL：
	public final static String  url="^http://%28[/\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";//
	//验证电话号码：
	public final static String  phone="^(\\(\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$";//正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。
	//验证身份证号（15位或18位数字）：
	public final static String  cardId="^\\d{15}|\\d{18}$";//
	public final static String  memer_name="^[a-zA-Z0-9_-\u4e00-\u9fa5\u2E80-\u9FFF]{1,20}$";//
	
	/**
	 * 只能输入1到5的某一个数字
	 */
	public final static String starValid="^[1-5]{1}$";
	public final static String noSpecialChar="[^~&',;=?$\\x22]+";
	
	
}
