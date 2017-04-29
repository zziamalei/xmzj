package com.xmzj.common.i18n;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class I18nEdit2<C, I> {

	private C common;
	private List<Language> languageList;
//	private Map<String,I> i18nMap;
	private static final String EN_KEY = "en";
	private static final String CH_KEY = "ch";
	private List<I> i18nlist;
	private static final int LANGUAGE_COUNT = 2;

	public I18nEdit2(){
		init();
	}
	public C getCommon() {
		return common;
	}

	public void setCommon(C common) {
		this.common = common;
	}
	
//	public void setitemEn(I item){
//		i18nMap.put(EN_KEY, item);
//	}
//	public void setitemCh(I item){
//		i18nMap.put(CH_KEY, item);
//	}

//	public I getitemEn(I item){
//		return i18nMap.get(EN_KEY);
//	}
//	public I getitemCh(I item){
//		return i18nMap.get(CH_KEY);
//	}
	
	public void init(){
		languageList = new ArrayList<Language>();
		Language languageEn = new Language(EN_KEY,"English");
		Language languageCh = new Language(CH_KEY,"中文");
		languageList.add(languageEn);
		languageList.add(languageCh);
		getList();
//		i18nMap = new HashMap<String,I>();
	}

	public List<Language> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(List<Language> languageList) {
		this.languageList = languageList;
	}
//	public Map<String, I> getI18nMap() {
//		return i18nMap;
//	}
//	public void setI18nMap(Map<String, I> i18nMap) {
//		this.i18nMap = i18nMap;
//	}
	
	public List<I> getI18nlist() {

		if (i18nlist == null) {
			return  new ArrayList<I>();
		}
		return i18nlist;
	} 
	
	public void setitemEn(I item){
		if (i18nlist == null || i18nlist.isEmpty()) {
			getList();
			if (i18nlist != null) {
				i18nlist.add(item);
			}
		}
		
	}
	public void setitemCh(I item){
		if (i18nlist == null) {
			getList();
		}
		if (i18nlist.size() == 1) {
			i18nlist.add(item);
			return;
		}
		if (i18nlist.size() == 2) {
			i18nlist.set(2, item);
			return;
		}
	}

	public void setI18nlist(List<I> i18nlist) {
		this.i18nlist = i18nlist;
	}

	public I getI() throws InstantiationException, IllegalAccessException {
//		Type sType = getClass().getGenericSuperclass();
//		Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();
//		Class<I> mTClass = (Class<I>) sType;
//		return I.newInstance();
		return null;
	}
	
	public void getList(){
		i18nlist = new ArrayList<I>();
		try {
			for (int i = 0; i < LANGUAGE_COUNT; i++) {
				
				I i18nitem = getI();
				i18nlist.add(i18nitem);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}