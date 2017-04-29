package com.xmzj.common.i18n;

public class Language {

	private String key;
	private String description;
	Language(){
		
	}
	
	public Language(String key,String description){
		this.key = key;
		this.description=description;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
