package com.icomp.v01b10.b10s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.v01b10.b10s001.business.B10S001Business;

/**
 * 入库信息查询Action
 * @ClassName: B01S001Action 
 * @author Taoyy
 * @date 2014-8-12 下午02:31:34
 */
public class B10S001Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 入库信息查询BUSINESS
	 */
	@SuppressWarnings("unused")
	private B10S001Business b03s001Business;
	public void setB03s001Business(B10S001Business b03s001Business) {
		this.b03s001Business = b03s001Business;
	}


	/**
	 * 初始化入库信息查询页面
	 * @title initb01S001 
	 * @return
	 * String
	 */
	public String initb10S001(){
		return SUCCESS;
	}
	
}
