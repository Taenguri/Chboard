package com.spring.chboard.vo;

public class PageVO {

	private int page;
	private int countPerPage;
	private int pStart;
	private int pEnd;

	public PageVO() {
		this.page = 1;
		this.countPerPage = 10;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	
	public void setCountPerPage(int countPerPage) {
		if (countPerPage <= 0 || countPerPage > 10) {
			this.countPerPage = 10;
			return;
		}
		this.countPerPage = countPerPage;
	}
	public int getCountPerPage() {
		return this.countPerPage;
	}
	
	public int getpStart() {
		pStart = ((page - 1) * countPerPage) + 1;
		return pStart;
	}
	
	public int getpEnd() {
		pEnd = pStart + countPerPage - 1;
		return pEnd;
	}	
	
}
