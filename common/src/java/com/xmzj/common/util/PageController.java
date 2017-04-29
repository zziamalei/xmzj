package com.xmzj.common.util;

import java.util.ArrayList;
import java.util.List;

public final class PageController<E> {
	private int totalPage;
	private int totalSize;
	private int pageNow;
	private int pageInt;
	private int pageSize;
	private List<Integer> pageNumList;

	private List<E> dataList;

	public PageController(int totalSize, int pageSize, int pageInt) {
		if (pageSize < 1)// 10
			pageSize = 1;
		this.pageSize = pageSize;// 10

		totalPage = totalSize / pageSize;// 12/10=1
		if (totalSize % pageSize > 0) {// 12%10=2
			totalPage++;// 2
		}

		if (pageInt < 1) {// 1
			pageInt = 1;// 1
		} else {
			if (pageInt > totalPage) {
				pageInt = totalPage;
			}

		}

		this.pageInt = pageInt;
		this.pageNow = pageInt;
		this.totalSize=totalSize;
		
		//设置页码
		List<Integer> numList=new ArrayList<Integer>();
		int start=0;
		int end=0;
		if(pageInt-3>0){
			start=pageInt-3;
		}
		if(totalPage-pageInt-3>0){
			end=pageInt+3;
		}else{
			end=totalPage;
		}
		
		for(int i=start;i<end;i++){
			numList.add(i+1);
		}
	
		this.pageNumList=numList;
	}

	public final int getTotalPage() {
		return totalPage;
	}

	public final void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public final int getPageInt() {
		return pageInt;
	}

	public final int prePage() {
		if (pageInt > 1) {
			return --pageInt;
		} else {
			return 1;
		}
	}

	public final int nextPage() {
		if (pageInt < totalPage) {
			return ++pageInt;
		} else {
			return totalPage;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getDataList() {
		return dataList;
	}

	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageNow() {
		return pageNow;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<Integer> getPageNumList() {
		return pageNumList;
	}

	public void setPageNumList(List<Integer> pageNumList) {
		this.pageNumList = pageNumList;
	}

	
	

}
