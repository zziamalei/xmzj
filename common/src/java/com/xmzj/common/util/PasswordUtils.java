package com.xmzj.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


public class PasswordUtils {

	
	/**
	 * 数据库保存密码生成方法：
	 * 密码先md5并转为小写，再使用salt生成SimpleHash。
	 * @param password  明文密码md5并小写得到的字符串
	 * @param salt
	 * @return
	 */
	public static String generatePassword(String password,String salt)
	{
		//明文密码进行md5并转为小写
		password = EncryptUtils.md5(password);
		//使用salt生成密码
		String newPassword = new SimpleHash(EncryptUtils.getAlgorithmName(), password, ByteSource.Util.bytes(salt), EncryptUtils.getHashIterations())
				.toHex();
		return newPassword;
	}
	
	

	/**
	 * @param password 加盐前密码
	 * @param salt 盐
	 * @param md5cipherText 加盐后密码
	 * @return
	 */
	public static boolean checkMd5Password(String password, String salt, String md5cipherText) {
		// 组合username,两次迭代，对密码进行加密
		String password_cipherText =  generatePassword(password, salt);
		return md5cipherText.equals(password_cipherText);
	}

	public static void main(String[] args) {
		
		System.out.println(PasswordUtils.checkMd5Password("4", "9bd1c9d95c100718233c0e20b3a733b2","6aa2c17e360d582efd2483d3ae8fa38a" ));
	}
}
