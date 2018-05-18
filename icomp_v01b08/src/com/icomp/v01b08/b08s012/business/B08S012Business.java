package com.icomp.v01b08.b08s012.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;


public interface B08S012Business {	

	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode, String langValue)throws BusinessException;
	
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
	 * 取得零部件信息列表
	 * @param param 页面检索条件
	 * @param langCode 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException;
	
	/**
	 * 取得待编辑的零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineInfo(Map<String,Object> param,String langCode, String langValue)throws BusinessException;
	
	/**
	 * 删除零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineDelete(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException;
	public Map<String,Object> partsDelete(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException;
	/**
	 * 新建零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineAdd(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException;
	
	/**
	 * 编辑零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineEdit(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException;

	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;
}
