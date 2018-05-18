package com.icomp.wsdl.v01c00.c00s000.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Vgrantlist;

public class MenuRespons extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314619790374655184L;

	/* 数据行数 */
	private int total;
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	/* 用户权限列表 */
	private List<Vgrantlist> vgrantlist;

	public List<Vgrantlist> getVgrantlist() {
		return vgrantlist;
	}

	public void setVgrantlist(List<Vgrantlist> vgrantlist) {
		this.vgrantlist = vgrantlist;
	}
}
