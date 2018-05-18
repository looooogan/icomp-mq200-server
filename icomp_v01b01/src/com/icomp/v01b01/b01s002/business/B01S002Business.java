package com.icomp.v01b01.b01s002.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 出库信息查询BUSINESS接口
 * @ClassName: B01S002Business 
 * @author Taoyy
 * @date 2014-8-14 下午02:01:40
 */
public interface B01S002Business {
	/**
	 * 出库信息列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode,  String langValue,int checkType)throws BusinessException;



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


	String getnumber() throws  BusinessException;
}
