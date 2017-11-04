package com.ycf.pagination;

import java.util.Date;

/**
 * 新闻信息对象的封装
 * @author 14325
 *
 */

public class NewsBean {
	//新闻标题
	public String newsTitle;
	//新闻描述
	public String newsDescription;
	//新闻生成时间
	public Date newsDate;
	//指向新闻的链接
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