package com.icomp.v01b07.b07s002.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 库存异常报警BUSINESS接口
 * @ClassName: B07S002Business 
 * @author Licc
 * @date 2014-8-20 下午02:01:40
 */
public interface B07S002Business {
	/**
	 * 库存异常报警列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException;

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

	String getNumber()throws BusinessException;
}
