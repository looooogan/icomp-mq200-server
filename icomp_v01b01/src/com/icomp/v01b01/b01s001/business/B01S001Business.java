package com.icomp.v01b01.b01s001.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 入库信息查询BUsiness接口
 * @ClassName: B01S001Business 
 * @author Taoyy
 * @date 2014-8-12 下午04:09:08
 */
public interface B01S001Business {
	/**
	 * 入库信息查询列表
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


	String getnumber()throws BusinessException;
}
