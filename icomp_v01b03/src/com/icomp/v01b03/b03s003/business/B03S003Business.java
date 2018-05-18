package com.icomp.v01b03.b03s003.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 库房待修复刀具查询BUSINESS接口
 * @ClassName: B03S003Business 
 * @author Taoyy
 * @date 2014-8-20 下午04:04:47
 */
public interface B03S003Business {
	/**
	 * 库房待修复刀具查询
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue,int checkType)throws BusinessException;


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
