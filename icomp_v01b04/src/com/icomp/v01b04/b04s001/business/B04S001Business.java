package com.icomp.v01b04.b04s001.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 工作量查询BUSINESSBUsiness接口
 * @ClassName: B01S001Business 
 * @author Taoyy
 * @date 2014-8-20 下午04:09:08
 */
public interface B04S001Business {
	/**
	 * 工作量查询BUSINESS
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
		Map<String, Object> getList(Map<String, Object> param,  String langCode, String langValue)throws BusinessException;
	/**
	 * 流水线查询list
	 * @title getList 
	 * @param langCode
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	 Map<String, Object> getAssemblyLineList(String langCode, String langValue);

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	 Map<String, Object> getGridColmun(String pageID,
			String departmentID,String langCode , String langValue) throws BusinessException;
	/** 
	
	* @Title: getProcessNameList 
	
	* @Description:
	
	* @param @param langCode
	* @param @param langValue
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型
	* @throws 
	
	*/ 
	
	Map<String, Object> getProcessNameList(String langCode, String langValue);

	
}
