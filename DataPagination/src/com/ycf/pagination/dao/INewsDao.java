package com.ycf.pagination.dao;

import com.ycf.pagination.NewsBean;

/**
	 * 
	 * ���ݷ��ʲ�ӿ����
	 * @author 14325
	 *
	 */
public interface INewsDao {
	//��ȡһҳ����
	public void getOnePage(com.ycf.pagination.PageBean<NewsBean> td);
	//��ȡ����
	public int getTotleNum(com.ycf.pagination.PageBean<NewsBean> td);
}
