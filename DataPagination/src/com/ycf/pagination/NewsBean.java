package com.ycf.pagination;

import java.util.Date;

/**
 * ������Ϣ����ķ�װ
 * @author 14325
 *
 */

public class NewsBean {
	//���ű���
	public String newsTitle;
	//��������
	public String newsDescription;
	//��������ʱ��
	public Date newsDate;
	//ָ�����ŵ�����
	public String newsURL;
	
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsDescription() {
		return newsDescription;
	}
	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(java.util.Date newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsURL() {
		return newsURL;
	}
	public void setNewsURL(String newsURL) {
		this.newsURL = newsURL;
	}
}