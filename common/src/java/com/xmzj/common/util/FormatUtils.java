package com.xmzj.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.util.TextUtils;

public class FormatUtils {

	public static String fen2yuan(long fen){
		
		double priceDouble = fen/100.0;
		return String.format("%.2f" ,priceDouble);
	}
	
	public static Long yuan2fen(double yuan){
		return  (long)(yuan*100);
	}
	
	/*** 
     * 把中文替换为指定字符<br> 
     * 注意:一次只匹配一个中文字符 
     * @param source 
     * @param replacement 
     * @return 
     */  
    public static String replaceChinese(String source, String replacement){  
        if(TextUtils.isEmpty(source)){  
            return "";  
        }  
        if(TextUtils.isEmpty(replacement)){  
            replacement = "";
        }  
        String reg = "[\u4e00-\u9fa5]";  
        Pattern pat = Pattern.compile(reg);    
        Matcher mat=pat.matcher(source);   
        String repickStr = mat.replaceAll(replacement);  
        return repickStr;  
    } 
	
}
