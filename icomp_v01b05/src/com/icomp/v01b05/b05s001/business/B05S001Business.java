package com.icomp.v01b05.b05s001.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 待质检刀具查询BUsiness接口
 * 
 * @ClassName: B05S001Business
 * @author Licc
 * @date 2014-8-20 下午04:09:08
 */
public interface B05S001Business {
	/**
	 * 待质检刀具查询
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode,
			String langValue) throws BusinessException;
	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String departmentID,String langCode , String langValue) throws BusinessException;
	
	/**
	 * 编辑待质检刀具信息
	 * 
	 * @return
	 */
	public Map<String, Object> deliveryplanEdit(Map<String, Object> param,
			String langValue, String str, String langCode) throws BusinessException;
	
	/**
	 * 取得当前待质检刀具信息
	 * 
	 * @return
	 */	
	public Map<String, Object> deliveryplanInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;
}
