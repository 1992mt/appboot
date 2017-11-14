package com.app.common.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: Pagation
 * @Description: 分页列表
 * @author luanhy
 * @param <T>
 * @date 2017年7月7日 下午5:00:16
 * @Copyright: Copyright (c) 2017 wisedu
 */
@ApiModel(value="Pagation（分页列表）")
public class Pagation<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
    //总记录数
	@ApiModelProperty(value = "总记录数" , required = true)
    private long total;
    //总页数
	@ApiModelProperty(value = "总页数" , required = true)
    private int pages;
	
	private List<T> list;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Pagation [total=" + total + ", pages=" + pages + ", list=" + list + "]";
	}
    
}
