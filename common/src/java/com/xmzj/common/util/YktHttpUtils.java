package com.xmzj.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import org.omg.CORBA.Object;


public class YktHttpUtils {

	private static Logger log = Logger.getLogger(YktHttpUtils.class);

	/**
	 * post请求
	 * 
	 * @author lei.ma 2016年6月8日 上午11:39:08
	 * @param url
	 *            请求地址
	 * @param paramsMap
	 *            请求参数
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws URISyntaxException
	 */
	public static String httpPostRequest(String url, Map<String, Object> paramsMap)
			throws UnsupportedEncodingException, URISyntaxException {
		log.info("请求一卡通地址");
		log.info(url);
		if(url.startsWith("null")||StringUtils.isEmpty(url)||!url.startsWith("http")) {
			//在获取不到运营商配置的一卡通地址信息，会导致运行时间过长 2016-08-05 17:11:54
			return null;
		}
		Map map = new HashMap<String,Object>();
		if (null != paramsMap) {

			String str = JSONObject.toJSONString(paramsMap);// 转unicode
			str=YktHttpUtils.strToUnicode(str);
			
			
			log.info("请求一卡通参数");
			log.info(str);
			
			if(str.equals("{}")){
				map=null;
			}else{
				String  data = new String(YKTBase64.encode(str.getBytes("UTF-8"),YKTBase64.DEFAULT));
				data = data.replaceAll("[\\s*\t\n\r]", "");
				log.info("加密后：");
				log.info(data);
				map.put("params", data);
			}
			
			String returnStr;
			try {
				returnStr = HttpClientUtil.httpPostRequest(url, map);
				log.info("一卡通返回信息");
				log.info(returnStr);
				return returnStr;
			} catch (Exception e) {
				
				e.printStackTrace();
				log.error("一卡通处理失败"+e);
				return null;
			}
		
		} else {
			return HttpClientUtil.httpPostRequest(url, map);
		}

	}
	public static String httpGetRequest(String url, Map<String, Object> paramsMap)
			throws UnsupportedEncodingException, URISyntaxException {
		log.info("请求一卡通地址");
		log.info(url);
		if(url.startsWith("null")||StringUtils.isEmpty(url)||!url.startsWith("http")) {
			//在获取不到运营商配置的一卡通地址信息，会导致运行时间过长 2016-08-05 17:11:54
			return null;
		}
		Map map = new HashMap<String,Object>();
		if (null != paramsMap) {
			
			String str = JSONObject.toJSONString(paramsMap);// 转unicode
			str=YktHttpUtils.strToUnicode(str);
			
			
			log.info("请求一卡通参数");
			log.info(str);
			
			if(str.equals("{}")){
				map=null;
			}else{
				String  data = new String(YKTBase64.encode(str.getBytes("UTF-8"),YKTBase64.DEFAULT));
				data = data.replaceAll("[\\s*\t\n\r]", "");
				log.info("加密后：");
				log.info(data);
				map.put("params", data);
			}
			
			String returnStr;
			try {
				returnStr = HttpClientUtil.httpGetRequest(url, map);
				log.info("一卡通返回信息");
				log.info(returnStr);
				return returnStr;
			} catch (Exception e) {
				
				e.printStackTrace();
				log.error("一卡通处理失败"+e);
				return null;
			}
			
		} else {
			return HttpClientUtil.httpGetRequest(url, map);
		}
		
	}
	
	
	public static String yktParams(String str){
		 if(StringUtils.isEmpty(str))return null;
		
		 byte[] ss=YKTBase64.decode(str.getBytes(), YKTBase64.DEFAULT);
         return new String(ss);
	}

	public static void main(String[] args) throws Exception {
//		YktHttpUtils.httpPostRequest("https://www.baidu.com", null);
//		System.out.println(new String(YKTBase64.encode("abc".getBytes("UTF-8"),YKTBase64.DEFAULT)));
//		String jb=YktHttpUtils.unicode2Utf8("eyJ2aXJ0dWFsX2lkIjoiNDU4NDc1OTY4NCJ9");
//		System.out.println(jb);
//		JSONObject  jb=JsonUtils.decodeParams2Json("eyJ2aXJ0dWFsX2lkIjoiNDU4NDc1OTY4NCJ9");
		String str="\u7528\u6237\u540d\u6216\u5bc6\u7801\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u8bd5";
		 byte[] ss=YKTBase64.decode("eyJ2aXJ0dWFsX2lkIjoiNDU4NDc1OTY4NCJ9".getBytes(), YKTBase64.DEFAULT);
		 
		System.out.println(new String(ss));
		
		for(int i=0;i<1000;i++){
			
			String sss=YktHttpUtils.httpPostRequest("http://192.168.1.27:8888/peakecloud/oneCard/getWallet", null);
			System.out.println(sss);
		}
	}
	
	
	
	
	
	
	public static String strToUnicode(String str){
		StringBuffer sb = new StringBuffer();
		char[] charArr = str.toCharArray();
		for(char ch: charArr){
			if (ch > 128 ) {
				sb.append("\\u" + Integer.toHexString(ch));
			}else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static String unicode2Utf8(String theString){
		
		char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = (value << 4) + aChar - '0';
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            value = (value << 4) + 10 + aChar - 'a';
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            value = (value << 4) + 10 + aChar - 'A';
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
	   
	   
	
}
