package com.icomp.common.service.icomp.v01b06.s010;

import java.util.Map;

import com.icomp.entity.base.Vtooldiscarde;


/**
 * 刀具报废SERVICES接口
 * @ClassName: ICOMPV01B06S010Service 
 * @author Taoyy
 * @date 2014-8-22 上午10:27:15
 */

public interface ICOMPV01B06S010Service {
	/**
	 * 刀具报废
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vtooldiscarde entity);
	
	/**
	 * 报废刀具确认
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> b06s010Save(String toolCode,String discardeTime,String langCode, String langValue);
}
