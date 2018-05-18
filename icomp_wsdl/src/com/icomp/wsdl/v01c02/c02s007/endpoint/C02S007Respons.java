package com.icomp.wsdl.v01c02.c02s007.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Languagetable;

public class C02S007Respons  extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2161366326580673946L;
	
	private List<Languagetable> list;

	public List<Languagetable> getList() {
		return list;
	}

	public void setList(List<Languagetable> list) {
		this.list = list;
	} 

}
