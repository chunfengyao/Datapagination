package com.ycf.pagination;

import java.util.List;

/**
 * 视图层与控制端传递的数据对象的封装
 * @author 14325
 *
 */
public class PageBean<T> {
	//当前所在新闻列表页面数
	public String currentPage;
	//总行数
	public String wholeNums;
	//列表每页显示的行数
	public String lineNumPerPage;
	//服务端查询并返回的结果集
	public List<T> resaultSet;
	
	
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getWholeNums() {
		return wholeNums;
	}
	public void setWholeNums(String wholeNums) {
		this.wholeNums = wholeNums;
	}
	public String getLineNumPerPage() {
		return lineNumPerPage;
	}
	public void setLineNumPerPage(String lineNumPerPage) {
		this.lineNumPerPage = lineNumPerPage;
	}
	public java.util.List<T> getResaultSet() {
		return resaultSet;
	}
	public void setResaultSet(List<T> resaultSet) {
		this.resaultSet = resaultSet;
	}
	
	
}
