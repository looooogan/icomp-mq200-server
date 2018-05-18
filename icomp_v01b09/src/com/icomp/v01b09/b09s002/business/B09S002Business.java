package com.icomp.v01b09.b09s002.business;

import java.io.File;
import java.util.Map;

import com.icomp.common.exception.BusinessException;

public interface B09S002Business {

	/**
	 * 取得合成刀具列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 取得系统区分列表
	 * 
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Object getComList(String dELFLAG, String langCode, String langValue)
			throws BusinessException;

	/**
	 * 新建合成刀具信息
	 * 
	 * @param param
	 * @param langValue
	 * @param lang2
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisAdd(Map<String, Object> param,
			String savePath, String uploadFileName, File upload,
			String langCode, String customerID, String langValue);

	/**
	 * 删除合成刀具信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisDelete(Map<String, Object> param,
			String langCode, String userID, String langValue)
			throws BusinessException;

	/**
	 * 编辑合成刀具信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisEdit(Map<String, Object> param,
			String savePath, String uploadFileName, File upload,
			String customerID, String langCode, String langValue)
			throws BusinessException;

	/**
	 * 根据id获取合成刀具信息
	 * 
	 * @param param
	 * @param langValue
	 * @param langValue2
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 获取设备名称信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Object getEquipmentNameList(String dELFLAG, String langCode,
			String langValue) throws BusinessException;

	/**
	 * 获取零部件
	 * 
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Object getPartsNameList(String dELFLAG, String langCode,
			String langValue) throws BusinessException;

	/**
	 * 根据id获取合成刀具位置信息
	 * 
	 * @param param
	 * @param langValue
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Object synthesisLocationInfo(Map<String, Object> param,
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
			String departmentID, String langCode, String langValue)
			throws BusinessException;

}
