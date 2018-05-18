package com.icomp.v01b03.b03s005.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 刃磨信息快速查询BUSINESS接口
 * @ClassName: B01S005Business 
 * @author Taoyy
 * @date 2014-8-13 下午04:45:46
 */
public interface B03S005Business {
	/**
	 * 刃磨信息快速查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException;


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
