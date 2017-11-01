package com.ycf.pagination.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.service.impl.NewsServices;

/**
 * 控制层开发，接受请求并处理
 * @author 14325
 *
 */
public class NewsServlet extends HttpServlet {
//	public IndexServlet() {
//		super();
//	}
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		//读取lineNumPerPage、currentpage数值并对空值进行处理
  		String lineNumPerPage = request.getParameter("lineNumPerPage");
		String currentpage = request.getParameter("currentpage");
		String url;
		if (currentpage == "" || currentpage == null) {
			currentpage = "1";
		}
		if (lineNumPerPage == "" || lineNumPerPage == null) {
			lineNumPerPage = "4";
		}
		//创建pagebean对象
		PageBean<NewsBean> pageBean  = new PageBean<NewsBean>();
		//设置pagebean中currentpage的值
		pageBean.setCurrentPage(currentpage);
		//设置pagebean中lineNumPerPage的值
		pageBean.setLineNumPerPage(lineNumPerPage);
		//创建services对象
		NewsServices newsServices = new NewsServices();
		//调用service去查询数据
		newsServices.getOnePageNews(pageBean);
		//把pagebean对象放置到请求域中
		request.setAttribute("Pagebean", pageBean);
		//设置将要跳转的页面地址
		url = "/WEB-INF/newslist.jsp";
		//跳转到新闻页面
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			url = "/WEB-INF/error.jsp";
			try {
				request.getRequestDispatcher(url).forward(request, response);
			} catch (ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
