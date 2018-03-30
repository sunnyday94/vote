package com.chunmi.vote.vo;

public class BaseObject {

	/**
	 * 起始条目
	 */
	private int start;
	
	/**
	 * 终止条目
	 */
	private int end;
	
	/**
	 * 当前页
	 */
	private int pageCurrent;
	
	/**
	 * 每页条目数
	 */
	private int pageSize;
	
	/**
	 * 总页数
	 */
	private int pageCount;
	
	/**
	 * 按条件排序
	 */
	private String orderBy;
	
	
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
