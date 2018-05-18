package com.icomp.common.service.icomp.v01b09.s003;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vdisplayeditemconfiguration;


public interface ICOMPV01B09S003Service {
	
	public Map<String, Object> getList(Toolwholelifecycle entity);
	/**
	 * 新建编辑的验证
	 * @param param      页面查询条件
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue,String userID, int i);
	
	/**
	 * 保存打印项目信息
	 * @param entity 
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> printItemAdd(Displayeditemconfiguration entity,
			String langCode, String langValue);
	/**
	 * 删除打印项目信息
	 * @param entity 
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printEditDelete(
			Displayeditemconfiguration entity, String langCode, String langValue);
	/**
	 * 编辑打印项目信息
	 * @param entity 
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printEdit(Displayeditemconfiguration entity,
			String langCode, String langValue);
	/**
	 * 项目信息管理
	 * @param entity 页面查询条件
	 * @return 项目信息信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getprintItemInfo(Displayeditemconfiguration entity);
	

}
