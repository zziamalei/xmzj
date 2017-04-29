/**   
 *  
 * 验证码工具类  
 * @ProjectName:  [PeakeCloud] 
 * @Package:      [com.xmzj.common.util.CodeUtils.java]
 * @ClassName:    [CodeUtils]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [lei.ma]   
 * @CreateDate:   [2016年6月3日 上午10:43:51]   
 * @UpdateUser:   [RayMa]   
 * @UpdateDate:   [2016年6月3日 上午10:43:51]   
 * @UpdateRemark: [说明本次修改内容]  
 * @Version:      [v1.0] 
 *    
 */
package com.xmzj.common.util;

/**
 * @author lei.ma 2016年6月3日 上午10:43:51
 *
 */
public class CodeUtils {
	
	/**
	 * 生成包含数字、大小写字母的随机码
	 * @author lei.ma 2016年6月3日 上午10:44:09 
	 * @param length 随机码长度
	 * @return
	 */
	public static String createCode(int length) {

		String[] rS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i",
				"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
				"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
				"Z" };

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * rS.length);
			sb.append(rS[index]);
		}
		return sb.toString();

	}
	
	/**
	 * 生成数字随机码
	 * @author lei.ma 2016年6月3日 上午10:45:58 
	 * @param length 随机码长度
	 * @return
	 */
	public static String createDigitCode(int length) {
		
		String[] rS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * rS.length);
			sb.append(rS[index]);
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(createCode(10));
	}
}
