package com.icomp.common.service.icomp.v01c02.s007;

import java.util.List;

import com.icomp.entity.base.Languagetable;

public interface ICOMPV01C02S007Service {
	/**
	 * 获取系统支持的语言列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Languagetable> getLangageList(Languagetable entity); 
}
