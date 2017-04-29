package com.xmzj.common.util;

public class LngLatDistanceUtils {

	/**
	 * 计算地球上任意两点(经纬度)距离
	 * 
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double Distance(double long1, double lat1, double long2, double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}
	
	public static void main(String[] args) {
//		113.953258,22.539861
//		113.952174,22.538949
//		113.953569,22.539692
		double long1=113.953258; double lat1=22.539861;  double long2=113.953569;  double lat2=22.539692; 
		double d=LngLatDistanceUtils.Distance( long2, lat2,long1, lat1);
		System.out.println(d);
	}

}
