package com.icomp.v01b01.b01s012.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 库存异常报警 BUSINESS接口
 * @ClassName: B01S012Business 
 * @author Taoyy
 * @date 2014-8-14 下午04:06:48
 */
public interface B01S012Business {
	/**
	 * 库存异常报警 列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int checkType)throws BusinessException;

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

	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;

	String getNumber() throws BusinessException;
}
