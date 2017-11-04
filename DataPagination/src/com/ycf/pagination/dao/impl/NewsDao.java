package com.ycf.pagination.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.dao.INewsDao;
	/**
	 * ���ݷ��ʲ�ӿ�ʵ��
	 * @author 14325
	 *
	 */
public class NewsDao implements INewsDao {
	//��ȡ����Դ
	ComboPooledDataSource ds = new ComboPooledDataSource();
	//�ӿڷ���ʵ�֣���ȡָ��ҳ�����ݿ�����
	@Override
	public void getOnePage(PageBean<NewsBean> td) {
		//��ȡDButil��QueryRunner����
		QueryRunner qr = new QueryRunner(ds);
		//����sql�ַ���
		String sql = "select * from news limit ?,?";
		try {
			//��ѯһҳ���ݲ����õ�PageBean�� 
			//����BeanListHandler
			//����sql�ַ�������
			td.setResaultSet(qr.query(sql,new BeanListHandler<NewsBean>(NewsBean.class),
										((Integer.parseInt(td.getCurrentPage())-1)*Integer.parseInt(td.getLineNumPerPage())),
										Integer.parseInt(td.getLineNumPerPage())
									)
							);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ӿڷ���ʵ�֣���ȡ�б�����Ŀ��������totlePage��PageBean��
	@Override
	public int getTotleNum(PageBean<NewsBean> td) {
		QueryRunner qr = new QueryRunner(ds);
		Long totleNum = (long) 0;
		//����sql�ַ���
		String sql = "select count(*) from news";
		try {
			//��ѯ�б�����Ŀ�����õ�PageBean��
			totleNum = qr.query(sql,new ScalarHandler<Long>());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((totleNum.intValue()%(Integer.parseInt(td.getLineNumPerPage().toString()))) == 0) {
			td.setTotlePage(""+(totleNum.intValue()/(Integer.parseInt(td.getLineNumPerPage().toString()))));
		}else {
			td.setTotlePage(""+((totleNum.intValue()/(Integer.parseInt(td.getLineNumPerPage().toString())))+1));
		}
		return totleNum.intValue();
	}

}
