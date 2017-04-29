package com.xmzj.common.util;

import java.security.Key;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;


public class EncryptUtils {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static String algorithmName = "md5";
	private static int hashIterations = 2;

	public static String getAlgorithmName() {
		return algorithmName;
	}

	public static int getHashIterations() {
		return hashIterations;
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * encode
	 * 
	 * @param originString
	 * @return
	 */
	public static String md5(String originString) {
		if (originString != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes());
				String resultString = byteArrayToHexString(results);
				return resultString.toLowerCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * change the Byte[] to hex string
	 * 
	 * @param b
	 * @return
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * change a byte to hex string
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * base64进制加密
	 * 
	 * @param password
	 * @return
	 */
	public static String encrytBase64(String password) {
		byte[] bytes = password.getBytes();
		return Base64.encodeToString(bytes);
	}

	/**
	 * base64进制解密
	 * 
	 * @param cipherText
	 * @return
	 */
	public static String decryptBase64(String cipherText) {
		return Base64.decodeToString(cipherText);
	}

	/**
	 * 16进制加密
	 * 
	 * @param password
	 * @return
	 */
	public static String encrytHex(String password) {
		byte[] bytes = password.getBytes();
		return Hex.encodeToString(bytes);
	}

	/**
	 * 16进制解密
	 * 
	 * @param cipherText
	 * @return
	 */
	public static String decryptHex(String cipherText) {
		return new String(Hex.decode(cipherText));
	}

	public static String generateKey() {
		AesCipherService aesCipherService = new AesCipherService();
		Key key = aesCipherService.generateNewKey();
		return Base64.encodeToString(key.getEncoded());
	}


	public static Map generatePassword(String password)
	{
		String salt = randomNumberGenerator.nextBytes().toHex();
		String newPassword = generatePassword(password,salt);
		Map result = new HashMap();
		result.put("salt", salt);
		result.put("password", newPassword);
		return result;
		
	}
	/**
	 * 
	 * @Title: generatePassword 
	 * @Description: 生成密码
	 * @param password 密码明文
	 * @param salt 密码加密的salt
	 * @return 参数  返回加密后的密码
	 */
	public static String generatePassword(String password, String salt) {
		// 组合username,两次迭代，对密码进行加密
		String password_cipherText = new Md5Hash(password, salt, 2).toBase64();
		System.out.println("password:" + password_cipherText);
		System.out.println("salt:" + salt);
		return password_cipherText;
	}

	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public static String getRanSalt() {
		return randomNumberGenerator.nextBytes().toHex();
	}

	public static void main(String[] args) {
		// String password = "admin";
		// String cipherText = encrytHex(password);
		// System.out.println(password + "hex加密之后的密文是：" + cipherText);
		// String decrptPassword = decryptHex(cipherText);
		// System.out.println(cipherText + "hex解密之后的密码是：" + decrptPassword);
		// String cipherText_base64 = encrytBase64(password);
		// System.out.println(password + "base64加密之后的密文是：" + cipherText_base64);
		// String decrptPassword_base64 = decryptBase64(cipherText_base64);
		// System.out.println(cipherText_base64 + "base64解密之后的密码是：" +
		// decrptPassword_base64);
		// String h64 = H64.encodeToString(password.getBytes());
		// System.out.println(h64);
		// String salt = "7road";
		// String cipherText_md5 = new Md5Hash(password, salt, 4).toHex();
		// System.out.println(password + "通过md5加密之后的密文是：" + cipherText_md5);
		// System.out.println(generateKey());
		// System.out.println("==========================================================");
		// AesCipherService aesCipherService = new AesCipherService();
		// aesCipherService.setKeySize(128);
		// Key key = aesCipherService.generateNewKey();
		// String aes_cipherText = aesCipherService.encrypt(password.getBytes(),
		// key.getEncoded()).toHex();
		// System.out.println(password + " aes加密的密文是：" + aes_cipherText);
		// String aes_mingwen = new String(
		// aesCipherService.decrypt(Hex.decode(aes_cipherText),
		// key.getEncoded()).getBytes());
		// System.out.println(aes_cipherText + " aes解密的明文是：" + aes_mingwen);

	}

}
