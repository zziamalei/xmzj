package com.xmzj.common.i18n;

import java.util.ArrayList;
import java.util.List;

public class I18nEdit3<C, I> {

	private C common;
	private List<I> i18nlist = new ArrayList<I>(2);

	public I18nEdit3() {
		
	}
	
	public C getCommon() {
		return common;
	}

	public void setCommon(C common) {
		this.common = common;
	}

	public List<I> getI18nlist() {
		return i18nlist;
	}

	public void setI18nlist(List<I> i18nlist) {
		this.i18nlist = i18nlist;
	}

}