/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  [PeakeCloud] 
 * @Package:      [com.xmzj.common.util.RSATester.java]
 * @ClassName:    [RSATester]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [RayMa]   
 * @CreateDate:   [2016年6月1日 下午2:34:25]   
 * @UpdateUser:   [RayMa]   
 * @UpdateDate:   [2016年6月1日 下午2:34:25]   
 * @UpdateRemark: [说明本次修改内容]  
 * @Version:      [v1.0] 
 *    
 */
package com.xmzj.common.util;

import java.util.Map;

/**
 * @author lei.ma 2016年6月1日 下午2:34:25
 *
 */
public class RSATester {
	static String publicKey;  
    static String privateKey;  
  
    static {  
        try {  
            Map<String, Object> keyMap = RSAUtils.genKeyPair();  
            publicKey = RSAUtils.getPublicKey(keyMap);  
            privateKey = RSAUtils.getPrivateKey(keyMap);  
            System.err.println("公钥: \n\r" + publicKey);  
            System.err.println("私钥： \n\r" + privateKey);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
//        test();  
        testSign();  
    }  
  
    static void test() throws Exception {  
        System.err.println("公钥加密——私钥解密");  
        String source = "这是一行要进行RSA加密的原始数据&100";  
        System.out.println("\r加密前文字：\r\n" + source);  
        byte[] data = source.getBytes();  
        //公钥加密  
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);  
        System.out.println("加密后文字：\r\n" + new String(encodedData));  
        //私钥解密  
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);  
        String target = new String(decodedData);  
        System.out.println("解密后文字: \r\n" + target);  
    }  
  
    static void testSign() throws Exception {  
        System.err.println("私钥加密——公钥解密");  
        String source = "my Test -----200---测试RSA数字签名的原始数据";  
        System.out.println("原文字：\r\n" + source);  
        byte[] data = source.getBytes();  
        //私钥加密  
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);  
        System.out.println("加密后：\r\n" + new String(encodedData));  
        //公钥解密  
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);  
        String target = new String(decodedData);  
        System.out.println("解密后: \r\n" + target);  
  
        System.err.println("私钥签名——公钥验证签名");  
        String sign = RSAUtils.sign(encodedData, privateKey);  
        System.err.println("签名:\r" + sign);  
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);  
        System.err.println("验证结果:\r" + status);  
    }  
}
