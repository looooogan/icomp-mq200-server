package com.icomp.v01b09.b09s003.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;


public interface B09S003Business {

	/**
	 * 取得项目打印列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public Object getComList(String dELFLAG,String langCode, String langValue)throws BusinessException;
	/**
	 * 新建项目打印信息
	 * @param param
	 * @param langCode
	 * @param langValue 
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> PrintItemAdd(Map<String, Object> param,
			String langCode,String userID, String langValue)throws BusinessException;
	/**
	 * 删除项目打印信息
	 * @param param
	 * @param langCode
	 * @param langValue 
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemDelete(Map<String,Object> param,
			String langCode,String userID, String langValue)throws BusinessException;
	/**
	 * 编辑项目打印信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemEdit(Map<String, Object> param,
			String langCode, String customerID, String langValue)throws BusinessException;
	/**
	 * 根据id获取项目打印信息
	 * @param param
	 * @param langCode
	 * @param langValue 
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;
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
