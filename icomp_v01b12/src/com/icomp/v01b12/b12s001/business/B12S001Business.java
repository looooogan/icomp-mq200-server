package com.icomp.v01b12.b12s001.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflow;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vbusiness;

public interface B12S001Business {

	/**
	 * 取得系统区分列表
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException;

	/**
	 * 业务流程管理列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode,
			String langValue) throws BusinessException;

	/**
	 * 取得流程名列表
	 * 
	 * @param param
	 *            删除区分
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Businessflow> getBusinessFlowList(String param,
			String langCode, String langValue) throws BusinessException;



	/**
	 * 取得业务名列表
	 * 
	 * @param param
	 *            删除区分
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Business> getBusinessList(String dELFLAG_0, String langCode,
			String langValue)throws BusinessException;

	/**
	 * 新建业务-流程中间表
	 * 
	 * @param param
	 *            删除区分
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vbusiness> getBusinessFlowList(Map<String, Object> param,
			String langCode, String langValue)throws BusinessException;

	/**
	 * 删除流程
	 * 
	 * @param param
	 *            删除区分
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> businessDelete(Map<String, Object> param,
			String userID, String langValue, String lang)throws BusinessException;

	/**
	 * 根据id取得流程
	 * 
	 * @param param 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> businessInfo(Map<String, Object> param,
			String langValue, String lang)throws BusinessException;

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
	 * 取得功能名列表
	 * 
	 * @param param 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Capability> getCapabilityList(String dELFLAG_0, String langCode,
			String langValue)throws BusinessException;

	/**
	 * 新建流程
	 * 
	 * @param param
	 *            页面信息
	 * @param langValue
	 *            语言编码
	 * @param customerID
	 *            用户ID
	 * @param lang
	 *            语言值
	 * @return
	 * @throws BusinessException
	 */

	public Map<String, Object> businessAdd(Map<String, Object> param,
			String customerID, String langCode, String langValue);

	/**
	 * 编辑流程
	 * 
	 * @param param
	 *            页面信息
	 * @param langValue
	 *            语言编码
	 * @param customerID
	 *            用户ID
	 * @param lang
	 *            语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> businessEdit(Map<String, Object> param,
			String customerID, String langCode, String langValue);
}
