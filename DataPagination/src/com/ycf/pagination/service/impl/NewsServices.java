package com.ycf.pagination.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.Action;
import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.dao.impl.NewsDao;
import com.ycf.pagination.service.INewsService;

public class NewsServices implements INewsService,Action{
	//获取log4j的日志对象
	Log log = LogFactory.getLog(NewsServices.class);
	//全局默认的每页显示行数
	private static String LINENUNPERPAGE = "4";
	//创建对象的引用接收struts封装的数据
	private NewsDao newsDao;
	//创建对象的引用接收struts封装的数据
	private PageBean<NewsBean> pageBean;
	
	public PageBean<NewsBean> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<NewsBean> pageBean) {
		this.pageBean = pageBean;
	}
	public NewsDao getNewsDao() {
		return newsDao;
	}
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	//设置变量以接收翻页的超链接传递的数据
		private String currentpage;
		private String lineNumPerPage;
		
		public String getCurrentpage() {
			return currentpage;
		}
		public void setCurrentpage(String currentpage) {
			this.currentpage = currentpage;
		}
		public String getLineNumPerPage() {
			return lineNumPerPage;
		}
		public void setLineNumPerPage(String lineNumPerPage) {
			this.lineNumPerPage = lineNumPerPage;
		}
	
	//action（news）：从数据库查询数据并返回
	@Override
	public String newsquery(){
		System.out.println("已经拦截到请求并进行处理");
		//判读是否为第一次登录，也可以使用servlet的过滤器做数据的检查和默认初始化
		if (pageBean.getCurrentPage() == null || 
				"" == pageBean.getCurrentPage() ||
				Integer.parseInt(pageBean.getCurrentPage()) <1) {
			log.debug("用户当前为首次登陆");
			pageBean.setCurrentPage("1");
		}
		//判读是否为默认的每页显示的行数，也可以使用servlet的过滤器做数据的检查和默认初始化
		if (pageBean.getLineNumPerPage() == null || "" == pageBean.getLineNumPerPage()) {
			pageBean.setLineNumPerPage(LINENUNPERPAGE);
		}
		//查询总行数
		String totleNum = newsDao.getTotleNum(pageBean);
		log.debug("当前从数据库中查询到的news总行数为："+totleNum+"行");
		//类型转换并判断是否整除，设置总行数到pagebean中
		int tmp_totlenum = (Integer.parseInt(totleNum)/(Integer.parseInt(pageBean.getLineNumPerPage().toString())));
		if ((Integer.parseInt(totleNum)%(Integer.parseInt(pageBean.getLineNumPerPage().toString()))) == 0) {
			pageBean.setTotlePage(""+tmp_totlenum);
		}else {
			pageBean.setTotlePage(""+(tmp_totlenum+1));
		}
		//查询一页数据
		newsDao.getOnePage(pageBean);
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		return this.newsquery();
	}
	
}
