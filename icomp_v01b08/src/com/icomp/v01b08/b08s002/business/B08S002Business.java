package com.icomp.v01b08.b08s002.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

import java.util.List;
import java.util.Map;

public interface B08S002Business {


	/**
	 * 取得系统区分列表
	 * @param flagType  区分定义名称
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得内置编码列表
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;

	/**
	 * 删除内置编码
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> libraryCodeDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
    /**
     * 待处理内置编码取得
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> librarycodeInfo(Map<String, Object> param,String langCode,
			String langValue)throws BusinessException;
	
    /**
     * 内置编码编辑
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> librarycodeEdit(Map<String, Object> param,
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
			String customerID,String langCode , String langValue) throws BusinessException;


	Map<String,Object> onOff(Map<String, Object> param, String customer, String langCode, String langValue)throws BusinessException;
}
