package com.icomp.common.service.icomp.v01b12.s001;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflow;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Vbusiness;

public interface ICOMPV01B12S001Service {
	/**
	 * 流程管理管理
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Vbusiness entity);

	/**
	 * 删除
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> businessDelete(Businessflowlnk business,
			String langCode, String langValue);

	/**
	 * 流程名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public List<Businessflow> getBusinessFlowList(Businessflow entity)
			throws BusinessException;

	/**
	 * 业务名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public List<Business> getBusinessList(Business entity);


	/**
	 * 业务名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public List<Vbusiness> getBusinessList(Vbusiness entity);

	/**
	 * 修改业务-流程中间表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> businessEdit(Businessflow businessflow,
			List<Businessflowlnk> businessflowlnkList, String customerID,
			String langCode, String langValue);
	/**
	 * 获取业务-流程中间表信息
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> businessInfo(Vbusiness entity);

	/**
	 * 验证业务-流程中间表信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String userId, int checkType) ;

	/**
	 * 功能名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public List<Capability> getBusinessList(Capability entity) ;

	/**
	 * 根据id获取流程
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getbusinessFlow(Businessflow entity) ;

	
	/**
	 * 新建流程信息
	 * @param checkType 0:info,1:add,2:edit
	 * @param param
	 * @param langValue
	 * @return
	 */
	
	public Map<String, Object> businessAdd(Businessflow businessflow,
			List<Businessflowlnk> businessflowlnkList, String customerID,
			String langCode, String langValue);
	/**
	 * 删除流程信息
	 */

	public Map<String, Object> businessDelete(Businessflow businessflow,
			List<Businessflowlnk> businessflowlnkList, String customerID,
			String langCode, String langValue);

	



	


}