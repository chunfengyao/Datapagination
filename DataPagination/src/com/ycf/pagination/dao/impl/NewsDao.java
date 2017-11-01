package com.ycf.pagination.dao.impl;

import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ycf.pagination.NewsBean;
import com.ycf.pagination.PageBean;
import com.ycf.pagination.dao.INewsDao;
	/**
	 * 数据访问层接口实现
	 * @author 14325
	 *
	 */
public class NewsDao implements INewsDao {
	//获取C3P0连接池数据源
	private ComboPooledDataSource ds = new ComboPooledDataSource();
	//接口方法实现，获取指定页的数据库数据
	@Override
	public void getOnePage(PageBean<NewsBean> td) {
		//获取DButil的QueryRunner对象
		org.apache.commons.dbutils.QueryRunner qr = new org.apache.commons.dbutils.QueryRunner(ds);
		//构造sql字符串
		String sql = "select * from news limit ?,?";
		try {
			//查询一页数据并设置到PageBean中
			td.setNewsDatas(qr.query(sql, 
										//创建BeanListHandler
										new org.apache.commons.dbutils.handlers.BeanListHandler<NewsBean>(NewsBean.class),
										//设置sql字符串参数
										td.getCurrentPage(),
										td.getLineNumPerPage()
									)
							);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//接口方法实现，获取列表总数目，并设置到PageBean中
	@Override
	public int getTotleNum(com.ycf.pagination.PageBean<NewsBean> td) {
		org.apache.commons.dbutils.QueryRunner qr = new org.apache.commons.dbutils.QueryRunner(ds);
		Long totleNum = (long) 0;
		//构造sql字符串
		String sql = "select count(*) from news";
		try {
			//查询列表总数目并设置到PageBean中
			totleNum = qr.query(sql, 
							//创建BeanListHandler
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
