package com.xmzj.common.util;

public class ByteBinaryUtils {
	/**
	 * 把byte数组转化成2进制字符串
	 * 
	 * @param bArr
	 * @return
	 */
	public String getBinaryStrFromByteArr(byte[] bArr) {
		String result = "";
		for (byte b : bArr) {
			result += getBinaryStrFromByte(b);
		}
		return result;
	}

	/**
	 * 把byte转化成2进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public String getBinaryStrFromByte(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			byte c = a;
			a = (byte) (a >> 1);// 每移一位如同将10进制数除以2并去掉余数。
			a = (byte) (a << 1);
			if (a == c) {
				result = "0" + result;
			} else {
				result = "1" + result;
			}
			a = (byte) (a >> 1);
		}
		return result;
	}

	/**
	 * 把byte转化成2进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public String getBinaryStrFromByte2(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			result = (a % 2) + result;
			a = (byte) (a >> 1);
		}
		return result;
	}

	/**
	 * 把byte转化成2进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public String getBinaryStrFromByte3(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			result = (a % 2) + result;
			a = (byte) (a / 2);
		}
		return result;
	}

	public static String byte2bits(byte b) {

		int z = b;
		z |= 256;
		String str = Integer.toBinaryString(z);
		int len = str.length();
		return str.substring(len - 8, len);
	}

	// 将二进制字符串转换回字节

	public static byte bit2byte(String bString) {
		byte result = 0;
		for (int i = bString.length() - 1, j = 0; i >= 0; i--, j++) {
			result += (Byte.parseByte(bString.charAt(i) + "") * Math.pow(2, j));
		}
		return result;
	}
}
