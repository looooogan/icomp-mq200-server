package com.icomp.common.service.icomp.v01b01.s004;

import com.icomp.entity.base.Vredemptionapplied;

import java.util.Map;

/**
 * 换领申请信息查询SERVICES接口
 * @ClassName: ICOMPV01B01S004Service 
 * @author Taoyy
 * @date 2014-8-13 下午12:00:18
 */
public interface ICOMPV01B01S004Service {
	/**
	 *  换领申请信息王列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vredemptionapplied entity);

	Map<String, Object> getprintItemInfo(Vredemptionapplied entity);


	String getVreNumber();
}
