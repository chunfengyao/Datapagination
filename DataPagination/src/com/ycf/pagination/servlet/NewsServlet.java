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
 * ���Ʋ㿪�����������󲢴���
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
		//��ȡlineNumPerPage��currentpage��ֵ���Կ�ֵ���д���
  		String lineNumPerPage = request.getParameter("lineNumPerPage");
		String currentpage = request.getParameter("currentpage");
		String url;
		if (currentpage == "" || currentpage == null) {
			currentpage = "1";
		}
		if (lineNumPerPage == "" || lineNumPerPage == null) {
			lineNumPerPage = "4";
		}
		//����pagebean����
		PageBean<NewsBean> pageBean  = new PageBean<NewsBean>();
		//����pagebean��currentpage��ֵ
		pageBean.setCurrentPage(currentpage);
		//����pagebean��lineNumPerPage��ֵ
		pageBean.setLineNumPerPage(lineNumPerPage);
		//����services����
		NewsServices newsServices = new NewsServices();
		//����serviceȥ��ѯ����
		newsServices.getOnePageNews(pageBean);
		//��pagebean������õ���������
		request.setAttribute("Pagebean", pageBean);
		//���ý�Ҫ��ת��ҳ���ַ
		url = "/WEB-INF/newslist.jsp";
		//��ת������ҳ��
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
