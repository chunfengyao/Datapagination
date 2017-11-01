package com.ycf.pagination;

/**
 * 视图层与控制端传递的数据对象的封装
 * @author 14325
 *
 */
public class PageBean<T> {
	//当前所在新闻列表页面数
	public int currentPage;
	//总行数
	public int wholeNums;
	//列表每页显示的行数
	public int lineNumPerPage;
	//服务端查询并返回的结果集
	public java.util.List<T> newsDatas;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLineNumPerPage() {
		return lineNumPerPage;
	}
	public void setLineNumPerPage(int lineNumPerPage) {
		this.lineNumPerPage = lineNumPerPage;
	}
	public int getWholeNums() {
		return wholeNums;
	}
	public void setWholeNums(int wholeNums) {
		this.wholeNums = wholeNums;
	}
	public java.util.List<T> getNewsDatas() {
		return newsDatas;
	}
	public void setNewsDatas(java.util.List<T> newsDatas) {
		this.newsDatas = newsDatas;
	}
	
	
}
