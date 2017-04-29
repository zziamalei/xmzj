package com.xmzj.common.Enums;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
//import com.poobo.ad.enums.EnumAdLocationType;
//import com.poobo.ad.enums.EnumAdType;
//import com.poobo.collection.enums.EnumCollectionType;
//import com.poobo.order.enums.EnumDiliverType;
//import com.poobo.pay.paymanage.enums.EnumPayDataStatus;
//import com.poobo.pay.paymanage.enums.EnumPayType;
//import com.poobo.sms.EnumSmsType;

public class EnumsUtils {

	/**
	 * 获取枚举列表
	 * 
	 * @author lei.ma 2017年1月5日上午10:32:11
	 * @param em
	 * @return
	 */
	public static Map<Integer, String> toCodeDescriptionMap(Enum em) {
		Class clazz = em.getDeclaringClass();
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		try {
			Method toName = clazz.getMethod("getDesc");
			Method toCode = clazz.getMethod("getValue");
			// 得到enum的所有实例
			Object[] objs = clazz.getEnumConstants();
			for (Object obj : objs) {
				map.put((Integer) toCode.invoke(obj), (String) toName.invoke(obj));
			}
			return map;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取所有值和描述
	 * 
	 * @author lei.ma 2017年1月5日上午10:35:58
	 * @param em
	 * @return
	 */
	public static String getAllDesc(Enum em) {
		StringBuffer sb = new StringBuffer();
		Class clazz = em.getDeclaringClass();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		try {
			Method toName = clazz.getMethod("getDesc");
			Method toCode = clazz.getMethod("getValue");
			// 得到enum的所有实例
			Object[] objs = clazz.getEnumConstants();
			for (Object obj : objs) {
				map.put(String.valueOf(toCode.invoke(obj)), String.valueOf(toName.invoke(obj)));
				sb.append(toCode.invoke(obj) + ":" + toName.invoke(obj) + ",");
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	public static String getAllNameDesc(Enum em) {
		StringBuffer sb = new StringBuffer();
		Class clazz = em.getDeclaringClass();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		try {
			Method toName = clazz.getMethod("getDesc");
			Method toCode = clazz.getMethod("getValue");
			// 得到enum的所有实例
			Object[] objs = clazz.getEnumConstants();
			for (Object obj : objs) {
				map.put(String.valueOf(toCode.invoke(obj)), String.valueOf(toName.invoke(obj)));
				sb.append(obj+":" + toName.invoke(obj) + ",");
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}

	public static LinkedHashMap<String, String> getEnumList(Enum em) {
		Class clazz = em.getDeclaringClass();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		try {
			Method toName = clazz.getMethod("getDesc");
			Method toCode = clazz.getMethod("getValue");
			// 得到enum的所有实例
			Object[] objs = clazz.getEnumConstants();
			for (Object obj : objs) {
				map.put(String.valueOf(toCode.invoke(obj)), String.valueOf(toName.invoke(obj)));
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
return map;
	}

	public static void main(String[] args) {
//		System.out.println(JSONObject.toJSONString(EnumsUtils.toCodeDescriptionMap(EnumSmsType.alert_auth)));
//		System.out.println(EnumsUtils.getAllDesc(EnumAdType.dish));
//		System.out.println(EnumsUtils.getAllDesc(EnumDiliverType.reach));
//		System.out.println(EnumsUtils.getAllDesc(EnumPayDataStatus.cancel));
//		System.out.println(EnumsUtils.getAllDesc(EnumAdType.dish));
//		System.out.println(EnumsUtils.getAllDesc(EnumAdLocationType.index));
//		System.out.println(EnumsUtils.getAllDesc(EnumPayType.alipay_app));
//		System.out.println(EnumsUtils.getAllNameDesc(EnumCollectionType.dish));
//		System.out.println(EnumsUtils.getAllDesc(EnumCollectionType.dish));
	}
}
