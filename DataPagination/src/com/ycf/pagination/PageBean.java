package com.ycf.pagination;

import java.util.List;

/**
 * ��ͼ������ƶ˴��ݵ����ݶ���ķ�װ
 * @author 14325
 *
 */
public class PageBean<T> {
	//��ǰ���������б�ҳ����
	public String currentPage;
	//������
	public String wholeNums;
	//�б�ÿҳ��ʾ������
	public String lineNumPerPage;
	//����˲�ѯ�����صĽ����
	public List<T> resaultSet;
	
	
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getWholeNums() {
		return wholeNums;
	}
	public void setWholeNums(String wholeNums) {
		this.wholeNums = wholeNums;
	}
	public String getLineNumPerPage() {
		return lineNumPerPage;
	}
	public void setLineNumPerPage(String lineNumPerPage) {
		this.lineNumPerPage = lineNumPerPage;
	}
	public java.util.List<T> getResaultSet() {
		return resaultSet;
	}
	public void setResaultSet(List<T> resaultSet) {
		this.resaultSet = resaultSet;
	}
	
	
}
