package com.ycf.pagination.service.impl;

import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.dao.impl.NewsDao;
import com.ycf.pagination.service.INewsService;

public class NewsServices implements INewsService {
	NewsDao newsDao = new NewsDao();
	
	@Override
	public void getOnePageNews(PageBean<NewsBean> td) {
		newsDao.getOnePage(td);
	}
	@Override
	public void getTotleNum(PageBean<NewsBean> td){
		newsDao.getTotleNum(td);
	}

}
