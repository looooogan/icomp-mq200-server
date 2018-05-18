package com.icomp.v01b07.b07s006.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 工作记录查询BUSINESS接口
 * @ClassName: B07S006Business 
 * @author Licc
 * @date 2014-9-25 下午04:45:46
 */
public interface B07S006Business {
	/**
	 * 工作记录列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String customerID,String langCode , String langValue) throws BusinessException;
	
}
