package com.icomp.v01b08.b08s003.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

public interface B08S003Business {

	/**
	 * 取得系统区分列表
	 * @param flagType  区分定义名称
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得国际化需求列表
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 删除国际化需求信息
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageTableDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 新建国际化需求信息
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;

    /**
     * 待处理国际化需求取得
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> languageInfo(Map<String, Object> param,String langCode,
			String langValue)throws BusinessException;
	
	/**
	 * 编辑国际化需求信息
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 启用国际化需求信息
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageStartUse(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID     页面ID
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String customerID,String langCode,String langValue) throws BusinessException;
	
	
	
}
