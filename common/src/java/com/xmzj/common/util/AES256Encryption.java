/**   
 *  
 * AES256加密  
 * @ProjectName:  [PeakeCloud] 
 * @Package:      [com.xmzj.common.util.Aes256Encryptor.java]
 * @ClassName:    [Aes256Encryptor]   
 * @Description:  对信息进行ase256加密  
 * @Author:       [RayMa]   
 * @CreateDate:   [2016年6月1日 下午2:48:07]   
 * @UpdateUser:   [RayMa]   
 * @UpdateDate:   [2016年6月1日 下午2:48:07]   
 * @UpdateRemark: [说明本次修改内容]  
 * @Version:      [v1.0] 
 *    
 */
package com.xmzj.common.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author lei.ma 2016年6月1日 下午2:48:07
 *
 */
public class AES256Encryption {
	public static final String KEY_ALGORITHM = "AES";

	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

	public static byte[] initkey() throws Exception {

		// 实例化密钥生成器
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
		kg.init(256);
		kg.init(128);

		SecretKey secretKey = kg.generateKey();

		return secretKey.getEncoded();
	}

	public static byte[] initRootKey() throws Exception {

		return new byte[] { 0x08, 0x08, 0x04, 0x0b, 0x02, 0x0f, 0x0b, 0x0c, 0x01, 0x03, 0x09, 0x07, 0x0c, 0x03, 0x07,
				0x0a, 0x04, 0x0f, 0x06, 0x0f, 0x0e, 0x09, 0x05, 0x01, 0x0a, 0x0a, 0x01, 0x09, 0x06, 0x07, 0x09, 0x0d };

	}

	public static Key toKey(byte[] key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);

		return secretKey;
	}

	/**
	 * 加密
	 * @author lei.ma 2016年6月1日 下午2:59:31 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {

		Key k = toKey(key);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");

		cipher.init(Cipher.ENCRYPT_MODE, k);

		return cipher.doFinal(data);
	}

	/**
	 * 解密
	 * @author lei.ma 2016年6月1日 下午2:59:54 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

		Key k = toKey(key);

		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");

		cipher.init(Cipher.DECRYPT_MODE, k);

		return cipher.doFinal(data);
	}
	
	
	public static String createStringKey() throws Exception{
		// 生成随机密钥
		return MyBase64.encode(AES256Encryption.initkey());
	}
	
	
	/**
	 * 解密
	 * @author lei.ma 2016年6月1日 下午3:12:25 
	 * @param key
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	public static String decrypt2String(String key,String data) throws Exception{
		byte[] m = AES256Encryption.decrypt( MyBase64.decode(data), MyBase64.decode(key));
		return new String(m);
	}
	
	/**
	 * 加密
	 * @author lei.ma 2016年6月1日 下午3:12:16 
	 * @param key
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encrypt2String(String key,String data) throws Exception{
		byte[] m = AES256Encryption.encrypt(data.getBytes(), MyBase64.decode(key));
		return MyBase64.encode(m);
	}
	

	public static void main(String[] args) throws UnsupportedEncodingException {

		
		
		
		String str = "芸sweet";

		// 打印原文
		System.out.println("原文：" + str);

		// 密钥
		byte[] key;

		try {

			// 生成随机密钥
			key = AES256Encryption.initkey();
			
			System.out.println("base64:"+MyBase64.encode(key));
			key=MyBase64.decode(MyBase64.encode(key));
			// 打印密钥
			System.out.print("密钥：");
			for (int i = 0; i < key.length; i++) {
				System.out.printf("%x", key[i]);
			}
			System.out.print("\n");

			// 加密
			byte[] data = AES256Encryption.encrypt(str.getBytes(), key);

			// 打印密文
			System.out.print("加密后：");

			for (int i = 0; i < data.length; i++) {
				System.out.printf("%x", data[i]);
			}

			
			
			// 解密密文
			data = AES256Encryption.decrypt(data, key);
			// 打印原文
			System.out.println("解密后：" + new String(data));
			
			System.out.println("========================");
			String key2=AES256Encryption.createStringKey();
			key2="E5qj3IUr9aYuaPOztSj81A==";
			long lStart = System.currentTimeMillis();
			String mi=AES256Encryption.encrypt2String(key2, "{\"name\":\"普波\"}");
			long lUseTime = System.currentTimeMillis() - lStart;
			System.out.println("加密耗时：" + lUseTime + "毫秒");
			System.out.println("加密后："+mi);
			System.out.println(java.net.URLEncoder.encode(mi, "utf-8"));
			lStart = System.currentTimeMillis();
			System.out.println("解密后："+AES256Encryption.decrypt2String(key2, mi));
			lUseTime = System.currentTimeMillis() - lStart;
			System.out.println("解密耗时：" + lUseTime + "毫秒");
		} catch (

		Exception e) {

			e.printStackTrace();
		}

	}
}
