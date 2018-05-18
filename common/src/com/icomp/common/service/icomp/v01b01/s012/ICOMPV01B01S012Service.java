package com.icomp.common.service.icomp.v01b01.s012;

import com.icomp.entity.base.Business;
import com.icomp.entity.base.Vauthorization;
import com.icomp.entity.base.Vinventoryalarm;

import java.util.List;
import java.util.Map;


/**
 * 授权查询SERVICE接口
 * @ClassName: ICOMPV01B01S012Service 
 * @author Taoyy
 * @date 2014-8-14 下午04:17:50
 */
public interface ICOMPV01B01S012Service {

	/**
	 * 授权查询
	 */
	public Map<String, Object> getInventoryCountList(Vinventoryalarm entity);

	public Map<String,Object> getInventoryCountLists(Vauthorization entity);
	List<Business> getBusiness();

	String getNumber();
}
