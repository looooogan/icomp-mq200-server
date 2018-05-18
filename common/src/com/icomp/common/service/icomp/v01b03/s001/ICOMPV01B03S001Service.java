package com.icomp.common.service.icomp.v01b03.s001;

import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vgrindingrecord;
import com.icomp.entity.base.Vtoolnoticehistory;

import java.util.List;
import java.util.Map;

/**
 * 刃磨记录查询SERVICE接口
 * @ClassName: ICOMPV01B03S001Service 
 * @author Taoyy
 * @date 2014-8-20 下午03:31:52
 */
public interface ICOMPV01B03S001Service {

	/**
	 * 刃磨记录查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vgrindingrecord entity);

	public Map<String,Object> getListtool(Vtoolnoticehistory entity);

	String getNumber();

	List<Userdetail> getUsner(Userdetail user);
}
