package com.xmzj.common.util;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalParam {
	
	private static Map<String,Map<String,String>> map = new ConcurrentHashMap<String,Map<String,String>>();
	
	//增加，线程安全
	public static void addParamMap(String access_token,String datetime){
		
		Map<String,String> tempMap = new ConcurrentHashMap<String, String>();
		tempMap.put("access_token", access_token);
		tempMap.put("dateTime", datetime);
		map.put("tokenInfo", tempMap);
		
	}
	
	//获取
	public static String getParamMap() throws Exception{
		
		if(map.get("tokenInfo")==null){
			return null;
		}else{
			//比较时间
			Map<String,String> tempMap = map.get("tokenInfo");
			String dateTime = tempMap.get("dateTime");
			Timestamp tem =new Timestamp(DateTimeUtil.parseDate(dateTime).getTime());
			
			long temp = DateTimeUtil.getBetweenTimeStamp(tem, DateTimeUtil.getNowTimeStamp());
			//如果相隔时间大于60分钟，实际是120分钟后失效,则删除
			int mm = (int) (temp/(1000*60));
			if(mm>60){
				 Iterator<Map.Entry<String, Map<String,String>>> it = map.entrySet().iterator();  
			        while(it.hasNext()){  
			            Map.Entry<String, Map<String,String>> entry=it.next();  
			            String key=entry.getKey();  
			            if("tokenInfo".equals(key)){  
			                it.remove();        //OK   
			            }  
			        }
			        return null;
			}else{
				//否则返回access_token
				Map<String,String> param = map.get("tokenInfo");
				String access_token = param.get("access_token");
				return access_token;
			}
		}
	}
}
