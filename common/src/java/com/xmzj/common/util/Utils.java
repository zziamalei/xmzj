package com.xmzj.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Utils {
	/**  
     * 对象转数组  
     * @param obj  
     * @return  
     */  
    public static byte[] toByteArray (Object obj) {      
        byte[] bytes = null;      
        ByteArrayOutputStream bos = new ByteArrayOutputStream();      
        try {        
            ObjectOutputStream oos = new ObjectOutputStream(bos);         
            oos.writeObject(obj);        
            oos.flush();         
            bytes = bos.toByteArray ();      
            oos.close();         
            bos.close();        
        } catch (IOException ex) {        
            ex.printStackTrace();   
        }      
        return bytes;    
    }   
       
    /**  
     * 数组转对象  
     * @param bytes  
     * @return  
     */  
    public static Object toObject (byte[] bytes) {      
        Object obj = null;      
        try {        
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
            ObjectInputStream ois = new ObjectInputStream (bis);        
            obj = ois.readObject();      
            ois.close();   
            bis.close();   
        } catch (IOException ex) {        
            ex.printStackTrace();   
        } catch (ClassNotFoundException ex) {        
            ex.printStackTrace();   
        }      
        return obj;    
    }
    
    /**
     * 字符串转16进制
     * 2016年7月4日14:58:25
     */
    public static String str2HexStr(String str)    
    {      
      
        char[] chars = "0123456789ABCDEF".toCharArray();      
        StringBuilder sb = new StringBuilder("");    
        byte[] bs = str.getBytes();      
        int bit;      
            
        for (int i = 0; i < bs.length; i++)    
        {      
            bit = (bs[i] & 0x0f0) >> 4;      
            sb.append(chars[bit]);      
            bit = bs[i] & 0x0f;      
            sb.append(chars[bit]);  
        }      
        return sb.toString().trim();      
    } 
    
    /**
	 * 验证：中文、英文、数字
	 * 2016-08-09 11:34:49
	 * 孔令齐
	 * type：
	 * 0，用户名：@_.汉字
	 * 1，密码：英文字母和数字
	 * 2，链接：:/.
	 * 3，坐标：.,
	 * 4,邮箱类：@_.
	 * return:
	 * true==不存在特殊字符
	 * false===存在特殊字符
	 */
	public static boolean checkSpecialCharacter(String info,int type) {
		//[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]
		String regex = "";
		if(type == 0) {
			regex="[a-zA-Z0-9\u4E00-\u9FA5@._]";
		} else if(type == 1 || type == 2 || type == 3 || type == 4) {
			regex="[a-zA-Z0-9]";
			if(type == 2) {
				regex="[a-zA-Z0-9:/.]";
			} else if(type == 3) {
				regex="[a-zA-Z0-9.,]";
			} else if(type == 4) {
				regex="[a-zA-Z0-9@_.]";
			}
		}
		
		boolean b=true;
		String checkInfo = StringFilter(regex, info);
		if(checkInfo.length() > 0) {
			b = false;
        } else {
        	b = true;
		}
		return b;
	}
	
	public static String StringFilter(String regEx,String str) throws PatternSyntaxException {
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}    
	
	public static void main(String[] args) {
		String str = "孔令齐。1@2.3_4ddd";
		System.out.println("验证用户名");
		if(checkSpecialCharacter(str, 0)) {
			System.out.println("用户名:"+str+"不存在非法字符");
		} else {
			System.out.println("用户名:"+str+"存在非法字符");
		}
		str = "孔令齐1234ddd";
		System.out.println("验证密码");
		if(checkSpecialCharacter(str, 1)) {
			System.out.println("密码:"+str+"不存在非法字符");
		} else {
			System.out.println("密码:"+str+"存在非法字符");
		}
		str = "http://www.baidu.com--";
		System.out.println("验证链接");
		if(checkSpecialCharacter(str, 2)) {
			System.out.println("链接:"+str+"不存在非法字符");
		} else {
			System.out.println("链接:"+str+"存在非法字符");
		}
		str = "113.12,55.56";
		System.out.println("验证坐标");
		if(checkSpecialCharacter(str, 3)) {
			System.out.println("坐标:"+str+"不存在非法字符");
		} else {
			System.out.println("坐标:"+str+"存在非法字符");
		}
		str = "konglingqi3601@sina.com";
		System.out.println("验证邮箱");
		if(checkSpecialCharacter(str, 4)) {
			System.out.println("邮箱:"+str+"不存在非法字符");
		} else {
			System.out.println("邮箱:"+str+"存在非法字符");
		}
		
		
//		String regEx="[a-zA-Z0-9\u4E00-\u9FA5@._]";   
//        Pattern p = Pattern.compile(regEx);   
//        String s = "孔令齐。1@2.3_4ddd";
//        Matcher m = p.matcher(s);
//        int t = m.replaceAll("").trim().length();
//        if(t == s.length()) {
//        	System.out.println(s+":不存在非法字符");
//        } else {
//        	System.out.println(s+":存在非法字符");
//        }
//        System.out.println(m.replaceAll("").trim()+":"+m.matches());
//        String   str   =   "*adCVs*34_a _09_b5*[/435^*&城池()^$$&*).{}+.|.)%%*(*.中国}34{45[]12.fd'*&999下面是中文的字符￥……{}【】。，；’“‘”？";      
//        System.out.println(str);      
//        System.out.println(StringFilter("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]",str));     
	}
	
	/**
	 * 获取项目根目录 需在web。xml配置linstener
	 * @return
	 */
	public static String getProjectRealPath(){
		return System.getProperty("evan.webapp");
	}
	
	public static String replaceQuot(String str){
		if (str == null) {
			return null;
		}
		
		return str.replaceAll("\"","&quot;");
	}

}
