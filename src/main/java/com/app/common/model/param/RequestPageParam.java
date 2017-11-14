package com.app.common.model.param;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
* @ClassName: RequestPageParam
* @Description: 通用请求分页参数 子类可以继承它
* @author  luanhy
* @date 2017年7月7日 下午4:22:42
* @Copyright: Copyright (c) 2017 wisedu
 */
@ApiModel(value="分页请求参数",description="分页请求参数")
public class RequestPageParam implements Serializable{
	
	/**
	* @Fields serialVersionUID 
	*/
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "每页长度", required = false)
	@Min(1)
	@Digits (integer=100,fraction= 0 ) 
	private Integer rows;
	
	@ApiModelProperty(value = "页码", required = false)
	@Min(1)
	@Digits (integer=100,fraction= 0 ) 
	private Integer page;

	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	
}
