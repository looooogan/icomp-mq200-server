package com.icomp.v01b01.b01s004.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 换领申请信息查询BUSINESS接口
 * @ClassName: B01S004Business 
 * @author Taoyy
 * @date 2014-8-13 上午10:34:59
 */
public interface B01S004Business {
	/**
	 * 换领申请信息列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int checkType)throws BusinessException;


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

	Map<String, Object> printItemInfo(Map<String, Object> param, String langCode,String langValue)throws BusinessException;

	String getNumber()throws BusinessException;
}
