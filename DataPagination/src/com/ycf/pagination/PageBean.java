package com.ycf.pagination;

/**
 * ��ͼ������ƶ˴��ݵ����ݶ���ķ�װ
 * @author 14325
 *
 */
public class PageBean<T> {
	//��ǰ���������б�ҳ����
	public int currentPage;
	//������
	public int wholeNums;
	//�б�ÿҳ��ʾ������
	public int lineNumPerPage;
	//����˲�ѯ�����صĽ����
	public java.util.List<T> newsDatas;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLineNumPerPage() {
		return lineNumPerPage;
	}
	public void setLineNumPerPage(int lineNumPerPage) {
		this.lineNumPerPage = lineNumPerPage;
	}
	public int getWholeNums() {
		return wholeNums;
	}
	public void setWholeNums(int wholeNums) {
		this.wholeNums = wholeNums;
	}
	public java.util.List<T> getNewsDatas() {
		return newsDatas;
	}
	public void setNewsDatas(java.util.List<T> newsDatas) {
		this.newsDatas = newsDatas;
	}
	
	
}
