package com.ycf.pagination.service.impl;

import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.dao.impl.NewsDao;
import com.ycf.pagination.service.INewsService;

public class NewsServices implements INewsService {

	@Override
	public void getOnePageNews(PageBean<NewsBean> td) {
		NewsDao newsDao = new NewsDao();
		newsDao.getTotleNum(td);
		newsDao.getOnePage(td);
	}

}
