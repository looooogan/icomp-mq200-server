package com.icomp.v01b03.b03s004.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 刃磨工作量汇总BUSINESS接口
 * @ClassName: B01S004Business 
 * @author Taoyy
 * @date 2014-8-13 上午10:34:59
 */
public interface B03S004Business {
	/**
	 * 刃磨工作量汇总列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException;


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

	
}
