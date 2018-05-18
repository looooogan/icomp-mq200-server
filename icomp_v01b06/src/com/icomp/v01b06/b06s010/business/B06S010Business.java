package com.icomp.v01b06.b06s010.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

/**
 * 刀具报废BUSINESS接口
 * 
 * @ClassName: B06S009Business
 * @author Taoyy
 * @date 2014-8-22 上午10:25:37
 */

public interface B06S010Business {
	/**
	 * 刀具报废列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;
	
	/**
	 * 刀具报废列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> b06s010Save(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, String customerID,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 取得系统区分列表
	 * 
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException;
}
