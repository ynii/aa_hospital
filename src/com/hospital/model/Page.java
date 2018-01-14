package com.hospital.model;

import java.util.List;

public class Page<T> {
	
	private Integer currentPage = 1;//��ǰҳ
	private Integer offSet ; //ƫ����
	private Integer pageSize = 5; // ÿҳ��ʾ����
	private List<T> datas ; //��ǰҳ��ʾ������
	private Long totalcount ; //������
	private Integer totalPages ; //��ҳ��
	private Integer previousPage ; //��һҳ
	private Integer nextPage ; //��һҳ
	private Integer startPage ; //��ʼҳ��
	private Integer endPage ; //����ҳ��
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getOffSet() {
		offSet = (currentPage-1)*pageSize ;
		return offSet;
	}
	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}
	public Integer getTotalPages() {
		totalPages = (int) Math.ceil(getTotalcount()*1.0/getPageSize()) ;
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	//��ȡ��һҳ
	public Integer getPreviousPage() {
		if(getCurrentPage()>1){
			previousPage = currentPage-1;
		}else{
			previousPage = 1;
		}
		return previousPage;
	}
	
	//��ȡ��һҳ
	public Integer getNextPage() {
		if(getCurrentPage()==getTotalPages()){
			nextPage = getCurrentPage();
		}else{
			nextPage = getCurrentPage()+1;
		}
		return nextPage;
	}
	
	
	//���㿪ʼҳ
	public Integer getStartPage() {
		if(getCurrentPage()>=1&&getCurrentPage()<=5){
			startPage = 1;
		}else if(getCurrentPage()+4>=getTotalPages()&&getCurrentPage()<=getTotalPages()){
			startPage = getTotalPages()-4;
		}else{
			startPage = getCurrentPage()-2;
		}
		return startPage;
	}
	
	//�������ҳ
	public Integer getEndPage() {
		if(getCurrentPage()>=1&&getCurrentPage()<=5){
			if(getTotalPages()>5){
				endPage = 5;
			}else{
				endPage = getTotalPages();
			}
		}else if(getCurrentPage()+4>=getTotalPages()&&getCurrentPage()<=getTotalPages()){
			endPage = getTotalPages();
		}else{
			endPage = getCurrentPage()+2;
		}
		return endPage;
	}
	
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	
	//�ж��Ƿ�����һҳ
	public boolean hasPreviousPage(){
		if(getCurrentPage()>1){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
