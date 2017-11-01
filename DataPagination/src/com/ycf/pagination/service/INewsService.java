package com.ycf.pagination.service;

import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;

public interface INewsService {
	public void getOnePageNews(PageBean<NewsBean> td);

}
