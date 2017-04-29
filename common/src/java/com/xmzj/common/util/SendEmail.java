package com.xmzj.common.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件工具类
 * 
 * @author hao.wang 2016年6月16日 下午3:55:05
 * 
 */
public class SendEmail {

	

	public static void sendHtmlMail(String emailTitle, String emailContent,
			String email,final String emailAccount,final String emailPassword,String smtpHost) throws AddressException, MessagingException {
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", smtpHost);
		prop.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailAccount,
						emailPassword);
			}
		};

		Session session = Session.getDefaultInstance(prop, auth);

		session.setDebug(true);

		MimeMessage msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(emailAccount));
		msg.addRecipients(RecipientType.TO, email);
		msg.setSubject(emailTitle);
		msg.setContent(emailContent, "text/html;charset=utf-8");
		Transport.send(msg);
	}
	
	public static void main(String[] args) {
		try {
			SendEmail.sendHtmlMail("test", "123", "821718601@qq.com", "feedback@nomnomnom.cn", "NomNom2017", "smtp.nomnomnom.cn");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
