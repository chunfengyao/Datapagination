package com.ycf.pagination.dao;

import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;

/**
	 * 
	 * 数据访问层接口设计
	 * @author 14325
	 *
	 */
public interface INewsDao {
	//获取一页数据
	public void getOnePage(PageBean<NewsBean> td);
	//获取总数
	public int getTotleNum(PageBean<NewsBean> td);
}
