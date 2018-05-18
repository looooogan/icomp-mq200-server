package com.icomp.common.service.icomp.v01c01.s023;

import java.util.List;

import com.icomp.entity.base.Vquerytoollist;

public interface ICOMPV01C01S023Service {
	
	/**
	 * 刀具信息快速查询
	 * @title getToolInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S023Respons
	 */
	public List<Vquerytoollist>  getToolInfo(Vquerytoollist entity);
}
