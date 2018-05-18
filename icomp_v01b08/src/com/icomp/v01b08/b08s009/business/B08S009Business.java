package com.icomp.v01b08.b08s009.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;


public interface B08S009Business {

	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得零部件配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;

	/**
	 * 删除零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 新建零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 取得待处理零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsInfo(Map<String, Object> param,
			String langCode,String langValue)throws BusinessException;
	
	/**
	 * 编辑零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsEdit(Map<String, Object> param,
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
