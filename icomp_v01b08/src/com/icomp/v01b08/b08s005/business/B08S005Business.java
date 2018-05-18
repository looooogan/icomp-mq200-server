package com.icomp.v01b08.b08s005.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;


public interface B08S005Business {

	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得系统码表配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;

	/**
	 * 删除系统码表配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> comlistDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 新建系统码表配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> comlistAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;

	public Map<String, Object> comlistInfo(Map<String, Object> param,
			String langCode,String langValue)throws BusinessException;

	public Map<String, Object> comlistEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
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
