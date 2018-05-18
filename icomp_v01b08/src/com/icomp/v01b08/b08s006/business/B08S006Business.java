package com.icomp.v01b08.b08s006.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

public interface B08S006Business {

	/**
	 * 取得系统区分列表
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException;

	/**
	 * 取得手持机配置列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 删除手持机配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 * @param customerID
	 * @param langCode
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException;

	/**
	 * 新建手持机配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @param customerID
	 *            用户ID
	 * @param lang
	 *            语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException;

	/**
	 * 取得待处理手持机信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 编辑手持机信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @param customerID
	 *            用户ID
	 * @param lang
	 *            语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException;
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
	 * 取得页面部门列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Object getVdepartment(String dELFLAG, String langCode,
			String langValue);
	
	
	
}
