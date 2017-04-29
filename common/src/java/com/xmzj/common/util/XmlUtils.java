package com.xmzj.common.util;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtils {
	private static Logger log = Logger.getLogger(XmlUtils.class);

	/**
	 * 解析单层数据
	 * @author lei.ma 2016年7月10日 上午11:52:35 
	 * @param inputString
	 * @param noteName
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> singleDeck(String inputString, String noteName) throws Exception {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		// 读取文件 转换成Document
		Document document = reader.read(new ByteArrayInputStream(inputString.getBytes("UTF-8")));
		// 获取根节点元素对象
		Element root = document.getRootElement();
		// 遍历
		return listsingleDeckNodes(root, noteName, null);
	}

	public static void test(String inputString) throws Exception {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		// 读取文件 转换成Document
		Document document = reader.read(new ByteArrayInputStream(inputString.getBytes("UTF-8")));
		// 获取根节点元素对象
		Element root = document.getRootElement();
		// 遍历
		listNodes(root);
	}

	/**
	 * 解析单层数据
	 * @author lei.ma 2016年7月10日 上午11:52:53 
	 * @param node
	 * @param noteName
	 * @param rList
	 * @return
	 */
	public static List<Map<String, Object>> listsingleDeckNodes(Element node, String noteName,
			List<Map<String, Object>> rList) {
		log.debug("当前节点的名称：" + node.getName());
		// 首先获取当前节点的所有属性节点
		List<Attribute> list = node.attributes();
		Map<String, Object> map = null;
		if (node.getName().equals(noteName)) {
			for (Attribute attribute : list) {
				log.debug("属性" + attribute.getName() + ":" + attribute.getValue());

				if (null==map)
					map = new HashMap<String, Object>();
				map.put(attribute.getName(), (attribute.getValue()==null||attribute.getValue().toLowerCase().equals("null"))?null:attribute.getValue());
			}
			if(null==rList)rList=new ArrayList<Map<String, Object>>();
			rList.add(map);
		}

		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();

			rList=listsingleDeckNodes(e, noteName, rList);
		}

		return rList;
	}

	// 遍历当前节点下的所有节点
	public static void listNodes(Element node) {
		System.out.println("当前节点的名称：" + node.getName());
		// 首先获取当前节点的所有属性节点
		List<Attribute> list = node.attributes();

		// 遍历属性节点
		for (Attribute attribute : list) {
			log.debug("属性" + attribute.getName() + ":" + attribute.getValue());

			// rtList.add(new XmlObj(attribute.getName(),
			// attribute.getValue()));
		}
		// 如果当前节点内容不为空，则输出
		if (!(node.getTextTrim().equals(""))) {
			log.debug(node.getName() + "：" + node.getText());
		}
		// 同时迭代当前节点下面的所有子节点
		// 使用递归
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			listNodes(e);
		}

	}

}
