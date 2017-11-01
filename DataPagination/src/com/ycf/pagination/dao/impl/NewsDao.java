package com.ycf.pagination.dao.impl;

import java.sql.SQLException;
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
	//��ȡC3P0���ӳ�����Դ
	private ComboPooledDataSource ds = new ComboPooledDataSource();
	//�ӿڷ���ʵ�֣���ȡָ��ҳ�����ݿ�����
	@Override
	public void getOnePage(PageBean<NewsBean> td) {
		//��ȡDButil��QueryRunner����
		org.apache.commons.dbutils.QueryRunner qr = new org.apache.commons.dbutils.QueryRunner(ds);
		//����sql�ַ���
		String sql = "select * from news limit ?,?";
		try {
			//��ѯһҳ���ݲ����õ�PageBean��
			td.setNewsDatas(qr.query(sql, 
										//����BeanListHandler
										new org.apache.commons.dbutils.handlers.BeanListHandler<NewsBean>(NewsBean.class),
										//����sql�ַ�������
										td.getCurrentPage(),
										td.getLineNumPerPage()
									)
							);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ӿڷ���ʵ�֣���ȡ�б�����Ŀ�������õ�PageBean��
	@Override
	public int getTotleNum(com.ycf.pagination.PageBean<NewsBean> td) {
		org.apache.commons.dbutils.QueryRunner qr = new org.apache.commons.dbutils.QueryRunner(ds);
		Long totleNum = (long) 0;
		//����sql�ַ���
		String sql = "select count(*) from news";
		try {
			//��ѯ�б�����Ŀ�����õ�PageBean��
			totleNum = qr.query(sql, 
							//����BeanListHandler
							new org.apache.commons.dbutils.handlers.ScalarHandler<Long>()
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		td.setWholeNums(totleNum.intValue());
		return totleNum.intValue();
	}

}
