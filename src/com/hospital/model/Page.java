package com.hospital.model;

import java.util.List;

public class Page<T> {
	
	private Integer currentPage = 1;//当前页
	private Integer offSet ; //偏移量
	private Integer pageSize = 5; // 每页显示数量
	private List<T> datas ; //当前页显示的数据
	private Long totalcount ; //总条数
	private Integer totalPages ; //总页数
	private Integer previousPage ; //上一页
	private Integer nextPage ; //下一页
	private Integer startPage ; //开始页码
	private Integer endPage ; //结束页码
	
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
	
	//获取上一页
	public Integer getPreviousPage() {
		if(getCurrentPage()>1){
			previousPage = currentPage-1;
		}else{
			previousPage = 1;
		}
		return previousPage;
	}
	
	//获取下一页
	public Integer getNextPage() {
		if(getCurrentPage()==getTotalPages()){
			nextPage = getCurrentPage();
		}else{
			nextPage = getCurrentPage()+1;
		}
		return nextPage;
	}
	
	
	//计算开始页
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
	
	//计算结束页
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
	
	//判断是否右下一页
	public boolean hasPreviousPage(){
		if(getCurrentPage()>1){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
