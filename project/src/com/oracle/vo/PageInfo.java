package com.oracle.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	
	//查询结果
	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	
	//当前页号
	int currentPage = 1;
	
	//总记录数
	int recordCount = 0;
	
	//页面大小
	int pageSize = 5;
	
	//请求的url
	String url = null;

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	//获得总页数
	public int getPageCount() {
		
		return this.recordCount % this.pageSize == 0?this.recordCount / this.pageSize:(this.recordCount / this.pageSize)+1;
	}
	
	public PageInfo(HttpServletRequest request) {
		//设置当前页	
		if(request.getParameter("currentPage") != null) {
			this.currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}
		this.url = request.getRequestURL().toString();
		request.setAttribute("pageInfo", this);
		
	}
}
