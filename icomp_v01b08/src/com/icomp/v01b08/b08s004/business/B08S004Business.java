package com.icomp.v01b08.b08s004.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

public interface B08S004Business {

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
	 * 取得刀具告警配置列表
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	
    /**
     * 取得待处理刀具告警配置
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> toolAlarmInfo(Map<String, Object> param,String langCode,
			String langValue)throws BusinessException;
	
	/**
	 * 编辑刀具告警配置
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolAlarmEdit(Map<String, Object> param,
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
			String departmentID,String langCode , String langValue) throws BusinessException;
	
	
	
}
