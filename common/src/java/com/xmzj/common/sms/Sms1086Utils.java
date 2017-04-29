package com.xmzj.common.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Sms1086Utils {
	private static Logger log = Logger.getLogger(Sms1086Utils.class);
	private static final String sendUrl = "http://api.sms1086.com/api/Send.aspx";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入操作:S(发送短信),Q(查询余额),C(修改密码),X(退出).");
		System.out.print("提示:输入后按“回车键”响应事件.");
		String cmd = scanner.next();
		if (cmd.trim().toUpperCase().equals("S")) {
			SendSmsDemo();
		} else if (cmd.trim().toUpperCase().equals("Q")) {
			QueryDemo();
		} else if (cmd.trim().toUpperCase().equals("C")) {
			ChgPwdDemo();
		} else if (cmd.trim().toUpperCase().equals("X")) {
			System.exit(0);
		}
	}

	/**
	 * 发送邀请码
	 * 
	 * @author lei.ma 2016年9月8日 上午11:12:03
	 * @param phone
	 *            接收人手机号
	 * @param name
	 *            接收人名称
	 * @param qrurl
	 *            二维码访问地址
	 * @param username
	 *            短信账号
	 * @param pwd
	 *            短信密码
	 * @return
	 * @throws Exception
	 */
	public static boolean sendVistorQR(String phone, String name, String qrurl, String username, String pwd)
			throws Exception {

		String content = "【披克云】" + name + "您申请的访客预约通过，请点击二维码链接，通过扫码进入通道" + qrurl;
		return sendSms(phone, username, pwd, content);
	}

	/**
	 * 发送短信
	 * @author lei.ma 2016年9月8日 上午11:56:24 
	 * @param phone 手机号
	 * @param username 账户名
	 * @param pwd账户密码
	 * @param content 短信内容
	 * @return
	 */
	public static boolean sendSms(String phone, String username, String pwd, String content) {
		try {
			URL url = null;
			String strUrl = sendUrl + "?username=" + URLEncoder.encode(username, "GB2312") + "&password="
					+ java.net.URLEncoder.encode(pwd, "GB2312") + "&mobiles="
					+ java.net.URLEncoder.encode(phone, "GB2312") + "&content="
					+ java.net.URLEncoder.encode(content, "GB2312");
			url = new URL(strUrl);
			URLConnection UConn = url.openConnection();
			BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
			String str = breader.readLine();
			while (str != null) {
				str = URLDecoder.decode(str, "GB2312");
				String[] strs = str.split("&");
				if (strs[0].replace("result=", "").trim().equals("0")) {
					log.info("短信发送成功:"+phone+","+content);
					return true;
				} else {
					// str = "短信发送失败。失败原因："+strs[1].replace("description=","");
//					System.out.println("短信发送失败。失败原因：" + strs[1].replace("description=", ""));
					log.error("短信发送失败。失败原因：" + strs[1].replace("description=", ""));
					return false;
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		return true;
		return false;
	}

	/*
	 * 发送短信的演示代码
	 */
	static void SendSmsDemo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入您的用户名：");
		String UserName = scanner.next();
		System.out.print("请输入您的密码：");
		String Password = scanner.next();
		System.out.print("请输入接收短信的手机号码：");
		String Mobiles = scanner.next();
		System.out.print("请输入短信内容：");
		String Content = scanner.next();
		URL url = null;
		try {
			String strUrl = "http://api.sms1086.com/api/Send.aspx?username=" + URLEncoder.encode(UserName, "GB2312")
					+ "&password=" + java.net.URLEncoder.encode(Password, "GB2312") + "&mobiles="
					+ java.net.URLEncoder.encode(Mobiles, "GB2312") + "&content="
					+ java.net.URLEncoder.encode(Content, "GB2312");
			url = new URL(strUrl);
			URLConnection UConn = url.openConnection();
			BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
			String str = breader.readLine();
			while (str != null) {
				str = URLDecoder.decode(str, "GB2312");
				String[] strs = str.split("&");
				if (strs[0].replace("result=", "").trim().equals("0")) {
					str = "恭喜，短信发送成功。";
				} else {
					str = "短信发送失败。失败原因：" + strs[1].replace("description=", "");
				}
				System.out.print(str);
				str = breader.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 查询余额的演示代码
	 */
	static void QueryDemo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入您的用户名：");
		String UserName = scanner.next();
		System.out.print("请输入您的密码：");
		String Password = scanner.next();
		URL url = null;
		try {
			String strUrl = "http://api.sms1086.com/api/Query.aspx?username=" + URLEncoder.encode(UserName, "GB2312")
					+ "&password=" + java.net.URLEncoder.encode(Password, "GB2312");
			url = new URL(strUrl);
			URLConnection UConn = url.openConnection();
			BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
			String str = breader.readLine();
			while (str != null) {
				str = URLDecoder.decode(str, "GB2312");
				String[] strs = str.split("&");
				if (strs[0].replace("result=", "").trim().equals("0")) {
					str = "您的余额为：" + strs[1].replace("balance=", "") + "条。";
				} else {
					str = "查询失败。失败原因：" + strs[1].replace("description=", "");
				}
				System.out.print(str);
				str = breader.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 查询余额的演示代码
	 */
	static void ChgPwdDemo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入您的用户名：");
		String UserName = scanner.next();
		System.out.print("请输入您的原密码：");
		String OldPassword = scanner.next();
		System.out.print("请输入您的新密码：");
		String NewPassword = scanner.next();
		URL url = null;
		try {
			String strUrl = "http://api.sms1086.com/api/ChgPwd.aspx?username=" + URLEncoder.encode(UserName, "GB2312")
					+ "&password=" + java.net.URLEncoder.encode(OldPassword, "GB2312") + "&newpwd="
					+ java.net.URLEncoder.encode(NewPassword, "GB2312");
			url = new URL(strUrl);
			URLConnection UConn = url.openConnection();
			BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
			String str = breader.readLine();
			while (str != null) {
				str = URLDecoder.decode(str, "GB2312");
				String[] strs = str.split("&");
				if (strs[0].replace("result=", "").trim().equals("0")) {
					str = "恭喜，密码修改成功。";
				} else {
					str = "密码修改失败。失败原因：" + strs[1].replace("description=", "");
				}
				System.out.print(str);
				str = breader.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
