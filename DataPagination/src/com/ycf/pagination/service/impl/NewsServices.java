package com.ycf.pagination.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.Action;
import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.dao.impl.NewsDao;
import com.ycf.pagination.service.INewsService;

public class NewsServices implements INewsService,Action{
	//��ȡlog4j����־����
	Log log = LogFactory.getLog(NewsServices.class);
	//ȫ��Ĭ�ϵ�ÿҳ��ʾ����
	private static String LINENUNPERPAGE = "4";
	//������������ý���struts��װ������
	private NewsDao newsDao;
	//������������ý���struts��װ������
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
	
	//���ñ����Խ��շ�ҳ�ĳ����Ӵ��ݵ�����
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
	
	//action��news���������ݿ��ѯ���ݲ�����
	@Override
	public String newsquery(){
		System.out.println("�Ѿ����ص����󲢽��д���");
		//�ж��Ƿ�Ϊ��һ�ε�¼��Ҳ����ʹ��servlet�Ĺ����������ݵļ���Ĭ�ϳ�ʼ��
		if (pageBean.getCurrentPage() == null || 
				"" == pageBean.getCurrentPage() ||
				Integer.parseInt(pageBean.getCurrentPage()) <1) {
			log.debug("�û���ǰΪ�״ε�½");
			pageBean.setCurrentPage("1");
		}
		//�ж��Ƿ�ΪĬ�ϵ�ÿҳ��ʾ��������Ҳ����ʹ��servlet�Ĺ����������ݵļ���Ĭ�ϳ�ʼ��
		if (pageBean.getLineNumPerPage() == null || "" == pageBean.getLineNumPerPage()) {
			pageBean.setLineNumPerPage(LINENUNPERPAGE);
		}
		//��ѯ������
		String totleNum = newsDao.getTotleNum(pageBean);
		log.debug("��ǰ�����ݿ��в�ѯ����news������Ϊ��"+totleNum+"��");
		//����ת�����ж��Ƿ�������������������pagebean��
		int tmp_totlenum = (Integer.parseInt(totleNum)/(Integer.parseInt(pageBean.getLineNumPerPage().toString())));
		if ((Integer.parseInt(totleNum)%(Integer.parseInt(pageBean.getLineNumPerPage().toString()))) == 0) {
			pageBean.setTotlePage(""+tmp_totlenum);
		}else {
			pageBean.setTotlePage(""+(tmp_totlenum+1));
		}
		//��ѯһҳ����
		newsDao.getOnePage(pageBean);
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		return this.newsquery();
	}
	
}
