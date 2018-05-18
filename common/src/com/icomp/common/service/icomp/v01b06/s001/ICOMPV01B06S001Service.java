package com.icomp.common.service.icomp.v01b06.s001;

import com.icomp.entity.base.Business;
import com.icomp.entity.base.Vscrap;

import java.util.List;
import java.util.Map;

/**
 *  报废分析SERVICE接口
 * @ClassName: ICOMPV01B06S001Service 
 * @author Taoyy
 * @date 2014-8-22 上午09:15:04
 */

public interface ICOMPV01B06S001Service {

	/**
	 * 报废分析
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
//	public Map<String, Object> getList(Vscrapanalysis entity);
	public Map<String, Object> getList(Vscrap entity);
	/**
	 * 报废分析统计数量
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * Object
	 */
	public String getStatisticalCount(Vscrap entity);

	List<Business> getBusinessList();

	String getNumber();
//	public Map<String, Object> getLists(Vscrapanalysis entity);
}
