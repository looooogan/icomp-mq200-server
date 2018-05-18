package com.icomp.common.service.icomp.v01b08.s004;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Toolalarmparam;


/**
 * 告警配置需求配置Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S004Service {

	/**
	 * 取得告警配置需求列表
	 * @param param 页面检索条件
	 */
	public Map<String,Object> getList(Toolalarmparam entity);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue, String customerID, int i);
	/**
	 * 新建告警参数配置
	 * @param langValue 
	 * @param param 页面检索条件
	 * @param langValue 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolAlarmAdd(List<Toolalarmparam> language, String langCode,String customerID, String langValue);
	/**
	 * 取得待处理告警配置
	 * @param param 页面检索条件
	 * @param langValue 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getToolAlarmInfo(Toolalarmparam entity);
	/**
	 * 修改告警配置
	 * @param langValue 
	 * @param param 页面检索条件
	 * @param langValue 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolAlarmAddOrEdit(List<Toolalarmparam> toolalarmparamList, String langCode,
			String customerID, String langValue);

	
}