package com.icomp.v01b08.b08s011.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vlibrarycode;


public interface B08S011Business {
	
	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得库房货架配置列表
	 * @param param 页面检索条件
	 * @param langCode 语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 删除库房货架配置
	 * @param param 页面检索条件
	 * @param langValue	 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 新建库房货架配置
	 * @param param 页面检索条件
	 * @param langValue	 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 取得待处理工序配置信息
	 * @param param 页面检索条件
	 * @param langValue	 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackInfo(Map<String, Object> param,
			String langCode,String langValue)throws BusinessException;
	
	/**
	 * 编辑工序配置信息
	 * @param param 页面检索条件
	 * @param langValue	 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackEdit(Map<String, Object> param,
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
	
	/**
	 * 取得库位码
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
 
	
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue);
	
	
	



}
