package com.ycf.pagination.dao;

import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;

/**
	 * 
	 * ���ݷ��ʲ�ӿ����
	 * @author 14325
	 *
	 */
public interface INewsDao {
	//��ȡһҳ����
	public void getOnePage(PageBean<NewsBean> td);
	//��ȡ����
	public int getTotleNum(PageBean<NewsBean> td);
}
